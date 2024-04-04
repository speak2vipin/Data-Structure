package com.vipin.algorithm.datatype;

public class BooleanToShort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		short x = 65;
		byte y = 10;
		char temp = (char) x;
		System.out.println("Short to char " + temp);
		x = (short) temp;
		System.out.println("char to short " + x);
		temp = (char) y;
		System.out.println("Byte to char " + temp);
		y = (byte) temp;
		System.out.println("char to byte " + y);
		String s1 = "Hello";
		System.out.println(Integer.toHexString(s1.hashCode()));
		String s2 = s1 + "!";
		System.out.println(Integer.toHexString(s2.hashCode()));
		String s3 = "Hello";
		System.out.println(Integer.toHexString(s3.hashCode()));
		
		String s11 = "Hello";
		String s12 = "Hello1";
		String s13 = "Hello";
		System.out.println(s11==s13);
		s13 = s13 + "1";
		String s14 = "Hello1";
		
		//System.out.println(s12==s13);
		//System.out.println(s12==s14);
		//System.out.println(s13==s14);
		
		System.out.println(s12.intern()==s13.intern());
		System.out.println(s12.intern()==s14.intern());
		System.out.println(s13.intern()==s14.intern());
	}

}
