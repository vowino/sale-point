/**
 * 
 */
package com.vowino.sale.point.service.sale;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.vowino.sale.point.Utility;
import com.vowino.sale.point.model.company.Company;
import com.vowino.sale.point.model.material.Material;
import com.vowino.sale.point.model.sale.Sale;
import com.vowino.sale.point.model.sale.SaleDTO;
import com.vowino.sale.point.model.sale.SaleDetail;
import com.vowino.sale.point.model.sale.SaleDetailRequestInput;
import com.vowino.sale.point.repository.sale.SaleDetailRepository;
import com.vowino.sale.point.repository.sale.SaleRepository;
import com.vowino.sale.point.response.MessageResponse;
import com.vowino.sale.point.service.company.CompanyService;
import com.vowino.sale.point.service.material.MaterialService;

/**
 * @author vctro
 *
 */
@Service
@Transactional
class SaleServiceImpl implements SaleService {
	@Autowired
	private SaleRepository saleRepository;
	@Autowired
	private SaleDetailRepository saleDetailRepository;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private MaterialService materialService;
	private static final String SALES_SIZE_ERROR = "There should be atleast one sale.";
	private static final String SALES_AMOUNT_ERROR = "SALES AMOUNT NOT SAME AS THE TOTAL YOU SUBMITTED.";
	private static final String SALES_QUANTITY_ERROR = "QUANTITY NOT SAME AS THE TOTAL YOU SUBMITTED.";
	
	/* (non-Javadoc)
	 * @see com.vowino.sale.point.service.sale.SaleService#add(com.vowino.sale.point.model.sale.SaleDTO, 
	 * java.lang.Long)
	 */
	public MessageResponse save(SaleDTO dto, Long companyReferenceId) {
		MessageResponse response = new MessageResponse();
		final String METHOD = "add(SaleDTO dto, Long companyReferenceId) : "; 
		Double amount = 0.0;
		Double qty = 0.0;
		Set<SaleDetail> saleDetails = new HashSet<SaleDetail>();
		try {
			Assert.notNull(companyReferenceId, Utility.getErrorMessage(this.getClass().getSimpleName(),
					METHOD, Utility.COMPANY_REF_ID_ERROR));
			Assert.isTrue(dto.getSaleDetails().size()>0, 
					Utility.getErrorMessage(this.getClass().getSimpleName(), METHOD, SALES_SIZE_ERROR));
			
			for(SaleDetailRequestInput detail : dto.getSaleDetails()) {
				amount =amount+detail.getAmount();
				qty =qty+detail.getQuantity();
			}
			
			Assert.isTrue(amount.intValue()==dto.getAmount().intValue(), 
					Utility.getErrorMessage(this.getClass().getSimpleName(), METHOD, SALES_AMOUNT_ERROR));
			
			Assert.isTrue(qty.intValue()==dto.getQuantity().intValue(), 
					Utility.getErrorMessage(this.getClass().getSimpleName(), METHOD, SALES_QUANTITY_ERROR));
			
			//prepare company
			Company company = companyService.findOne(companyReferenceId);
			dto.setCompany(company);
			
			Sale sale = Sale.getNewInstance(null, dto.getBuyerName(), dto.getBuyerPhoneNumber(),
					dto.getSaleDate(), dto.getCreatedBy(), dto.getQuantity(), dto.getAmount(),
					dto.getCompany(), saleDetails);
			saleRepository.save(sale);
			
			for(SaleDetailRequestInput detail : dto.getSaleDetails()) {
				Material material = materialService.findOne(detail.getMaterialReferenceId());
				SaleDetail saleDetail = new SaleDetail();
				saleDetail.setAmount(detail.getAmount());
				saleDetail.setQuantity(detail.getQuantity());
				saleDetail.setMaterial(material);
				saleDetails.add(saleDetail);
				saleDetail.setSale(sale);
				saleDetailRepository.save(saleDetail);
			}
			
			response.setStatus(200);
			response.setSuccess(true);
		}catch(Exception e) {
			response.setSuccess(false);
			response.setDeveloperMessage(e.getMessage());
			e.printStackTrace();
		}
		return response;
	}

	/* (non-Javadoc)
	 * @see com.vowino.sale.point.service.sale.SaleService#findOne(java.lang.Long)
	 */
	public Sale findOne(Long saleReferenceId) {
		return saleRepository.findOne(saleReferenceId);
	}
	
	public List<Sale> findByCompanyReferenceId(Long companyReferenceId, String transStartDate, 
			String transEndDate) {
		transStartDate = (StringUtils.isEmpty(transStartDate))? Utility.DEFAULT_DATE+Utility.FORMAT_DATE
				: transStartDate+Utility.FORMAT_DATE;
		transEndDate = (StringUtils.isEmpty(transEndDate))? Utility.getCurrentDate().toString() 
				: transEndDate+Utility.FORMAT_DATE;
			
		Date aTransStartDate = Utility.dateConverter(transStartDate);
		Date aTransEndDate = Utility.dateConverter(transEndDate);
		return saleRepository.findByCompanyReferenceId(companyReferenceId, aTransStartDate, aTransEndDate);
	}
}
