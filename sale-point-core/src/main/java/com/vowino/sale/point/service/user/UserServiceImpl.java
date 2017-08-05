/**
 * 
 */
package com.vowino.sale.point.service.user;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vowino.sale.point.model.address.Address;
import com.vowino.sale.point.model.company.Company;
import com.vowino.sale.point.model.user.User;
import com.vowino.sale.point.model.user.UserDTO;
import com.vowino.sale.point.repository.user.UserRepository;
import com.vowino.sale.point.response.MessageResponse;
import com.vowino.sale.point.service.company.CompanyService;

/**
 * @author vctro
 *
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private CompanyService companyService;

	public MessageResponse add(UserDTO dto, Long companyReferenceId) {
		MessageResponse response = new MessageResponse();
		try {
			//prepare password
			String password = encryptPassword(dto.getPassword());
			dto.setPassword(password);
			
			//prepare company
			Company company = companyService.findOne(companyReferenceId);
			dto.setCompany(company);
			
			//prepare address
			Address address = dto.getAddress();
			address.setCreateDate(new Date());
			dto.setAddress(address);
			
			//prepare user object
			User user = User.getNewInstance(dto.getFirstName(), dto.getMiddleName(), dto.getLastName(), 
					dto.getEmailAddress(), dto.getPassword(), dto.getRole(), dto.getStatus(), 
					dto.getCompany(), dto.getAddress());
			userRepository.save(user);
			response.setStatus(200);
			response.setSuccess(true);
		} catch (Exception e) {
			response.setSuccess(false);
			response.setDeveloperMessage(e.getMessage());
		}
		return response;
		
	}
	
	/*private User getUser(UserDTO dto) {
		User added = new User();
		added.setFirstName(dto.getFirstName());
		added.setMiddleName(dto.getMiddleName());
		added.setLastName(dto.getLastName());
		added.setEmailAddress(dto.getEmailAddress());
		added.setPassword(dto.getPassword());
		added.setStatus(dto.getStatus());
		added.setRole(dto.getRole());
		added.setAddress(dto.getAddress());
		added.setCompany(dto.getCompany());
		return added;
	}*/
	
	private String encryptPassword(String unEncryptedPassword) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");
		md.update(unEncryptedPassword.getBytes(),0,unEncryptedPassword.length());
		String encyptedPassword = new BigInteger(1,md.digest()).toString(16);
		return encyptedPassword;
	}
}
