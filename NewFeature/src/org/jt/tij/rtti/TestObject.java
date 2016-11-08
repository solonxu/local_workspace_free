package org.jt.tij.rtti;

public class TestObject {
	
   private String label  = "Hi Solon";
   
   public TestObject(String newLabel) {
	   this.label = newLabel;
   }
   
   public TestObject() {}

	public void perform() {
		System.out.println(this.label);
	}
}
