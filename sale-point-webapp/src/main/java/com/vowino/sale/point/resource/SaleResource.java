/**
 * 
 */
package com.vowino.sale.point.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vowino.sale.point.SaleRequestInput;
import com.vowino.sale.point.Utility;
import com.vowino.sale.point.model.sale.Sale;
import com.vowino.sale.point.model.sale.SaleDTO;
import com.vowino.sale.point.response.MessageResponse;
import com.vowino.sale.point.service.sale.SaleService;

/**
 * @author vctro
 *
 */
@RestController
@RequestMapping(value="/salepoint/sales")
public class SaleResource {
	@Autowired
	private SaleService saleService;
	
	@PermitAll
	@RequestMapping(method = RequestMethod.POST)
	public MessageResponse save(HttpServletRequest request, 
			@Valid @RequestBody SaleRequestInput saleReqInput) {
		Long companyReferenceId = Long.valueOf(request.getHeader("companyReferenceId"));
		SaleDTO dto = SaleDTO.getNewInstance(saleReqInput.getBuyerName(), saleReqInput.getBuyerPhoneNumber(),
				Utility.dateConverter(saleReqInput.getSaleDate()), saleReqInput.getCreatedBy(), 
				saleReqInput.getQuantity(), saleReqInput.getAmount(), null, saleReqInput.getSaleDetails());
		return saleService.save(dto, companyReferenceId);
	}
	@PermitAll
	@RequestMapping(method = RequestMethod.GET)
	public List<Sale> findByCompanyReferenceId(HttpServletRequest request, 
			@RequestParam(value="start-date", defaultValue="") String transStartDate, 
			@RequestParam(value="end-date", defaultValue="") String transEndDate) {
		Long companyReferenceId = Long.valueOf(request.getHeader("companyReferenceId"));
		return saleService.findByCompanyReferenceId(companyReferenceId, transStartDate, transEndDate);
	}	
}
