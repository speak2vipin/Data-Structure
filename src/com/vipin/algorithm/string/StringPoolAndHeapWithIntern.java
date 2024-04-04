package com.vipin.algorithm.string;

public class StringPoolAndHeapWithIntern {
	String s3 = "RAM";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringPoolAndHeapWithIntern s = new StringPoolAndHeapWithIntern();
		
		String s1 = "RAMSITA";
		String s2 = new String("RAMSITA");
		//System.out.println(s1==s2);
		//System.out.println(s1==s2.intern());
		//System.out.println(s1==s.s3);
		//System.out.println(s2.intern()==s.s3.intern());
		System.out.println(Integer.toHexString(s1.intern().hashCode()));
		System.out.println(Integer.toHexString(s1.hashCode()));
		System.out.println(Integer.toHexString(s2.hashCode()));
		System.out.println(Integer.toHexString(s.s3.hashCode()));
		System.out.println(Integer.toHexString(s.s3.intern().hashCode()));
		
		//System.out.println(Integer.toHexString(s1.hashCode()));
		
		String s12 = "Hello";
		//System.out.println(Integer.toHexString(s12.hashCode()));
		
	}	

}
