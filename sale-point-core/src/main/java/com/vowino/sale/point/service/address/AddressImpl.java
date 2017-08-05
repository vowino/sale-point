/**
 * 
 */
package com.vowino.sale.point.service.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.vowino.sale.point.model.address.Address;
import com.vowino.sale.point.model.address.AddressDTO;
import com.vowino.sale.point.repository.address.AddressRepository;
import com.vowino.sale.point.response.MessageResponse;

/**
 * @author vctro
 *
 */
@Service
@Transactional
public class AddressImpl implements AddressService {
	@Autowired
	private AddressRepository addressRepository;

	/* (non-Javadoc)
	 * @see com.vowino.sale.point.address.service.AddressService#add(com.vowino.sale.point.address.service.AddressDTO)
	 */
	public MessageResponse add(AddressDTO dto) {
		MessageResponse response = new MessageResponse();
		try{
			Address address = new Address();
			address.setStreet(dto.getStreet());
			address.setDistric(dto.getDistric());
			address.setRegion(dto.getRegion());
			address.setCreatedBy(dto.getCreatedBy());
			address.setCreateDate(dto.getCreateDate());
			addressRepository.save(address);
			response.setStatus(200);
			response.setSuccess(true);
		}catch(Exception e) {
			response.setSuccess(false);
			response.setDeveloperMessage(e.getMessage());
		}
		return response;
	}

	public Address findOne(Long addressReferenceId) {
		return addressRepository.findOne(addressReferenceId);
	}

	public MessageResponse delete(Long addressReferenceId) {
		MessageResponse response = new MessageResponse();
		try{
			addressRepository.delete(addressReferenceId);
			response.setStatus(200);
			response.setSuccess(true);			
		}catch(Exception e) {
			response.setSuccess(false);
			response.setDeveloperMessage(e.getMessage());
			
		}
		return response;
	}

}
