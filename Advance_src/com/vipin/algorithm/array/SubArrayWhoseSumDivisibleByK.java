package com.vipin.algorithm.array;

public class SubArrayWhoseSumDivisibleByK {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SubArrayWhoseSumDivisibleByK s = new SubArrayWhoseSumDivisibleByK();
		int A[] = {4,5,0,-2,-3,1};
		System.out.println(-9%5);
		System.out.println(s.subarraysDivByK(A, 5));

	}
	
	public int subarraysDivByK(int[] nums, int k) {  
        int N = nums.length;
        int prefixMod[] = new int[N];
        int prefix = 0;
        int remainder = 0;
        for(int i=0; i<N; i++) {
            prefix+=nums[i];
            remainder = prefix%k;     
            if(remainder < 0) {
            	remainder = (remainder+k)%k;
            }
            prefixMod[i] = remainder;
            
        }
        int count=0;
        int modgroup[] = new int[k];

        for(int i=0; i<N; i++) {
            if(prefixMod[i]==0) {
                count++;
            }
            count += modgroup[prefixMod[i]];
            modgroup[prefixMod[i]] = modgroup[prefixMod[i]]+1;
        }
        return count;}
}
