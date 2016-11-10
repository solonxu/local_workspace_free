package org.jt.newfeature;

public class TestPersonFactory {
	
	public static void main(String arg[]) {
		PersonFactory<Person> personFactory = Person::new;
		
		Person solon= personFactory.create("solon","xu");
		
		System.out.println("his lastname is " + solon.getLastName());
		
		
		System.exit(0);
	}

}
