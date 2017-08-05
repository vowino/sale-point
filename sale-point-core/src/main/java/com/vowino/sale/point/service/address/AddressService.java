/**
 * 
 */
package com.vowino.sale.point.service.address;

import com.vowino.sale.point.model.address.Address;
import com.vowino.sale.point.model.address.AddressDTO;
import com.vowino.sale.point.response.MessageResponse;

/**
 * @author vctro
 *
 */
public interface AddressService {
	public MessageResponse add(AddressDTO dto);
	public Address findOne(Long addressReferenceId);
	public MessageResponse delete(Long addressReferenceId);

}
