/**
 * 
 */
package com.vowino.sale.point.resource;

import java.util.Date;
import java.util.List;

import javax.annotation.security.PermitAll;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.vowino.sale.point.MaterialActivityRequestInput;
import com.vowino.sale.point.MaterialRequestInput;
import com.vowino.sale.point.model.material.Material;
import com.vowino.sale.point.model.material.MaterialActivityDTO;
import com.vowino.sale.point.model.material.MaterialDTO;
import com.vowino.sale.point.response.MessageResponse;
import com.vowino.sale.point.service.material.MaterialService;

/**
 * @author vctro
 *
 */
@RestController
@RequestMapping(value="/salepoint/materials")
public class MaterialResource {
	@Autowired
	private MaterialService materialService;
	
	@PermitAll
	@RequestMapping(method = RequestMethod.POST)
	public MessageResponse add(HttpServletRequest request, 
			@Valid @RequestBody MaterialRequestInput materialReqInput) {
		Long companyReferenceId = Long.valueOf(request.getHeader("companyReferenceId"));
		MaterialDTO dto = MaterialDTO.getNewInstance(materialReqInput.getName(), 
				materialReqInput.getDescription(), 0, materialReqInput.getCreatedBy(), new Date(), null);
		return materialService.save(dto, companyReferenceId);
	}
	
	@PermitAll
	@RequestMapping(value="/{materialReferenceId}/material-activities",method = RequestMethod.POST)
	public MessageResponse add(HttpServletRequest request, 
			@PathVariable("materialReferenceId") Long materialReferenceId,
			@Valid @RequestBody MaterialActivityRequestInput materialActivityReqInput) {
		Long companyReferenceId = Long.valueOf(request.getHeader("companyReferenceId"));
		Material material = Material.getNewInstance(materialReferenceId);
		MaterialActivityDTO dto = MaterialActivityDTO.getNewInstance(null, 
				materialActivityReqInput.getQuantity(),materialActivityReqInput.getCreatedBy(), new Date(),
				material);
		return materialService.save(dto, companyReferenceId);
	}
	
	@PermitAll
	@RequestMapping(method = RequestMethod.GET)
	public List<Material> findByCompanyReferenceId(HttpServletRequest request,
			@RequestParam(value="start-date", defaultValue="") String cStartDate, 
			@RequestParam(value="end-date", defaultValue="") String cEndDate) {
		
		Long companyReferenceId = Long.valueOf(request.getHeader("companyReferenceId"));
		return materialService.findByCompanyReferenceId(companyReferenceId,cStartDate,cEndDate);
	}

}
