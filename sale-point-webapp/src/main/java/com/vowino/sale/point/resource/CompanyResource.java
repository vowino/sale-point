/**
 * 
 */
package com.vowino.sale.point.resource;

import javax.annotation.security.PermitAll;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vowino.sale.point.CompanyRequestInput;
import com.vowino.sale.point.model.company.CompanyDTO;
import com.vowino.sale.point.response.MessageResponse;
import com.vowino.sale.point.service.company.CompanyService;

/**
 * @author vctro
 *
 */
@RestController
@RequestMapping(value="/salepoint/companies")
public class CompanyResource {
	@Autowired
	private CompanyService companyService;
	@PermitAll
	@RequestMapping(method = RequestMethod.POST)
	public MessageResponse add(@Valid @RequestBody CompanyRequestInput companyReqInput) {
		return companyService.save(CompanyDTO.getNewInstance(companyReqInput.getName(), companyReqInput.getCreatedBy()));
	}

}
