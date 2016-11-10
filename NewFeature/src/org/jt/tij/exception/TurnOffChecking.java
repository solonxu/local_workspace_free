package org.jt.tij.exception;

class SomeOtherException extends Exception {} ;

public class TurnOffChecking {
	
	public static void main(String arg[]) {
		WrapCheckException wce = new WrapCheckException();
		
		wce.throwRuntimeException(3);
		
		for (int i=0;i<4;i++) {
			try {
				if (i<3)
				wce.throwRuntimeException(i);
				else 
					 throw new SomeOtherException();
			} catch (SomeOtherException soe) {
				  System.out.println("some other exception");
			} catch (RuntimeException e) {
				 System.out.println(e.getCause());
			}
		}
	}
	

}
