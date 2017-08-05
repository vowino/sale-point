/**
 * 
 */
package com.vowino.sale.point.resource;

import java.util.List;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vowino.sale.point.UserRequestInput;
import com.vowino.sale.point.model.user.User;
import com.vowino.sale.point.model.user.UserDTO;
import com.vowino.sale.point.response.MessageResponse;
import com.vowino.sale.point.service.user.UserService;

/**
 * @author vctro
 *
 */
@RestController
@RequestMapping(value="/sales/users")
public class UserResource {
	@Autowired
	private UserService userService;
	
	@PermitAll
	@RequestMapping(method = RequestMethod.POST)
	public MessageResponse add(HttpServletRequest request,@Valid @RequestBody UserRequestInput userInput) {
		Long companyReferenceId = Long.valueOf(request.getHeader("companyReferenceId"));
		UserDTO user = UserDTO.getNewInstance(userInput.getFirstName(), userInput.getMiddleName(), userInput.getLastName(), 
				userInput.getEmailAddress(), userInput.getPassword(), userInput.getRole(), userInput.getStatus(), userInput.getAddress());
		
		return userService.add(user, companyReferenceId);
	}
	@PermitAll
	@RequestMapping(value="/{userReferenceId}/", method = RequestMethod.PUT)
	public MessageResponse update(@PathVariable int userReferenceId,@Valid @RequestBody UserDTO updatedUser) {
		return null;
	}
	@PermitAll
	@RequestMapping(value="/{userReferenceId}/", method = RequestMethod.DELETE)
	public MessageResponse delete(@PathVariable int userReferenceId) {
		return null;
	}
	@PermitAll
	@RequestMapping(method = RequestMethod.GET)
	public List<User> listOfUsers(@RequestHeader Long companyReferenceId) {
		return null;
	}
	
	@PermitAll
	@RequestMapping(value="/{userReferenceId}", method = RequestMethod.GET)
	public User getUser(@RequestHeader Long companyReferenceId, @PathVariable Long userReferenceId) {
		return null;
	}

}
