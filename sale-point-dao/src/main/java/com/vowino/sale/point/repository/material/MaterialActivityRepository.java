/**
 * 
 */
package com.vowino.sale.point.repository.material;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.vowino.sale.point.model.material.MaterialActivity;

/**
 * @author vctro
 *
 */
public interface MaterialActivityRepository extends JpaRepository<MaterialActivity, Long> {
	@Query("SELECT MA FROM MaterialActivity MA WHERE MA.material.company.companyreferenceId = ?1 AND "
			+ "MA.createdDate BETWEEN ?2 AND ?3")
	public MaterialActivity findActivitiesByCompanyReferenceId(Long companyReferenceId, Date cStartDate, 
			Date cEndDate);
	
	@Query("SELECT MA FROM MaterialActivity MA WHERE MA.material.materialReferenceId = ?1 AND "
			+ "MA.createdDate BETWEEN ?2 AND ?3")
	public MaterialActivity findActivitiesByMaterialReferenceId(Long materialReferenceId, Date cStartDate, 
			Date cEndDate);

}
