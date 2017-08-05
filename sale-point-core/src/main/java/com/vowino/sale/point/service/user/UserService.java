/**
 * 
 */
package com.vowino.sale.point.service.user;

import com.vowino.sale.point.model.user.UserDTO;
import com.vowino.sale.point.response.MessageResponse;

/**
 * @author vctro
 *
 */
public interface UserService {
	public MessageResponse add(UserDTO dto, Long companyReferenceId);

}
