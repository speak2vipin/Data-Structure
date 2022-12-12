package com.vipin.algorithm.bitmanipulations;

public class NumbersTwiceAndTwoNumbersOnlyOnce {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {1, 2, 3, 1, 2, 4};
		System.out.println(solve(A));
	

	}
	
	static int[] solve(int[] A) {
        int sum = 0;
        for(int num : A) {
            sum ^= num;
        }
        int number1 = 0;
        int number2 = 0;
        int index = -1;
        for(int i=0; i<32; i++) {
            if(((sum>>i) & 1) ==1) {
                index = i;
                break;
            }
        }
        // They are two numbers which are once whereas rest of the elements are twice
        // Since twice so Set bit won't be contributed by repeated numbers
        // It would be by either number. If both numbers have that bit then again it would be unset
        // Since it is set that means one of the element is contributing.
        for(int num : A) {
            if(((num>>index) & 1)==1) {
                number1 ^= num;
            } else {
                number2 ^= num;
            }
        }
        int ans[] = new int[2];
        ans[0] = number1 > number2 ? number2 : number1;
        ans[1] = number1 > number2 ? number1 : number2;
        return ans;
    }

}
