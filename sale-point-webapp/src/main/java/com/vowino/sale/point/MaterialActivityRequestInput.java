/**
 * 
 */
package com.vowino.sale.point;

import javax.validation.constraints.NotNull;


/**
 * @author vctro
 *
 */
public class MaterialActivityRequestInput {
	@NotNull
	private Integer quantity;
	@NotNull
	private String createdBy;

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
}
