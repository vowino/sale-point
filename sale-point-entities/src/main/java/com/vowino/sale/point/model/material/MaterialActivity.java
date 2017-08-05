/**
 * 
 */
package com.vowino.sale.point.model.material;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.vowino.sale.point.JsonDateSerializer;

/**
 * @author vctro
 *
 */
@Entity
@Table(name="material_activity")
public class MaterialActivity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="material_activity_reference_id")
	private Long activityReferenceId;
	
	private Integer quantity;
	
	@Column(name="created_by")
	private String createdBy;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@Column(name="created_date")
	private Date createdDate;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="material_reference_id", nullable=false)
	private Material material;
	
	private MaterialActivity() {}
	
	/**
	 * @param activityReferenceId
	 * @param quantity
	 * @param createdBy
	 * @param createdDate
	 * @param material
	 */
	private MaterialActivity(Long activityReferenceId, Integer quantity, String createdBy, Date createdDate,
			Material material) {
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
	 * @param createDate the createDate to set
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
	 * @param quantity
	 * @param createdBy
	 * @param createdDate
	 * @param material
	 * @return
	 */
	@Transient
	public static MaterialActivity getNewInstance(Integer quantity, String createdBy, Date createdDate,
			Material material) {
		return new MaterialActivity(null, quantity, createdBy, createdDate, material);		
	}
}
