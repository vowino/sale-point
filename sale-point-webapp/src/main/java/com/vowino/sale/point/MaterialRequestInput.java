/**
 * 
 */
package com.vowino.sale.point;

import javax.validation.constraints.NotNull;

/**
 * @author vctro
 *
 */
public class MaterialRequestInput {
	private Long materialReferenceId;
	@NotNull
	private String name;
	private String description;
	@NotNull
	private String createdBy;
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
	 * @return the createBy
	 */
	public String getCreatedBy() {
		return createdBy;
	}
	/**
	 * @param createBy the createBy to set
	 */
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
}
