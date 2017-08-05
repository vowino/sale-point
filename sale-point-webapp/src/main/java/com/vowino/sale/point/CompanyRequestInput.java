/**
 * 
 */
package com.vowino.sale.point;

import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * @author vctro
 *
 */
public class CompanyRequestInput {
	private Long companyReferenceId;
	@NotNull
	private String name;
	@NotNull
	private String createdBy;
	private Date createDate;
	
	/**
	 * @return the companyreferenceId
	 */
	public Long getCompanyreferenceId() {
		return companyReferenceId;
	}
	/**
	 * @param companyreferenceId the companyreferenceId to set
	 */
	public void setCompanyreferenceId(Long companyReferenceId) {
		this.companyReferenceId = companyReferenceId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
