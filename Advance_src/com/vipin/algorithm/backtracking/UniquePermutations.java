package com.vipin.algorithm.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class UniquePermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> A = Arrays.asList(1,2);
		UniquePermutations u = new UniquePermutations();
		u.permute(A);
		
		String[]s = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
		System.out.println(u.evalRPN(s));

	}
	
	ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
	int N = 0;

	public int[][]permute(List<Integer> A) {
		int freq[] = new int[11];
		N = A.size();
		for (int i = 0; i < N; i++) {
			freq[A.get(i)] += 1;
		}
		ArrayList<Integer> permutation = new ArrayList<Integer> ();
		permute(0, freq, permutation);
		int result[][] = new int[ans.size()][];
		for(int i=0; i<ans.size(); i++) {
			ArrayList<Integer> tempList = ans.get(i);
			int tempResultSize = tempList.size();
			int tempResult[] = new int[tempResultSize];
			for(int j=0; j<tempResultSize; j++) {
				tempResult[i] = tempList.get(j);
			}
			result[i] = tempResult;
		}
		return result;
	}

	void permute(int index, int[] freq, ArrayList<Integer> permutation) {
		if (index == N) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.addAll(permutation);
			ans.add(temp);
			return;
		}
		for (int i = 0; i < 11; i++) {
			if (freq[i] != 0) {
				permutation.add(freq[i]);
				freq[i]--;
				permute(index + 1, freq, permutation);
				freq[i]++;
				int size = permutation.size();
				permutation.remove(size-1);
			}
		}
	}
	
	
	public int evalRPN(String[] tokens) {
        Set<String> set = new HashSet<>();
        set.add("/");
        set.add("+");
        set.add("-");
        set.add("*");
        Stack<String> st = new Stack<>();
        int n = tokens.length-1;
        for(int i=n; i>-1; i--) {
            if(set.contains(tokens[i])) {
                st.push(tokens[i]);
            } else if(st.isEmpty() || set.contains(st.peek())) {
                st.push(tokens[i]);
            } else {   
            	String operand1 = tokens[i];
                operand1 = mathOperations(set, st, operand1);
                st.push(operand1);
            }
        }
        return Integer.parseInt(st.pop());
        
    }

	private String mathOperations(Set<String> set, Stack<String> st, String operand1) {
		while(!st.isEmpty() && !set.contains(st.peek())) {
			String operand2 = st.pop();
		    String Operator = st.pop();
		    String value = "";
		    switch(Operator) {
		        case "+": value += 
		        Integer.parseInt(operand1) + Integer.parseInt(operand2); 
		            break;
		        case "-": value +=  
		        Integer.parseInt(operand1) - Integer.parseInt(operand2); 
		            break;
		        case "*":
		            value +=  
		        Integer.parseInt(operand1) * Integer.parseInt(operand2);
		            break;
		        case "/":
		            value +=  
		    (Integer.parseInt(operand1) / Integer.parseInt(operand2));
		            break;
		        default:
		            break;
		    }
		    operand1 = value;
		    
		}
		return operand1;
	}

}
