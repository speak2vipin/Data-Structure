package com.vipin.algorithm.basicmath;

public class FindNcRModeP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FindNcRModeP f = new FindNcRModeP();
		//f.solve(51299, 25646, 3685739);
		int nums[] = {20,1,15};
		int x = 5;
		System.out.println(f.minCost(nums, x));
	}
	
	public int solve(int A, int B, int C) {
        // A -> n
        // B -> r
        // C -> p
        int n = A;
        int r = B;
        int p = C;
        long nf = 1;
        long rf = 1;
        long nrf = 1;
        for(int i=2; i<=n; i++) {
            nf = (nf*i)%p;
            if(i==r) {
                rf = nf;
            } 
            if(i==n-r) {
                nrf = nf;
            }
        }
        long inverse_rf  = powerFun(rf, p-2, p); // Fermatt theorem to find inverse of factorial
        long inverse_nrf = powerFun(nrf, p-2, p);
        long ans = ((nf%p) * (((inverse_rf % p) * (inverse_nrf % p))%p))%p;
        return (int)ans;
    }

    private long powerFun(long a, long b, long m) {
        //{(a^b)%b}
        if(b==0) {
            return 1;
        }
        long pHalf = powerFun(a, b/2, m);
        long pFull = (pHalf * pHalf)%m;
        if(b%2==0) {
            return  pFull;
        } else {
            return (pFull * a) % m;
        }
    }
    
    public long minCost(int[] A, int x) {
        int n = A.length;
        long[] res = new long[n];
        for (int i = 0; i < n; i++) {
            res[i] += 1L * i * x;
            int cur = A[i];
            for (int k = 0; k < n; k++) {
                cur = Math.min(cur, A[(i - k + n) % n]);
                res[k] += cur;
            }
        }

        long min_res = Long.MAX_VALUE;
        for (long element : res) {
            min_res = Math.min(min_res, element);
        }

        return min_res;
    }


}
