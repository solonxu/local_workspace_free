package org.jt.tij.rtti;

import java.lang.reflect.Constructor;

public class CreateInstance {
	
	public static void main(String [] arg) {
		try {
		    Class<?> clazz = Class.forName("org.jt.tij.rtti.TestObject");
		
		    TestObject newInstance = (TestObject)clazz.newInstance();
		    
		    newInstance.perform();
		    
		    
		    Constructor[] constructors = TestObject.class.getConstructors();
		    
		    for (Constructor c : constructors) {
		    	TestObject newInstance2 = null;
		    	System.out.println(c.getParameterCount());
		    	
		        if (c.getParameterCount() == 0)  newInstance2 = (TestObject)c.newInstance();
		        else  newInstance2 = (TestObject)c.newInstance("This is anther solon");
				newInstance2.perform();
		    }
		    
		    
		    Constructor paramConstructor = TestObject.class.getConstructor(String.class);
		     newInstance = (TestObject)paramConstructor.newInstance("this is new");
		    
		     newInstance.perform();
		    
		} catch (ClassNotFoundException e) {
		   e.printStackTrace();
			
		} catch (Exception ile) {
			ile.printStackTrace();
		} 
		
	}

}
