/**
 * 
 */
package com.vowino.sale.point.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.vowino.sale.point.service.address.AddressService;
import com.vowino.sale.point.service.company.CompanyService;

/**
 * @author vctro
 *
 */
@RestController
public class HelloResource {
	@Autowired
	private AddressService addressService;
	@Autowired
	private CompanyService companyService;
	@RequestMapping(method = RequestMethod.GET)
	public String helloWorld() {
		/*AddressDTO addressDto = new AddressDTO();
		addressDto.setCreateDate(new Date());
		addressDto.setCreatedBy("vctrowino@yahoo.com");
		addressDto.setDistric("Musoma");
		addressDto.setRegion("Mara");
		addressDto.setStreet("Karume");
		addressService.add(addressDto);
		CompanyDTO compDto = new CompanyDTO();
		compDto.setCreateDate(new Date());
		compDto.setCreatedBy("vctrowino@yahoo.com");
		compDto.setName("SURA");
		companyService.add(compDto);*/
		return "Hellow , Wolrd!";
	}

}
