/**
 * 
 */
package com.vowino.sale.point;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import com.vowino.sale.point.model.company.Company;
import com.vowino.sale.point.model.sale.SaleDetail;
import com.vowino.sale.point.model.sale.SaleDetailRequestInput;

/**
 * @author vctro
 *
 */
public class SaleRequestInput {
	@NotNull
	private String buyerName;
	private String buyerPhoneNumber;
	@NotNull
	private String saleDate;
	@NotNull
	private String createdBy;
	@NotNull
	@Min(value=1)
	private Double quantity;
	@NotNull
	@Min(value=1)
	private Double amount;
	@NotNull
	private Set<SaleDetailRequestInput> saleDetails = new HashSet<SaleDetailRequestInput>();
	/**
	 * @return the buyerName
	 */
	public String getBuyerName() {
		return buyerName;
	}
	/**
	 * @param buyerName the buyerName to set
	 */
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	/**
	 * @return the buyerPhoneNumber
	 */
	public String getBuyerPhoneNumber() {
		return buyerPhoneNumber;
	}
	/**
	 * @param buyerPhoneNumber the buyerPhoneNumber to set
	 */
	public void setBuyerPhoneNumber(String buyerPhoneNumber) {
		this.buyerPhoneNumber = buyerPhoneNumber;
	}
	/**
	 * @return the saleDate
	 */
	public String getSaleDate() {
		return saleDate;
	}
	/**
	 * @param saleDate the saleDate to set
	 */
	public void setSaleDate(String saleDate) {
		this.saleDate = saleDate;
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
	 * @return the saleDetails
	 */
	public Set<SaleDetailRequestInput> getSaleDetails() {
		return saleDetails;
	}
	/**
	 * @param saleDetails the saleDetails to set
	 */
	public void setSaleDetails(Set<SaleDetailRequestInput> saleDetails) {
		this.saleDetails = saleDetails;
	}
}
