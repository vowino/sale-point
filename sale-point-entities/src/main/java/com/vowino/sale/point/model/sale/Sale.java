/**
 * 
 */
package com.vowino.sale.point.model.sale;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
@Table(name="sale")
public class Sale {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="sale_reference_id")
	private Long saleReferenceId;
	@Column(name="buyer_name")
	private String buyerName;
	@Column(name="buyer_phone")
	private String buyerPhoneNumber;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@Column(name="sale_date")
	private Date saleDate;
	
	@Column(name="created_by")
	private String createdBy;
	private Double quantity;
	private Double amount;
	
	@JsonSerialize(using=JsonDateSerializer.class)
	@Column(name="transaction_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date transactionDate;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="company_reference_id")
	private Company company;
	
	@OneToMany(mappedBy="sale", fetch=FetchType.EAGER, cascade = CascadeType.ALL, 
			targetEntity=SaleDetail.class)
	private Set<SaleDetail> saleDetails = new HashSet<SaleDetail>();
	
	private Sale() {
	}

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
	 * @param transactionDate
	 */
	private Sale(Long saleReferenceId, String buyerName, String buyerPhoneNumber, Date saleDate,
			String createdBy, Double quantity, Double amount, Company company, Set<SaleDetail> saleDetails,
			Date transactionDate) {
		this.saleReferenceId = saleReferenceId;
		this.buyerName = buyerName;
		this.buyerPhoneNumber = buyerPhoneNumber;
		this.saleDate = saleDate;
		this.createdBy = createdBy;
		this.quantity = quantity;
		this.amount = amount;
		this.company = company;
		this.transactionDate = transactionDate;
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
	public Set<SaleDetail> getSaleDetails() {
		return saleDetails;
	}

	/**
	 * @param saleDetails the saleDetails to set
	 */
	public void setSaleDetails(Set<SaleDetail> saleDetails) {
		this.saleDetails = saleDetails;
	}

	/**
	 * @return the transaction_date
	 */
	public Date getTransactionDate() {
		return transactionDate;
	}

	/**
	 * @param transaction_date the transaction_date to set
	 */
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}

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
	 * @param transaction_date
	 * @return
	 */
	@Transient
	public static Sale getNewInstance(Long saleReferenceId, String buyerName, String buyerPhoneNumber, 
			Date saleDate, String createdBy,Double quantity, Double amount, Company company,
			Set<SaleDetail> saleDetails) {
		return new Sale(saleReferenceId, buyerName, buyerPhoneNumber, saleDate, createdBy, quantity, 
				amount, company, saleDetails, new Date());
	}

}
