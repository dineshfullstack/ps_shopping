package com.ps.serviceregistry;

import java.util.Arrays;

public class Demo {

	public static void main(String[] args) {
		System.out.println("Hi");
		
		String a= "abc";
		String b= "cba";
				
		char[] ca1= a.toCharArray();
		char[] ca2= b.toCharArray();
				
	 System.out.println(Arrays.equals(ca1,ca2));	
	 
	 int num=10;
	 
	 long res=1l;
	 
	 for(int i=1; i<num;i++) {
		 res*=i;
		 System.out.println("Factorial: "+res);
	 }
	 
	 
	 
	 
	 
		

		
				
		
	}

}
