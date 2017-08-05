/**
 * 
 */
package com.vowino.sale.point;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.core.Context;

/**
 * @author vctro
 *
 */
public class SalePointBeanParam {
	@HeaderParam("companyReferenceId")
	private Long companyReferenceId;
	@Context
	private HttpServletRequest request;
	@Context
	private HttpServletResponse response;

	/**
	 * @return the companyReferenceId
	 */
	public Long getCompanyReferenceId() {
		return companyReferenceId;
	}

	/**
	 * @param companyReferenceId the companyReferenceId to set
	 */
	public void setCompanyReferenceId(Long companyReferenceId) {
		this.companyReferenceId = companyReferenceId;
	}

	/**
	 * @return the request
	 */
	public HttpServletRequest getRequest() {
		return request;
	}

	/**
	 * @param request the request to set
	 */
	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	/**
	 * @return the response
	 */
	public HttpServletResponse getResponse() {
		return response;
	}

	/**
	 * @param response the response to set
	 */
	public void setResponse(HttpServletResponse response) {
		this.response = response;
	}
	
}
