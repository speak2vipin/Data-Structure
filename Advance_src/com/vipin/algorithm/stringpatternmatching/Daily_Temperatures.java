package com.vipin.algorithm.stringpatternmatching;

import java.util.Stack;

public class Daily_Temperatures {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temperatures[] = {73,74,75,71,69,72,76,73};
		for(int i : dailyTemperatures(temperatures)) {
			System.out.println(i);
		}

	}
	
	public static int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int res[] = new int[n];
        for(int i=n-1; i>-1; i--) {
            while(!st.isEmpty() && temperatures[st.peek()]<=temperatures[i]) {
                st.pop();
            }
            if(!st.isEmpty()) {
                res[i] = st.peek() - i;   
            }
            st.push(i);
        }
        return res;
    }

}
