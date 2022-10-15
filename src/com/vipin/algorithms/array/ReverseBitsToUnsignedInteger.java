package com.vipin.algorithms.array;

public class ReverseBitsToUnsignedInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(reverse(3));
		System.out.println(-3 & 0xffffffffL | 0x100000000L);
		System.out.println(0xffffffffL);
		System.out.println(Long.toBinaryString(3 | 0x100000000L));
		System.out.println( Long.toBinaryString(Integer.toUnsignedLong(-3) | 0x100000000L));
		System.out.println( Long.toBinaryString(Integer.toUnsignedLong(3) & 0xffffffffL));
	}
	
	public static long reverse(long a) {
        Long result;
        String s = Long.toBinaryString(a);
        while(s.length()!=32) {
            s=0+s;
        }
        StringBuilder sb = new StringBuilder(s);
        sb=sb.reverse();
        result = Long.parseLong(sb.toString(), 2);
        return result;
	}

}
