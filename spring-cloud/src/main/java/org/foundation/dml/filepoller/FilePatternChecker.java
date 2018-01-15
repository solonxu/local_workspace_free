package org.foundation.dml.filepoller;

import java.text.SimpleDateFormat;

import org.apache.commons.lang.StringUtils;
import org.springframework.util.AntPathMatcher;



public class FilePatternChecker {
	private static final String DATE_FORMAT_START_CHAR ="${";
	private static final String DATE_FORMAT_END_CHAR ="}";
	
	private static AntPathMatcher matcher = new AntPathMatcher();
	
	
	public static boolean isMatch(String name,String pattern) {
		boolean accept = false;
		
		if (StringUtils.contains(pattern,DATE_FORMAT_START_CHAR)&&StringUtils.contains(pattern, DATE_FORMAT_END_CHAR)) {
			String datePattern = StringUtils.substringBetween(pattern,DATE_FORMAT_START_CHAR, DATE_FORMAT_END_CHAR);
			String patternPrefix = StringUtils.substringBefore(pattern, DATE_FORMAT_START_CHAR);
			String patternSuffix = StringUtils.substringAfter(pattern, DATE_FORMAT_END_CHAR);
			
		    String fileDatePart = name;
		    if (!StringUtils.isEmpty(patternPrefix)) {
		    	fileDatePart = StringUtils.substringAfter(fileDatePart,patternPrefix);
		    } 	
		    
		    if (!StringUtils.isEmpty(patternSuffix)) {
		    	fileDatePart = StringUtils.substringBefore(fileDatePart,patternSuffix);
		    } 	
	
		    String antPattern = StringUtils.stripEnd(patternPrefix,"*") + "*" + StringUtils.stripStart(patternSuffix, "*");
		    accept = pattern.equals(name) || (matcher.isPattern(antPattern) && matcher.match(antPattern, name));
		    if (accept) {
		    	SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_START_CHAR + datePattern + DATE_FORMAT_END_CHAR);
		    	try {
		    		sdf.parse(DATE_FORMAT_START_CHAR + fileDatePart + DATE_FORMAT_END_CHAR);
		    	} catch (Exception e) {
		    		accept = false;
		    	}
		    }
		    
		} else {
			System.out.println("the pattern is " + pattern);
		    accept = pattern.equals(name) || (matcher.isPattern(pattern) && matcher.match(pattern, name));
		}
		
		return accept;
	}
	
	
	public static void main(String arg[]) {

		String filename ="20170829_HMR_var-10d_20170823_mars-xfos-sensitivity-fx_EOD-7412727-1-1.zip_RD";
		
		System.out.println("Testing filename:" + filename);
		if (isMatch(filename,"????????_HMR_*_mars-xfos-sensitivity_*.zip_RD")) {
			System.out.println("It's matcheed");
		} else {
			System.out.println("It's not matched ");
		}


		filename = "20170918_HMR_20293_mars-2xfos-sensitivity_3.zip_RD";
		System.out.println("Testing filename:" + filename);

		if (isMatch(filename,"????????_HMR_*_mars-xfos-sensitivity_*.zip_RD")) {
			System.out.println("It's matcheed");
		} else {
			System.out.println("It's not matched ");;
		}

		
		
	}
}
