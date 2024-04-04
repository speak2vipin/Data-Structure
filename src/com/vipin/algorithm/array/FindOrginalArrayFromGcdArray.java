package com.vipin.algorithm.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class FindOrginalArrayFromGcdArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = { 2, 2, 2, 2, 8, 2, 2, 2, 10 };
		FindOrginalArrayFromGcdArray f = new FindOrginalArrayFromGcdArray();
		System.out.println(f.solve(A));
		String s = "/a/./b/../../c/";
		System.out.println(f.simplifyPath(s));

	}

	public int[] solve(int[] A) {

		int N = A.length - 1;
		Arrays.sort(A);
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for (int val : A) {
			map.put(val, map.getOrDefault(val, 0) + 1);
		}
		ans.add(A[N]);
		map.put(A[N], map.get(A[N]) - 1);
		int i = N - 1;
		while (i > -1) {
			if (map.get(A[i]) > 0) {
				for (Integer ansVal : ans) {
					int gcdVal = gcd(A[i], ansVal);
					map.put(gcdVal, map.get(gcdVal) - 2);
				}
				ans.add(A[i]);
				map.put(A[i], map.get(A[i]) - 1);
			}
			i--;
		}
		int ansArray[] = new int[ans.size()];
		for (int j = 0; j < ans.size(); j++) {
			ansArray[j] = ans.get(j);
		}
		return ansArray;
	}

	int gcd(int X, int Y) {
		if (X == 0) {
			return Y;
		}
		return gcd(Y % X, X);
	}

	public String simplifyPath(String path) {
        StringBuilder simplifyPath = new StringBuilder("");
        
        String[]splits = path.split("/");
        int N = splits.length;
        Stack<String> st = new Stack<>();
        for(int i=0; i<N; i++) {
        	if(!st.isEmpty() &&  splits[i].equals("..")) {
        		st.pop();
        	} else if(!splits[i].equals("..") && !splits[i].equals(".")) {
        		st.push(splits[i]);
        	}
        }
        if(st.isEmpty()) {
        	return "/";
        }
        
        for(int i=0; i<st.size(); i++) {
        	if(i==0) {
        		
        	} else {
        		simplifyPath.append("/");
        	}
        	simplifyPath.append(st.get(i));
        }
        return simplifyPath.toString();
    }

}
