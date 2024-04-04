package com.vipin.algorithm.bitmanipulations;

public class IsBleakNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(is_bleak(4));
	}
	
	public static int is_bleak(int n)
    {
        // Code here
        for(int i=1; i<n; i++) {
            if(i+countSetBits(i)==n) {
                return 0;
            }
        }
        return 1;
    }
    
    static int countSetBits(int n) {
        int count = 0;
        while(n>0) {
        	if((n&1)==1 ) {
        		count++;
        	}
            n = n>>1;
           
        }
        System.out.println(count);
        return count;
    }
    int logCeil(int n) {
    	int count = 0;
    	n--;
    	while(n>0) {
    		n = (n/2) + n%2; 
    		count++;
    	}
    	return count;
    	
    }


}
