/**
 * 
 */
package com.vowino.sale.point.service.material;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.vowino.sale.point.Utility;
import com.vowino.sale.point.model.company.Company;
import com.vowino.sale.point.model.material.Material;
import com.vowino.sale.point.model.material.MaterialActivity;
import com.vowino.sale.point.model.material.MaterialActivityDTO;
import com.vowino.sale.point.model.material.MaterialDTO;
import com.vowino.sale.point.repository.material.MaterialActivityRepository;
import com.vowino.sale.point.repository.material.MaterialRepository;
import com.vowino.sale.point.response.MessageResponse;
import com.vowino.sale.point.service.company.CompanyService;

/**
 * @author vctro
 *
 */
@Service
@Transactional
public class MaterialServiceImpl implements MaterialService {
	@Autowired
	private MaterialRepository materialRepository;
	@Autowired
	private CompanyService companyService;
	@Autowired
	private MaterialActivityRepository materialActivityRepository;

	/* (non-Javadoc)
	 * @see com.vowino.sale.point.material.service.MaterialService
	 * #add(com.vowino.sale.point.material.model.MaterialDTO)
	 */
	public MessageResponse save(MaterialDTO dto, Long companyReferenceId) {
		MessageResponse response = new MessageResponse();
		try{
			//prepare company
			Company company = companyService.findOne(companyReferenceId);
			dto.setCompany(company);
			
			materialRepository.save(Material.getNewInstance(null,dto.getName(), dto.getDescription(), 
					dto.getQuantity(), dto.getCreateBy(), dto.getCreatedDate(), dto.getCompany(), null));
			response.setStatus(200);
			response.setSuccess(true);
		}catch(Exception e) {
			response.setSuccess(false);
			response.setDeveloperMessage(e.getMessage());			
		}
		return response;
	}

	/* (non-Javadoc)
	 * @see com.vowino.sale.point.material.service.MaterialService#findOne(java.lang.Long)
	 */
	public Material findOne(Long materialReferenceId) {
		return materialRepository.findOne(materialReferenceId);
	}
	/* (non-Javadoc)
	 * @see com.vowino.sale.point.material.service.MaterialService#add(MaterialActivityDTO dto)
	 */
	public MessageResponse save(MaterialActivityDTO dto, Long companyReferenceId) {
		MessageResponse response = new MessageResponse();
		try{
			//prepare company
			Company company = companyService.findOne(companyReferenceId);
			
			//prepare material
			Material material = materialRepository.findOne(dto.getMaterial().getMaterialReferenceId());
			Assert.isTrue(companyReferenceId==material.getCompany().getCompanyreferenceId(),
					"Companies are diffence!");
			Integer materialQty = material.getQuantity() + dto.getQuantity();
			material.setQuantity(materialQty);
			material.setCompany(company);
			//save the activity
			materialActivityRepository.save(MaterialActivity.getNewInstance(dto.getQuantity(), 
					dto.getCreatedBy(), new Date(), material));
			response.setStatus(200);
			response.setSuccess(true);	
		}catch(Exception e) {
			response.setSuccess(false);
			response.setDeveloperMessage(e.getMessage());	
		}
		return response;
	}

	public List<Material> findByCompanyReferenceId(Long companyReferenceId, String cStartDate, String cEndDate) {
		cStartDate = (StringUtils.isEmpty(cStartDate))? Utility.DEFAULT_DATE+Utility.FORMAT_DATE
				: cStartDate+Utility.FORMAT_DATE;
		cEndDate = (StringUtils.isEmpty(cEndDate))? Utility.getCurrentDate().toString() 
				: cEndDate+Utility.FORMAT_DATE;
		
		Date aStartDate = Utility.dateConverter(cStartDate);
		Date aEndDate = Utility.dateConverter(cEndDate);
		return materialRepository.findByCompanyReferenceId(companyReferenceId, aStartDate, aEndDate);
	}

	public MaterialActivity findActivitiesByCompanyReferenceId(Long companyReferenceId, String cStartDate, String cEndDate) {
		cStartDate = (StringUtils.isEmpty(cStartDate))? Utility.DEFAULT_DATE+Utility.FORMAT_DATE
				: cStartDate+Utility.FORMAT_DATE;
		cEndDate = (StringUtils.isEmpty(cEndDate))? Utility.getCurrentDate().toString() 
				: cEndDate+Utility.FORMAT_DATE;
		
		Date aStartDate = Utility.dateConverter(cStartDate);
		Date aEndDate = Utility.dateConverter(cEndDate);

		return materialActivityRepository.findActivitiesByCompanyReferenceId(companyReferenceId, aStartDate, aEndDate);
	}

	public MaterialActivity findActivitiesByMaterialReferenceId(Long materialReferenceId, String cStartDate, 
			String cEndDate) {
		cStartDate = (StringUtils.isEmpty(cStartDate))? Utility.DEFAULT_DATE+Utility.FORMAT_DATE
				: cStartDate+Utility.FORMAT_DATE;
		cEndDate = (StringUtils.isEmpty(cEndDate))? Utility.getCurrentDate().toString() 
				: cEndDate+Utility.FORMAT_DATE;
		
		Date aStartDate = Utility.dateConverter(cStartDate);
		Date aEndDate = Utility.dateConverter(cEndDate);
		return materialActivityRepository.findActivitiesByMaterialReferenceId(materialReferenceId, aStartDate, aEndDate);
	}

}
