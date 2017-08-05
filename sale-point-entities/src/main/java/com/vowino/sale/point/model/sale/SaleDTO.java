/**
 * 
 */
package com.vowino.sale.point.model.sale;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.vowino.sale.point.model.company.Company;

/**
 * @author vctro
 *
 */
public class SaleDTO {
	private Long saleReferenceId;
	private String buyerName;
	private String buyerPhoneNumber;
	private Date saleDate;
	private String createdBy;
	private Double quantity;
	private Double amount;
	private Company company;
	private Set<SaleDetailRequestInput> saleDetails = new HashSet<SaleDetailRequestInput>();
	
	/**
	 * @param saleReferenceId
	 * @param buyerName
	 * @param buyerPhoneNumber
	 * @param saleDate
	 * @param createdBy
	 * @param quantity
	 * @param amount
	 * @param company
	 * @param saleDetails
	 */
	private SaleDTO(Long saleReferenceId, String buyerName, String buyerPhoneNumber, Date saleDate, String createdBy,
			Double quantity, Double amount, Company company, Set<SaleDetailRequestInput> saleDetails) {
		this.saleReferenceId = saleReferenceId;
		this.buyerName = buyerName;
		this.buyerPhoneNumber = buyerPhoneNumber;
		this.saleDate = saleDate;
		this.createdBy = createdBy;
		this.quantity = quantity;
		this.amount = amount;
		this.company = company;
		this.saleDetails = saleDetails;
	}
	/**
	 * @return the saleReferenceId
	 */
	public Long getSaleReferenceId() {
		return saleReferenceId;
	}
	/**
	 * @param saleReferenceId the saleReferenceId to set
	 */
	public void setSaleReferenceId(Long saleReferenceId) {
		this.saleReferenceId = saleReferenceId;
	}
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
	public Date getSaleDate() {
		return saleDate;
	}
	/**
	 * @param saleDate the saleDate to set
	 */
	public void setSaleDate(Date saleDate) {
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
	/**
	 * @param buyerName
	 * @param buyerPhoneNumber
	 * @param saleDate
	 * @param createdBy
	 * @param quantity
	 * @param amount
	 * @param company
	 * @param saleDetails
	 * @return
	 */
	public static SaleDTO getNewInstance(String buyerName, String buyerPhoneNumber, Date saleDate, 
			String createdBy, Double quantity, Double amount, Company company, Set<SaleDetailRequestInput> saleDetails) {
		return new SaleDTO(null, buyerName, buyerPhoneNumber, saleDate, createdBy, quantity,
				amount, company, saleDetails);
	}
}
