/**
 * 
 */
package com.vowino.sale.point;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author vctro
 *
 */
public class Utility {
	public static final String DEFAULT_DATE = "2017-01-01";
	public static final String COMPANY_REF_ID_ERROR = "Company Reference Id is required.";
	static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public static final String FORMAT_DATE = " 00:00:00";
	/**
	 * @return
	 */
	public static java.sql.Date getCurrentDate () {
		Calendar calendar = Calendar.getInstance();
		java.sql.Date date = new java.sql.Date(calendar.getTime().getTime());
		return date;
		
	}
	/**
	 * 
	 * @param stringDate
	 * @return
	 */
	public static Date dateConverter(String stringDate) {
		Date date;
		try {
			date = df.parse(stringDate);
		} catch (ParseException e) {
			e.printStackTrace();
			date = new Date();
		}
		return date;
	}
	/**
	 * @param clazz
	 * @param method
	 * @param message
	 * @return
	 */
	public static String getErrorMessage(String clazz, String method, String message) {
		StringBuilder builder = new StringBuilder();
		builder.append(clazz);
		builder.append(method);
		builder.append(message);
		return builder.toString();
	}

}
