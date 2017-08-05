/**
 * 
 */
package com.vowino.sale.point.service.company;

import com.vowino.sale.point.model.company.Company;
import com.vowino.sale.point.model.company.CompanyDTO;
import com.vowino.sale.point.response.MessageResponse;

/**
 * @author vctro
 *
 */
public interface CompanyService {
	public MessageResponse save(CompanyDTO dto);
	public Company findOne(Long companyReferenceId);
	public void delete(Long companyReferenceId);

}
