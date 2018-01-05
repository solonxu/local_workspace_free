package org.foundation.dml.mockup.event;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

public class FileDataSender implements DataSender  {
	private PrintStream ps = null;
	
	public FileDataSender(File file) throws FileNotFoundException {
		ps = new PrintStream(file);
	}
	
	public void sendSingleRecordToStream(CallEvent callEvent) {
		  ps.println(toString(callEvent));
		  
	}
	
	
	private static String toString(CallEvent callEvent) {
		StringBuffer sb = new StringBuffer();
		sb.append(callEvent.getId()).append(",")
		.append(callEvent.getLatitude()).append(",")
		.append(callEvent.getLongtitude()).append(",")
		.append(callEvent.getTime()).append(",").append(callEvent.getLocation());
		
		return sb.toString();
	}
	
	
	public void close() {
		ps.flush();
		//IOUtils.closeQuietly(ps);
        try {
        	 if (ps != null) ps.close();
        }catch (Exception ignore) {}
	}

}
