/**
 * 
 */
package com.vowino.sale.point.repository.sale;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vowino.sale.point.model.sale.Sale;

/**
 * @author vctro
 *
 */
public interface SaleRepository extends JpaRepository<Sale, Long> {
	@Query("SELECT S FROM Sale S WHERE S.company.companyreferenceId = ?1 AND S.transactionDate "
			+ "BETWEEN ?2 AND ?3")
	public List<Sale> findByCompanyReferenceId(Long companyReferenceId, Date transStartDate, 
			Date transEndDate);
}
