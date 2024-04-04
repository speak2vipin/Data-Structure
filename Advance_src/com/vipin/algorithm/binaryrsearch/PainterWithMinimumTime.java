package com.vipin.algorithm.binaryrsearch;

import java.util.Arrays;

public class PainterWithMinimumTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int A = 1;
		int B = 1000000;
		int C[] = { 1000000, 1000000 };
		PainterWithMinimumTime p = new PainterWithMinimumTime();
		System.out.println(p.paint(A, B, C));

	}

	public int paint1(int A, int B, int[] C) {
		int mod = 10000003;
		Arrays.sort(C);
		int N = C.length;
		if (A >= N) {
			return ((C[N - 1] % mod) * (B % mod)) % mod;
		}
		int maxLen = 0;
		for (int c : C) {
			maxLen = maxLen + c;
		}
		int maxTime = maxLen * B;

		return binarySearch(A, B, C, maxTime);

	}

	int binarySearch(int A, int B, int C[], int maxTime) {
		int ans = 0;
		int start = 1;
		int end = maxTime;
		while (start < end) {
			int mid = start + (end - start) / 2;
			if (isPossible(A, B, C, mid)) {
				ans = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return ans;
	}

	boolean isPossible(int A, int B, int C[], int maxTime) {
		int N = C.length;
		int j = 0;
		int totalUnit = maxTime / B;
		while (j > -1 && j < N && A > 0) {
			int tempUnits = C[j];
			while (j < N - 1 && (tempUnits < totalUnit)) {
				tempUnits += C[++j];
			}
			// j--;
			A--;
		}
		return j == N - 1;
	}
	
	public int paint(int A, int B, int[] C) {
		int mod = 10000003;
		
		int N = C.length;
		
        long leftLimit = Long.MIN_VALUE;
        long rightLimit = 0;
        for(int i=0; i<N; i++) { 
            leftLimit = Math.max(leftLimit, (1l*C[i])*B);
            rightLimit = rightLimit + (1l*C[i]) *B;
        }

		while (leftLimit <= rightLimit) {
			long midLimit = leftLimit + (rightLimit - leftLimit) / 2;
            boolean midLimitCheck = isPossible(C, midLimit, A, B);
            boolean midLimitCheckOneLesser =  midLimitCheck ? isPossible(C, midLimit-1, A, B) : true;
			if(midLimitCheck && !midLimitCheckOneLesser) {
                return (int)(midLimit%mod);
            }
            if(!midLimitCheck) {
                leftLimit = midLimit + 1;
            } else {
                rightLimit = midLimit - 1;
            }
		}
		return -1;
	}

	boolean isPossible(int C[], long maxTime, int p, int B) {
        int N = C.length;
        long time = maxTime;
        int count = 1;
		for(int i=0; i<N; i++) {
			long timeRequired = (1l*C[i])*B;
            if(timeRequired > maxTime) {
                return false;
            }
            if(timeRequired<=time) {
                time = time - timeRequired;
            } else {
                count++;
                time = maxTime - timeRequired;
            }
        }
        return count<=p;
	}


	public int paint123(int A, int B, int[] C) {
		long start = Integer.MIN_VALUE;
		long end = 0;
		long ans = 1;
		for (int i = 0; i < C.length; i++) {
			start = Math.max(start, C[i]);
			end = end + C[i];
		}
		if (A == 1)
			return (int) ((end * B) % 10000003);

		while (start <= end) {
			long mid = (start + end) / 2;
			if (canPaint(C, (int) mid, A)) {
				ans = mid;
				end = mid - 1;
			} else
				start = mid + 1;
		}

		return (int) ((ans * B) % 10000003);
	}

	public boolean canPaint(int[] C, int mid, int painter) {
		int count = 1;
		int sum = 0;
		for (int i = 0; i < C.length; i++) {
			if (sum + C[i] <= mid)
				sum = sum + C[i];
			else {
				sum = C[i];
				count++;
				if (count > painter)
					return false;
			}
		}
		return true;
	}
	
	
}