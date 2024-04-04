package com.vipin.algorithm.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class LongestBeautyfulSTtingHavingAllVowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String word = "aeiaaioaaaaeiiiiouuuooaauuaeiu";
		//System.out.println(longestBeautifulSubstring(word));
		int A[] = {3,2,3,4,2};
		System.out.println(distinctDifferenceArray(A));
	}
	public static int longestBeautifulSubstring(String word) {
        HashMap<Character, Integer> map = new HashMap<>(); 
        map.put('a', 0); map.put('e', 1);
        map.put('i', 2); map.put('o', 3);
        map.put('u', 4); 
        
        
        int N = word.length();
        int i=0; 
        int j=0;
        int count = 0;
            // aeiaaioaaaaeiiiiouuuooaauuaeiu
        while(i<N) {
            char curr = word.charAt(i);
            if(curr=='a') {
                j = i+1;
                HashSet<Character> set = new HashSet<>();
                
                set.add(curr);
                while(j<N) {
                    char next = word.charAt(j);
                    if(next==curr || (map.get(next)-map.get(curr)==1)) {
                        set.add(next);
                        if(set.size()==5) {
                           count = Math.max(count, j-i+1); 
                        }
                        j++;
                    } else {
                        break;
                    }
                    curr = next;
                }
            }
            i++;
        }
        return count;
    }
	
public static int[] distinctDifferenceArray(int[] nums) {
        
        int N = nums.length;
        int ans[] = new int[N];
       // Arrays.sort(nums);
        Map<Integer, Integer> mapP = new HashMap<>();
        Map<Integer, Integer> mapS = new HashMap<>();
               
        for(int i=0; i<N; i++) {
            mapS.put(nums[i], mapS.getOrDefault(nums[i], 0)+1);
        }
        for(int i=0; i<N; i++) {
            mapP.put(nums[i], mapP.getOrDefault(nums[i], 0)+1);
            if(mapS.get(nums[i])==1) {
                mapS.remove(nums[i]);
            } else {
                mapS.put(nums[i], mapS.get(nums[i])-1);
            }
            ans[i] = mapP.size() - mapS.size();
        }
        return ans;
    }



}

int frequncyArray[];
int count[];
//Map<Integer, Integer> map;

class FrequencyTracker() {
    //map = new HashMap<>();
    frequncyArray = new int[100000];
    count = new int[100000];;
}

public void add(int number) {
    //map.put(number, map.getOrDefault(number, 0)+1);
    frequncyArray[number]++;
    count[frequncyArray[number]]++;
    //map.put(frequncyArray[number], map.getOrDefault(frequncyArray[number], 0)+1);
}

public void deleteOne(int number) {
    if(frequncyArray[number]>0) {
        //if(map.get(frequncyArray[number])!=null && map.get(frequncyArray[number])==1) {
          //  map.remove(frequncyArray[number]);
        }//
        count[frequncyArray[number]]--;
        frequncyArray[number]--;
        
    }
}

public boolean hasFrequency(int frequency) {
   return count[frequency]==0? false : true;
}
}