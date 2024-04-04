package com.vipin.algorithm.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortByCharcatersCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "scaleracademy";
		System.out.println(solve(s));
		System.out.println(solve1(s));
	}
	
	public static String solve(String A) {
        
        TempObject characaterCount[] = new TempObject[26];
        for(int i=0; i<A.length(); i++) {
            int index = A.charAt(i)-'a';
            if(characaterCount[index]==null)
            	characaterCount[index] = new TempObject(1, index);
            else {
            	characaterCount[index].count++;
            }
        }
        List<TempObject> l = new ArrayList<>();
        for(TempObject t : characaterCount) {
        	if(t!=null)
        		l.add(t);
        }
        
        Collections.sort(l, new Comparator<TempObject>() {

			@Override
			public int compare(TempObject t1, TempObject t2) {
				
				return t2.count - t1.count;
			}
        	
     
        });
        StringBuilder sb = new StringBuilder();
        for(TempObject t : l) {
        	while(t.count>0) {
        		sb.append((char)(t.position+'a'));
        		t.count--;
        	}
        	
        }
        return sb.toString();
    }
	
	public static String solve1(String A) {
        Map<Character, int[]> characters = new HashMap<>();
        for(int i=0; i<A.length(); i++) {
            char c = A.charAt(i);
            if(characters.get(c)==null) {
                characters.put(c, new int[]{c, 1});
            } else {
                characters.get(c)[1]++;
            }
        }
        List<int[]> values = new ArrayList<int[]>(characters.values());
        Collections.sort(values, new Comparator<int[]>(){
           public int compare(int[]x, int []y) {
               return y[1]==x[1] ? x[0]-y[0] : (y[1]-x[1]);
           } 
        });
        StringBuilder sb = new StringBuilder();
        for(int[] val : values) {
            while(val[1]>0) {
                sb.append((char)val[0]);
                val[1]--;
            }
        }
        return sb.toString();
     }
	
	

}

class TempObject {
	public int count;
	public int position;
	public TempObject(int count, int position) {
		super();
		this.count = count;
		this.position = position;
	}
	
}
