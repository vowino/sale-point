/**
 * 
 */
package com.vowino.sale.point.model.sale;

/**
 * @author vctro
 *
 */
public class SaleDetailRequestInput {
	private Double quantity;
	private Double amount;
	private Long materialReferenceId;
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
}
