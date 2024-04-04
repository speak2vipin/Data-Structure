package com.vipin.algorithm.array;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class SortArrayByItsNumberOfBits {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[]a =  {0,1,2,3,4,5,6,7,8};
		sortByBits(a);
	}

	static Map<Integer, Integer> map = null;

	public static int[] sortByBits(int[] arr) {
		map = new HashMap<>();
		createCountMap();
		arr = Arrays.stream(arr).boxed()
				.sorted((x, y) -> (map.get(x) == map.get(y)) ? (x - y) : map.get(x) - map.get(y))
				.mapToInt(i -> i)
				.toArray();

		return arr;
	}

	static void createCountMap() {
		for (int i = 0; i < 10001; i++) {
			int count = 0;
			for (int j = 31; j > -1; j--) {
				count = count + ((i >> j) & 1);
			}
			map.put(i, count);
		}
	}
	
	public long sumXOR (int arr[], int n) {
        //Complete the function
        long ans = 0l;
        for(int i=31; i>-1; i--) {
            long count = 0;
            for(int j=0; j<n; j++) {
                count += ((arr[j]>>i)&1);
            }
            ans = (long)(ans + count * (n-count) * Math.pow(2, i));
        }
        return ans;
    }
    

}
