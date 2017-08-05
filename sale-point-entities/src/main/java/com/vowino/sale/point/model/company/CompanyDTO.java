/**
 * 
 */
package com.vowino.sale.point.model.company;

import java.util.Date;

import com.vowino.sale.point.model.user.User;

/**
 * @author vctro
 *
 */
public class CompanyDTO {
	private Long companyreferenceId;
	private String name;
	private String createdBy;
	private Date createDate;
	
	private CompanyDTO() {}
	
	/**
	 * @param name
	 * @param createdBy
	 * @param createDate
	 */
	private CompanyDTO(String name, String createdBy, Date createDate) {
		this.name = name;
		this.createdBy = createdBy;
		this.createDate = createDate;
	}

	/**
	 * @return the companyreferenceId
	 */
	public Long getCompanyreferenceId() {
		return companyreferenceId;
	}
	/**
	 * @param companyreferenceId the companyreferenceId to set
	 */
	public void setCompanyreferenceId(Long companyreferenceId) {
		this.companyreferenceId = companyreferenceId;
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
	
	public static CompanyDTO getNewInstance(String name, String createdBy) {
		return new CompanyDTO(name, createdBy, new Date());
		
	}
}
