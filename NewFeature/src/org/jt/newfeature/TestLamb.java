package org.jt.newfeature;

public class TestLamb {
	
	public static void main(String arg[]) {
	int x =2;
	int y =3;
	
	Runnable r1= () -> {System.out.println("helo");};

    new Thread(r1).start();
	}
}
