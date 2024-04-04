package com.vipin.algorithm.array;

import java.util.Arrays;
import java.util.Stack;

public class TwoPointers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoPointers t = new TwoPointers();
		int A[] = { 5, 10, 20 };
						
		int B[] = { 1, 2, 30};
		int C = 13;
		//System.out.println(t.solve(A, B, C));
		//System.out.println(t.isValid("()"));
	
		//System.out.println(t.solve(12,55557209));
		
		int X[] = {5, -2, -1, -10, 10  };
		
		//System.out.println(t.solve(X));
		String s = "leet**cod*e";
		System.out.println(t.removeStars(s));
		System.out.println(t.threeSumClosest(X, 5));

	}

	public int[] solve(int[] A, int[] B, int C) {
		int ans[] = new int[2];
		
		int N = A.length;
		int M = B.length;

		int i = 0, j = M - 1;
		int val = Integer.MAX_VALUE;
		int minI = N;
		int minJ = M;
		while (i < N && j > -1) {
			if (val > Math.abs(A[i] + B[j] - C)) {
				val = Math.abs(A[i] + B[j] - C);
				minI = i;
				minJ = j;
			} else if(val == Math.abs(A[i] + B[j] - C) && minI == i && minJ>j ) {
				minJ = j;
			}
			if ((A[i] + B[j] - C) < 0) {
				i++;
			} else {
				j--;
			}
		}
		ans[0] = A[minI];
		ans[1] = B[minJ];
		return ans;
	}
	
	public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        int L = s.length();
        for(int i=0; i<L; i++) {
            char temp = s.charAt(i);
            if((temp=='(') || (temp=='{') || (temp=='[')) {
                st.push(temp);
            } else {
                if(st.isEmpty() || (!isMatching(st, temp))) {
                    return false;
                }
            }
        }
        return st.isEmpty();
    }
	boolean isMatching(Stack<Character>st, char temp) {
		char top = st.pop();
		if(temp==')') {
			return top=='(';
		} else if(temp == '}') {
			return top=='{';
		} else if(temp== ']') {
			return top=='[';
		}
		return false;
	}
	
	public int solve(int A, int B) {
        // By Fermat theorem 
        // if GCD(A,B) == 1 then
        // (A^(B-1)%B == 1 which implies
        // (A^(B-2))%B ==A^(-1)%mod

        int fastPower = (int)fastPower(A, B-2, B);
        
        return fastPower%B;
    }

    long fastPower(long A, long B, int mod) {
        if(B==0) {
            return 1;
        }
        if((B%2)==0) {
            return fastPower((A*A)%mod, B/2, mod) % mod;
        } else {
            return (A * fastPower((A*A)%mod, B/2, mod)) % mod;
        }
    }  
    
    public int solve(int[] A) {
        long sum = 0;
        int mod = 1000000007;
        Arrays.sort(A);
        int N = A.length;
        int index = 0;
        for(int i=0; i<N; ) {
            index = 1;
            while(i+index<N && A[i]==A[i+index]) {
                index++;
            }
            sum = (sum + (1l* A[i] * (N-i-index) * index))%mod;
            i = i+index;
        }
        for(int i=0; i<N; i++) {
            for(int j=i; j>-1; j--) {
                sum = (sum + (A[i]%A[j]))%mod;
            }
        }
        return (int)sum%mod;
    }
    
    public String removeStars1(String s) {
        int L = s.length();
        StringBuilder temp = null;
        int index = s.indexOf("*");
        while(index>0) {
            temp = new StringBuilder(s.substring(0, index-1));
            temp.append(s.substring(index+1));
            s = temp.toString();
            index = s.indexOf("*");
        }
        return s;
        
    }
    public String removeStars(String s) {
        int L = s.length();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i<L) {
            char temp = s.charAt(i);
            if(temp=='*' && !st.isEmpty()) {
                st.pop();
            } else {
                st.push(temp);
            }
            i++;
        }
        StringBuilder sb = new StringBuilder("");
        for(Character c : st) {
            sb.append(c);
        }
        return sb.toString(); 
    }
    
    public int threeSumClosest(int[] A, int B) {

        Arrays.sort(A);
       // int sum = 0;
        int N = A.length;
        int distance = Integer.MAX_VALUE;
        int sum = 0;
        for(int i=0; i<N; i++) {
            int j=i+1;
            int k=N-1;
            int tempSum = 0;
            while(j<k) {
                tempSum = A[i] + A[j] + A[k];
                if(distance > Math.abs(B-tempSum)) {
                    distance = Math.abs(B-tempSum);
                    sum = tempSum;
                }
                if(B-tempSum>0) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return sum;
    }

}
