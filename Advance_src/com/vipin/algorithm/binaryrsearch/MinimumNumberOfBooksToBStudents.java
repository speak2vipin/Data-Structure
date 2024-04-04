package com.vipin.algorithm.binaryrsearch;

public class MinimumNumberOfBooksToBStudents {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int A[] = {12, 34, 67, 90};
		int B = 2;
		MinimumNumberOfBooksToBStudents m = new MinimumNumberOfBooksToBStudents();
		System.out.println(m.books(A, B));
	}
	
	public int books(int[] A, int B) {
        int mod = 1000000007;
        long leftSideLimit = 0;
        long rightSideLimit = 0;
        for(int a : A) {
            leftSideLimit = Math.max(leftSideLimit, a);
            rightSideLimit += a;
        }

        while(leftSideLimit<=rightSideLimit) {
            long mid = leftSideLimit + (rightSideLimit - leftSideLimit)/2;
            boolean midIsPossible = isPossible(A, mid, B);
            boolean midPlusOneIsPossible = midIsPossible ? isPossible(A, mid-1, B) : true;
            if(midIsPossible && !midPlusOneIsPossible) {
                return (int)(mid%mod);
            }
            if(midIsPossible) {
            	rightSideLimit = mid - 1;
            } else {
            	leftSideLimit = mid + 1;
            }
        }
        return -1;
    }

    boolean isPossible(int A[], long threshold, int B) {
        long tempThreshold = threshold;
        int count = 1;
        for(int i=0; i<A.length; i++) {
            if(A[i]>threshold) {
                return false;
            }
            int page = A[i];
            if(tempThreshold - page >= 0) {
                tempThreshold = tempThreshold - page;
            } else {
                tempThreshold = threshold - page;   
                count++;
                if(count>B) {
                    return false;
                }
            }
        }
        return true;
    }

}
