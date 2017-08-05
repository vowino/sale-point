/**
 * 
 */
package com.vowino.sale.point.service.material;

import java.util.List;

import com.vowino.sale.point.model.material.Material;
import com.vowino.sale.point.model.material.MaterialActivity;
import com.vowino.sale.point.model.material.MaterialActivityDTO;
import com.vowino.sale.point.model.material.MaterialDTO;
import com.vowino.sale.point.response.MessageResponse;

/**
 * @author vctro
 *
 */
public interface MaterialService {
	public MessageResponse save(MaterialDTO dto, Long companyReferenceId);
	public Material findOne(Long materilReferenceId);
	public List<Material> findByCompanyReferenceId(Long companyReferenceId, String cStartDate, String cEndDate);
	
	public MessageResponse save(MaterialActivityDTO dto, Long compReferenceId);
	public MaterialActivity findActivitiesByCompanyReferenceId(Long companyReferenceId, String cStartDate, 
			String cEndDate);
	public MaterialActivity findActivitiesByMaterialReferenceId(Long materialReferenceId, String cStartDate, 
			String cEndDate);
}
