/**
 * 
 */
package com.vowino.sale.point.service.sale;

import java.util.Set;

import com.vowino.sale.point.model.sale.Sale;
import com.vowino.sale.point.model.sale.SaleDetail;
import com.vowino.sale.point.model.sale.SaleDetailDTO;
import com.vowino.sale.point.response.MessageResponse;

/**
 * @author vctro
 *
 */
public interface SaleDetailService {
	public MessageResponse save(SaleDetailDTO dto);
	public SaleDetail findOne(Long saleDetailReferenceId);

}
