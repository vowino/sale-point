/**
 * 
 */
package com.vowino.sale.point;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.vowino.sale.point.model.address.Address;

/**
 * @author vctro
 *
 */
public class UserRequestInput {
	private Long userReferenceId;
	@NotNull
	private String firstName;
	private String middleName;
	@NotNull
	private String lastName;
	@NotNull
	private String emailAddress;
	@NotNull
	private String password;
	private String role;
	private String status;
	@Valid
	@NotNull
	private Address address;
	/**
	 * @return the userReferenceId
	 */
	public Long getUserReferenceId() {
		return userReferenceId;
	}
	/**
	 * @param userReferenceId the userReferenceId to set
	 */
	public void setUserReferenceId(Long userReferenceId) {
		this.userReferenceId = userReferenceId;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the emailAddress
	 */
	public String getEmailAddress() {
		return emailAddress;
	}
	/**
	 * @param emailAddress the emailAddress to set
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the role
	 */
	public String getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public void setRole(String role) {
		this.role = role;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
}
