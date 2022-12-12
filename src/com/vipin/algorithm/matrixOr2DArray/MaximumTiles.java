package com.vipin.algorithm.matrixOr2DArray;

import com.vipin.algorithm.array.MinNoOfSwapRequiredToMakeAllNumberTogetherLesserThanB.Solution;

public class MaximumTiles {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(solution(8, 0));
		System.out.println(solution(4, 3));
		System.out.println(solution(0, 18));
		System.out.println(solution(13, 3));
		System.out.println(solution(1000000000, 1000000000));

	}
	
	public static int solution(int M, int N) {
        // write your code in Java SE 8
		long temp = 0l;
		temp = M*1 + N*4;
		int ans = (int)(Math.floor(Math.sqrt(temp)));
		return ans;
    }

}
