/**
 * 
 */
package com.vowino.sale.point.repository.material;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vowino.sale.point.model.material.Material;

/**
 * @author vctro
 *
 */
public interface MaterialRepository extends JpaRepository<Material, Long> {
	@Query("SELECT M FROM Material M WHERE M.company.companyreferenceId = ?1 AND M.createdDate "
	+ "BETWEEN ?2 AND ?3")
	public List<Material> findByCompanyReferenceId(Long companyReferenceId, Date cStartDate, Date cEndDate);
}
