package org.jt.tij.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SortedSetTest {
	
	public static void main(String arg[]) {
		SortedSet<String> set  = new TreeSet<String>(Arrays.asList(new String[]{"one","two","three","four","five","six","seven","eight"}));
		
		 System.out.println(set);
		 
		 Iterator<String> it = set.iterator();
		 
		 while (it.hasNext()) {
			 System.out.println(it.next());
		 }
		
	}

}
