/**
 * 
 */
package com.vowino.sale.point.service.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vowino.sale.point.model.company.Company;
import com.vowino.sale.point.model.company.CompanyDTO;
import com.vowino.sale.point.repository.company.CompanyRepository;
import com.vowino.sale.point.response.MessageResponse;

/**
 * @author vctro
 *
 */
@Service
@Transactional
class CompanyServiceImpl implements CompanyService {
	@Autowired
	private CompanyRepository companyRepository;

	/* (non-Javadoc)
	 * @see com.vowino.sale.point.company.service.CompanyService#add(com.vowino.sale.point.company.model.CompanyDTO)
	 */
	public MessageResponse save(CompanyDTO dto) {
		MessageResponse response = new MessageResponse();
		try{
			companyRepository.save(Company.getNewInstance(dto.getName(), dto.getCreatedBy(), dto.getCreateDate()));
			response.setStatus(200);
			response.setSuccess(true);
		}catch(Exception e) {
			response.setSuccess(false);
			response.setDeveloperMessage(e.getMessage());
		}
		return response;
	}
	
	public Company findOne(Long companyReferenceId) {
		return companyRepository.findOne(companyReferenceId);
	}
	
	public void delete(Long companyReferenceId) {
		companyRepository.delete(companyReferenceId);		
	}

}
