/**
 * 
 */
package com.vowino.sale.point.model.user;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import com.vowino.sale.point.model.address.Address;
import com.vowino.sale.point.model.company.Company;

/**
 * @author vctro
 *
 */
public class UserDTO {
	private Long userReferenceId;
	private String firstName;
	private String middleName;
	private String lastName;
	private String emailAddress;
	private String password;
	private String role;
	private String status;
	private Company company;
	private Address address;
	
	private UserDTO() {
	}
	/**
	 * 
	 * @param firstName
	 * @param middleName
	 * @param lastName
	 * @param emailAddress
	 * @param password
	 * @param role
	 * @param status
	 */
	private UserDTO(String firstName, String middleName, String lastName, String emailAddress, 
			String password, String role, String status, Address address) {
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.emailAddress = emailAddress;
		this.password = password;
		this.role = role;
		this.status = status;
		this.address = address;
	}
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
	 * @return the latName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param latName the latName to set
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
	 * @return the company
	 */
	public Company getCompany() {
		return company;
	}
	/**
	 * @param company the company to set
	 */
	public void setCompany(Company company) {
		this.company = company;
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
	public static UserDTO getNewInstance(String firstName, String middleName, String lastName, String emailAddress, 
			String password, String role, String status, Address address) {
		return new UserDTO(firstName, middleName, lastName, emailAddress, password, role, status, address);
	}
}
