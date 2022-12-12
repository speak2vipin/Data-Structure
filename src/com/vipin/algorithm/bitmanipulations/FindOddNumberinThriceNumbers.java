package com.vipin.algorithm.bitmanipulations;

public class FindOddNumberinThriceNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 2,2,2,-1,-1,-1,-4,5,5,5};
		System.out.println(singleNumber(A));

	}

	public static int singleNumber(int[] nums) {
        int ans = 0;
        int tempAns[] = new int[32];
        for(int i=0; i<32; i++) {
            int count = 0;
            for(int temp : nums) {
                if(((temp>>i)&1)==1) {
                    count++;
                }
            }
            tempAns[i] = count%3;
        }
        if(tempAns[31]==1) {
            for(int i=1; i<32; i++) {
            	tempAns[i] = tempAns[i]^1;
            	ans += (1<<i);
            }
            ans+=1;
        }
       
        return ans;
    }

}
