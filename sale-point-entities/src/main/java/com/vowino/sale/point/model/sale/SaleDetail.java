/**
 * 
 */
package com.vowino.sale.point.model.sale;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.vowino.sale.point.model.material.Material;

/**
 * @author vctro
 *
 */
@Entity
@Table(name="sale_detail")
public class SaleDetail {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sale_detail_reference_id")
	private Long saleDetailReferenceId;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="sale_reference_id", nullable=false)
	private Sale sale;
	
	@OneToOne(cascade=CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="material_reference_id")
	private Material material;
	
	private Double quantity;
	private Double amount;

	/**
	 * @return the saleDetailReferenceId
	 */
	public Long getSaleDetailReferenceId() {
		return saleDetailReferenceId;
	}
	/**
	 * @param saleDetailReferenceId the saleDetailReferenceId to set
	 */
	public void setSaleDetailReferenceId(Long saleDetailReferenceId) {
		this.saleDetailReferenceId = saleDetailReferenceId;
	}
	/**
	 * @return the sale
	 */
	public Sale getSale() {
		return sale;
	}
	/**
	 * @param sale the sale to set
	 */
	public void setSale(Sale sale) {
		this.sale = sale;
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
	 * @return the quantity
	 */
	public Double getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(Double quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Transient
	@Override
	public String toString() {
		return "SaleDetail [saleDetailReferenceId=" + saleDetailReferenceId + ", sale=" + sale + ", material="
				+ material + ", quantity=" + quantity + ", amount=" + amount + "]";
	}
	

}
