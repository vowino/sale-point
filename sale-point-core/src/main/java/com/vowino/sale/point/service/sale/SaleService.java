/**
 * 
 */
package com.vowino.sale.point.service.sale;

import java.util.List;

import com.vowino.sale.point.model.sale.Sale;
import com.vowino.sale.point.model.sale.SaleDTO;
import com.vowino.sale.point.response.MessageResponse;

/**
 * @author vctro
 *
 */
public interface SaleService {
	public MessageResponse save(SaleDTO dto, Long companyReferenceId);
	public Sale findOne(Long saleReferenceId);
	public List<Sale> findByCompanyReferenceId(Long companyReferenceId, String transStartDate, 
			String transEndDate);
}
