package com.anand.yellowpages.utilities;

/**
 * This class contains utility method related to String
 * @author A Anand
 *
 */
public class StringUtils {

	public static String toConcatenatedString(Object[] items, String concatenator) {
		StringBuilder stringBuilder = new StringBuilder();
		
		for(Object item : items) {
			stringBuilder.append(item).append(concatenator);
		}
		
		if(stringBuilder.length() > 0)
			stringBuilder.deleteCharAt(stringBuilder.length()-1);
		
		return stringBuilder.toString();
	}
}
