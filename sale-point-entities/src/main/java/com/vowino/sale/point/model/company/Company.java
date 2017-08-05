/**
 * 
 */
package com.vowino.sale.point.model.company;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vowino.sale.point.JsonDateSerializer;

/**
 * @author vctro
 *
 */
@Entity
@Table(name="company")
public class Company {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="company_reference_id")
	private Long companyreferenceId;
	
	private String name;
	@Column(name="created_by")
	private String createdBy;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@Column(name="created_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
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
	public Company() {}
	/**
	 * @param name
	 * @param createdBy
	 * @param createDate
	 */
	private Company(String name, String createdBy, Date createDate) {
		this.name = name;
		this.createdBy = createdBy;
		this.createDate = createDate;
	}
	
	public static Company getNewInstance(String name, String createdBy, Date createDate) {
		return new Company(name, createdBy, createDate);
	}
}
