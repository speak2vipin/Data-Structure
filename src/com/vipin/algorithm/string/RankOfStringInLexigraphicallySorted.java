package com.vipin.algorithm.string;

public class RankOfStringInLexigraphicallySorted {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RankOfStringInLexigraphicallySorted r = new RankOfStringInLexigraphicallySorted();
		System.out.println(r.findRank("VIEW"));
		r.factorial(10, 1000000000, new long[10+1]);
	}
	
	
		 public int findRank(String A) {
			 
	         int N = A.length();
	         long fact[] = new long[N];
		        int mod = 1000003;
		        int res = 0;
		        for(int i=0; i<N; i++) {
		            int count = 0;
		            for(int j=i+1; j<N; j++) {
		                if(A.charAt(i)>A.charAt(j)) {
		                    count++;
		                }
		            }
		            long noOfStrings = factorial((N-1) - i + 1 - 1, mod, fact);
		            System.out.println(noOfStrings);
		            res = (int)(res + (count * noOfStrings)%mod)%mod;
		        }
		        return res + 1;
		    }

		    long factorial(int N, int mod, long fact[]) {
	            if(N<=0) {
	                return 1;
	            }
	            if(fact[N]!=0) {
	            	return fact[N];
	            }
		        long value = (N * (factorial(N-1, mod, fact)%mod))%mod;
		        fact[N] = value;
		        return value;
		    }
}
