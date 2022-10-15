package com.vipin.algorithms.string;

public class NPeople {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "bytdag";
		int A[] = {4,3,0,1,2,5};
		System.out.println(solution(S, A));
		System.out.println(solution("VIPIN","GUPTA", 31));
	}
	
	public static String solution(String S, int[] A) {
        // write your code in Java SE 8
        int N = A.length;
        int index = 0;
        String output = ""+S.charAt(0);
        while(A[index]!=0) {
            output += S.charAt(A[index]);
            index = A[index];
        }
        return output;
    }
	
	 public static String solution(String name, String surname, int age) {
	 StringBuilder sb = new StringBuilder(name.substring(0,2)).append(surname.substring(0,2)).append(age);
     return sb.toString();
	}

}
