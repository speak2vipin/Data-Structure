package com.vipin.algorithm.greedyalgorithms;

public class FlipExactBElementToMakeAll1InString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A = "00010110";
		System.out.println(solve(A, 3));
	}

	public static int solve(String A, int B) {
	        int N = A.length();
	        int flip = 0;
	        int temp[] = new int[N+1];
	        int res = 0;
	        for(int i=0; i<N; i++) {
	            flip = flip + temp[i];
	            int val = A.charAt(i)-'0';
	            if(flip%2==0 && val%2==0) {
	                if(i+B-1>=N) {
	                    return -1;
	                }
	                res++;
	                temp[i+B] += 1;
	                flip++;
	            } else if(flip%2!=0 && val%2!=0) {
	                if(i+B-1>=N) {
	                    return -1;
	                }
	                res++;
	                temp[i+B] += 1; 
	                flip++;
	            }

	        }
	    
		//return ans;
		/*int N = A.length();
		char[] temp = A.toCharArray();
		int count = 0;
		for (int i = 0; i < N; i++) {
			if (temp[i] == '0') {
				count++;
				for (int j = 0; (N - i >= B) && j < B; j++) {
					if (temp[i + j] == '0') {
						temp[i + j] = '1';
					} else {
						temp[i + j] = '0';
					}
				}
			}
		}
		for (int i = 0; i < N; i++) {
			if (temp[i] == '0') {
				return -1;
			}
		}
		return count;
*/
	        return res;
	}

}
