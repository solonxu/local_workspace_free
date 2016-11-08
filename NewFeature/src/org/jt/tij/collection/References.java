package org.jt.tij.collection;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

class VeryBig {
	private static final int SZ = 10000;
	
	private double[] d = new double[SZ];
	
	private String ident;
	
	public VeryBig(String id) {
		ident = id;
	}
	
	public String toString() {
		return ident;
	}
	
	public void finalize() {
		System.out.println("Finalizing object:" + ident);
	}
}


public class References {
	
    private static ReferenceQueue rq = new ReferenceQueue();
    
    public static void checkQueue() {
    	Object inq = rq.poll();
    	
    	if (inq != null) {
    		System.out.println("In queue " + (VeryBig) ((Reference)inq).get());
    	}
    }
    
    public static void main(String arg[]) {
    	int size = 10;
    	
    	if (arg.length > 0) {
    		size = Integer.parseInt(arg[0]);
    	}
    	
    	SoftReference[] sa = new SoftReference[size];
    	
    	
    	for (int i=0;i<size;i++) {
    		sa[i] = new SoftReference(new VeryBig("soft" + i),rq);
    	    System.out.println("Just created :" + (VeryBig)sa[i].get());
    	    checkQueue();
    		
    	}
    }

}
