package com.vipin.algorithms.mathoperations;

import java.util.ArrayList;

public class BinaryToIntSpecial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(concatenatedBinary(12));
		//System.out.println(grayCode(10));
		int A = 5;
		int [] [] B = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
		//System.out.println(solve(A, B));
		int X[] = {0,0,3,9};
		//System.out.println(plusOne(X));
	}

	public static int concatenatedBinary(int n) {
		/*int i = 1;
		StringBuilder sb = new StringBuilder();
		while (i < n + 1) {
			if ((i & (i - 1)) == 0) {

			}
			sb.append(Integer.toBinaryString(i));
			i++;
		}
		Long ans = Long.parseLong(sb.toString(), 2);
		System.out.println(1 & 2);

		return (int) (ans % 1000000009);
		*/
		
		int i=1;
        //StringBuilder sb = new StringBuilder();
        int leftShift = 0;
        long ans = 0;
        System.out.println(1<<2);
        System.out.println(1>>2);
        while(i<=n) {
       
            if((i&(i-1))==0) {
                leftShift++;
            }
            ans = ((ans << leftShift) + i) % 1000000007;
            i++;
        }
        return (int)ans;

	}

	public static ArrayList<Integer> grayCode(int a) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		if (a == 1) {
			al.add(0);
			al.add(1);
			return al;
		}
		ArrayList<Integer> temp = new ArrayList<Integer>();
		temp.addAll(grayCode(a - 1));
		ArrayList<Integer> ans = new ArrayList<Integer>();
		for (int i = 0; i < temp.size(); i++) {
			ans.add(temp.get(i));
		}
		for (int i = temp.size() - 1; i >= 0; i--) {
			ans.add(temp.get(i) + (1 << (a - 1)));
		}
		return ans;
	}
	
	public static int[] solve(int A, int[][] B) {
        int N = B.length;
        int ans[] = new int[A];
        for(int[]temp : B) {
            ans[temp[0]-1] += temp[2];
            if(temp[1] < A)
            	ans[temp[1]]   -= temp[2];
        }
        for(int i=1; i<=A; i++) {
            ans[i] = ans[i] + ans[i-1];
        }
        return ans;
    }
	
	public static int[] plusOne(int[] A) {
        int N = A.length-1;
        int carry = 0;
        
        while(N>-1) {
            if(A[N]==9) {
                A[N] = 0;
                carry = 1;
                N--;
            } else {
            	// No carry so just return Array
                A[N] = A[N] + 1;
                carry = 0;
                break;
            }
        }
        int ans[];
        if(carry==1) {
            ans = new int[A.length+1];
            ans[0] = 1;
            //if all the numbers are 9
            return ans;
        }
        int index = 0;
        for(int i=0;i<A.length;i++) {
        	if(A[i]==0) {
        		index++;
        	} else {
        		break;
        	}
        }
        ans = new int[A.length-index];
        System.arraycopy(A, index, ans, 0, A.length-index);
        return ans;
    }
}
