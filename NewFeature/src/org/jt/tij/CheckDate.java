package org.jt.tij;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CheckDate {
	
   public static void main(String arg[]) {
	   try {
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		   Date date = sdf.parse("20160815");
		   
		   Calendar calendar = Calendar.getInstance();
		   calendar.setTime(date);
		   
		  calendar.add(Calendar.DAY_OF_YEAR, 55);
		   
		   
		   
		   System.out.println("the date is :" + calendar.getTime());
	   } catch (Exception e) {
		   
	   }
   }

}
