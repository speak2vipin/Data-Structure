package com.vipin.algorithm.array;

public class ArrayWithOutput10power9plus7 {
	
	public static void main(String[] args) {
		System.out.println(solve("GUGPUAGAFQBMPYAGGAAOALAELGGGAOGLGEGZ"));
		System.out.println(10^9+7);
	}
	
	public static int solve(String A) {
        char[] chars = A.toCharArray();
        int len = chars.length;
        long count = 0L;
        long result = 0L;
        for(int i=len-1; i>=0;i--) {
            if(chars[i]=='G') {
                count++;
            }
            if(chars[i]=='A') {
                result+=count;
            }
        }
        return (int) result%(1000000007);
    }

}
