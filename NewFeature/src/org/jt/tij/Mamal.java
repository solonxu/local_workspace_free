package org.jt.tij;

public class Mamal extends Animal  {
	
	private static Creator a = new Creator("Mamal static");
	private  Creator b = new Creator("Mamal instance");
	
	public Mamal() {
		
		System.out.println("Mamal");
		
	}
	
	public static void echo() {
		System.out.println("mamal echo ");
	}
	
	private static  Creator b2 = new Creator("Mamal static 2");
	

}
