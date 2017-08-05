/**
 * 
 */
package com.vowino.sale.point.model.address;

import java.util.Date;

import com.vowino.sale.point.model.user.User;

/**
 * @author vctro
 *
 */
public class AddressDTO {
	private Long addressReferenceId;
	private String street;
	private String distric;
	private String region;
	private String createdBy;
	private Date createDate;
	/**
	 * @return the addressReferenceId
	 */
	public Long getAddressReferenceId() {
		return addressReferenceId;
	}
	/**
	 * @param addressReferenceId the addressReferenceId to set
	 */
	public void setAddressReferenceId(Long addressReferenceId) {
		this.addressReferenceId = addressReferenceId;
	}
	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	/**
	 * @param street the street to set
	 */
	public void setStreet(String street) {
		this.street = street;
	}
	/**
	 * @return the distric
	 */
	public String getDistric() {
		return distric;
	}
	/**
	 * @param distric the distric to set
	 */
	public void setDistric(String distric) {
		this.distric = distric;
	}
	/**
	 * @return the region
	 */
	public String getRegion() {
		return region;
	}
	/**
	 * @param region the region to set
	 */
	public void setRegion(String region) {
		this.region = region;
	}
	/**
	 * @return the createdBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	/**
	 * @return the createDate
	 */
	public Date getCreateDate() {
		return createDate;
	}
	/**
	 * @param createDate the createDate to set
	 */
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
}
