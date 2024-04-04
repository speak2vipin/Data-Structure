package com.vipin.algorithm.hashing;

public class Assignment_MS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(3, 1));
	}
	
	public static String solution(int N, int K) {
        // Implement your solution here
        StringBuilder sb = new StringBuilder();
        int n = K;
        int index = 0;
        while(n>0) {
            char letter = (char)('a' + index);
            sb.append(letter);
            n--;
            index++;
        }
        int temp = N - (2*K);
        
        String output = "";
        if(temp>=0) {
        	StringBuilder ans = new StringBuilder();
	        while(temp>0) {
	            ans.append('a');
	            temp--;
	        }
	        output = sb.toString() + ans + sb.reverse();
        } else {
        	output = sb.append('a').toString();
        }
        return output;

    }
	
	
	boolean ans = true;
    public String solution(int[] A, int[] B, int Z) {
        // Implement your solution here
        boolean isTail = false;
        for(int t : B) {
            if(t==-1) {
                if(isTail) {
                    return "INVALID";
                }
                isTail = true;
            }
        }
        if(!isTail) {
        	return "INVALID";
        }
        boolean visit[] = new boolean[A.length];
        for(int i=0; i<A.length; i++) {
            if(!visit[i]) {
                traverse(A, B, i, visit, Z);
            }
        }
        return  ans ? "VALID" : "INVALID";
 
    }

    void traverse(int A[], int B[], int curr, boolean[] visit, int Z) {
        if(B[curr]==-1) {
            return;
        }
        
        if(Math.abs(A[curr]-A[B[curr]])>=Z || visit[curr]) {
            ans = false;
            return;
        }
        visit[curr] = true;
        traverse(A, B, B[curr], visit, Z);
    }

}
