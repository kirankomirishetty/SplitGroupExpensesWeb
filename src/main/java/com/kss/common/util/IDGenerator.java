/**
 * 
 */
package com.kss.common.util;

import java.util.UUID;

/**
 * @author kiran
 *
 */
public class IDGenerator {
	
	public static String generateGUID() {
		return UUID.randomUUID().toString().toUpperCase();
	}

}
