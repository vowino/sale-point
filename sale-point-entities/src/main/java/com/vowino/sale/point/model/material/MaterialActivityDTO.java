/**
 * 
 */
package com.vowino.sale.point.model.material;

import java.util.Date;
/**
 * @author vctro
 *
 */
public class MaterialActivityDTO {
	private Long activityReferenceId;
	private Integer quantity;
	private String createdBy;
	private Date createdDate;
	private Material material;
	
	private MaterialActivityDTO() {}
	
	/**
	 * @param activityReferenceId
	 * @param quantity
	 * @param createdBy
	 * @param createdDate
	 * @param material
	 */
	private MaterialActivityDTO(Long activityReferenceId, Integer quantity, String createdBy, 
			Date createdDate, Material material) {
		this.activityReferenceId = activityReferenceId;
		this.quantity = quantity;
		this.createdBy = createdBy;
		this.createdDate = createdDate;
		this.material = material;
	}

	/**
	 * @return the activityReferenceId
	 */
	public Long getActivityReferenceId() {
		return activityReferenceId;
	}
	/**
	 * @param activityReferenceId the activityReferenceId to set
	 */
	public void setActivityReferenceId(Long activityReferenceId) {
		this.activityReferenceId = activityReferenceId;
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
	 * @return the material
	 */
	public Material getMaterial() {
		return material;
	}
	/**
	 * @param material the material to set
	 */
	public void setMaterial(Material material) {
		this.material = material;
	}
	/**
	 * @param activityReferenceId
	 * @param quantity
	 * @param createdBy
	 * @param createdDate
	 * @param material
	 * @return
	 */
	public static MaterialActivityDTO getNewInstance(Long activityReferenceId, Integer quantity, 
			String createdBy, Date createdDate, Material material) {
		return new MaterialActivityDTO(activityReferenceId, quantity, createdBy, createdDate, material);
	}
}
