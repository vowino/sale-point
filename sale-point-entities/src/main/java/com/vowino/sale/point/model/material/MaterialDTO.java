/**
 * 
 */
package com.vowino.sale.point.model.material;

import java.util.Date;

import com.vowino.sale.point.model.company.Company;

/**
 * @author vctro
 *
 */
public class MaterialDTO {
	private Long materialReferenceId;
	private String name;
	private String description;
	private Integer quantity;
	private String createBy;
	private Date createdDate;
	private Company company;
	
	private MaterialDTO() {}
	/**
	 * 
	 * @param name
	 * @param description
	 * @param quantity
	 * @param createBy
	 * @param createdDate
	 * @param company
	 */
	private MaterialDTO(String name, String description, Integer quantity, String createBy, Date createdDate,
			Company company) {
		this.name = name;
		this.description = description;
		this.quantity = quantity;
		this.createBy = createBy;
		this.createdDate = createdDate;
		this.company = company;
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
	 * @param name
	 * @param description
	 * @param quantity
	 * @param createBy
	 * @param createdDate
	 * @param company
	 * @return
	 */
	public static MaterialDTO getNewInstance(String name, String description, Integer quantity, String createBy, Date createdDate,
			Company company) {
		return new MaterialDTO(name, description, quantity, createBy, createdDate, company);
	}
}
