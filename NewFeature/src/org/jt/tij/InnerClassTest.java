package org.jt.tij;

public class InnerClassTest {
	
	static Content getContent() {
		return new Content () {
			{
				System.out.println("Here the content");
			}
		};
	}
	
	public static void main(String[] arg) {
		getContent();
	}
	private interface Content {}

}
