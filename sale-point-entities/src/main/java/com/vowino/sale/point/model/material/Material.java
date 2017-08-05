/**
 * 
 */
package com.vowino.sale.point.model.material;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vowino.sale.point.JsonDateSerializer;
import com.vowino.sale.point.model.company.Company;

/**
 * @author vctro
 *
 */
@Entity
@Table(name="material")
public class Material {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="material_reference_id")
	private Long materialReferenceId;
	
	private String name;
	private String description;
	private Integer quantity;
	
	@Column(name="created_by")
	private String createBy;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@Column(name="created_date")
	private Date createdDate;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="company_reference_id")
	private Company company;
	
	@JsonIgnore
	@OneToMany(mappedBy="material", fetch=FetchType.LAZY)
	private Set<MaterialActivity> materialActivities = new HashSet<MaterialActivity>(0);
	
	private Material() {}

	/**
	 * @param materialReferenceId
	 * @param name
	 * @param description
	 * @param quantity
	 * @param createBy
	 * @param createdDate
	 * @param company
	 * @param materialActivities
	 */
	private Material(Long materialReferenceId, String name, String description, Integer quantity,
			String createBy, Date createdDate, Company company, Set<MaterialActivity> materialActivities) {
		this.materialReferenceId = materialReferenceId;
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.createBy = createBy;
		this.createdDate = createdDate;
		this.company = company;
		this.materialActivities = materialActivities;
	}
	
	/**
	 * @param materialReferenceId
	 */
	private Material(Long materialReferenceId) {
		this.materialReferenceId = materialReferenceId;
	}

	/**
	 * @return the materialReferenceId
	 */
	public Long getMaterialReferenceId() {
		return materialReferenceId;
	}
	/**
	 * @param materialReferenceId the materialReferenceId to set
	 */
	public void setMaterialReferenceId(Long materialReferenceId) {
		this.materialReferenceId = materialReferenceId;
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
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the quantity
	 */
	public Integer getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the createBy
	 */
	public String getCreateBy() {
		return createBy;
	}
	/**
	 * @param createBy the createBy to set
	 */
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/**
	 * @return the createdDate
	 */
	public Date getCreatedDate() {
		return createdDate;
	}
	/**
	 * @param createdDate the createdDate to set
	 */
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
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
	 * @return the materialActivities
	 */
	public Set<MaterialActivity> getMaterialActivities() {
		return materialActivities;
	}
	/**
	 * @param materialActivities the materialActivities to set
	 */
	public void setMaterialActivities(Set<MaterialActivity> materialActivities) {
		this.materialActivities = materialActivities;
	}
	@Transient
	public static Material getNewInstance(Long materialReferenceId, String name, String description, 
			Integer quantity, String createBy, Date createdDate, Company company, 
			Set<MaterialActivity> materialActivities) {
		return new Material(materialReferenceId, name, description, quantity, createBy, createdDate, company,
				materialActivities);
	}
	
	@Transient
	public static Material getNewInstance(Long materialReferenceId) {
		return new Material(materialReferenceId);
	}
}
