/**
 * 
 */
package com.vowino.sale.point.service.sale;

import org.springframework.beans.factory.annotation.Autowired;

import com.vowino.sale.point.model.sale.SaleDetail;
import com.vowino.sale.point.model.sale.SaleDetailDTO;
import com.vowino.sale.point.repository.sale.SaleDetailRepository;
import com.vowino.sale.point.response.MessageResponse;

/**
 * @author vctro
 *
 */
public class SaleDetailServiceImpl implements SaleDetailService {
	@Autowired
	private SaleDetailRepository saleDetailRepository;

	/* (non-Javadoc)
	 * @see com.vowino.sale.point.service.sale.SaleDetailService#add(com.vowino.sale.point.model.sale.SaleDetailDTO)
	 */
	public MessageResponse save(SaleDetailDTO dto) {
		return null;
	}

	/* (non-Javadoc)
	 * @see com.vowino.sale.point.service.sale.SaleDetailService#findOne(java.lang.Long)
	 */
	public SaleDetail findOne(Long saleDetailReferenceId) {
		// TODO Auto-generated method stub
		return null;
	}

}
