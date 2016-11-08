package org.jt.tij;

public class Animal {
	
	private static Creator a = new Creator(" aninal staitc");
	private  Creator b = new Creator(" aninal instance");

	
	public Animal() {
		System.out.println("Animal");
	}

}
