package com.vipin.algorithm.binaryrsearch;

import java.util.*;

public class Time_Based_Key_Value_Store {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TimeMap t = new TimeMap();
		t.set("foo", "bar", 1);
		System.out.println(t.get("foo", 1));
		System.out.println(t.get("foo", 3));
		t.set("foo", "bar2", 4);
		System.out.println(t.get("foo", 4));
		System.out.println(t.get("foo", 5));
		System.out.println(isIsomorphic("foo", "bar"));

	}
	
	public static boolean isIsomorphic(String s, String t) {
        Map<Character, Character> stringMap = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            char tempS = s.charAt(i);
            char tempT = t.charAt(i);
            if(stringMap.get(tempS)==null 
               && !stringMap.values().contains(tempT)) {
                stringMap.put(tempS, tempT);
            } else if(stringMap.get(tempS)!=null 
                      && stringMap.get(tempS).equals(tempT)) {
                
            } else {
                return false;
            }
        }
        return true;
        
    }

}

class TimeMap {

	Map<String, TreeMap<Integer, String>> timeStampMap = null;

	public TimeMap() {
		timeStampMap = new HashMap<>();
	}

	public void set(String key, String value, int timestamp) {
		TreeMap<Integer, String> t = null;
		if (timeStampMap.get(key) == null) {
			t = new TreeMap<Integer, String>();
			
		} else {
			t = timeStampMap.get(key);
		}
		t.put(timestamp, value);
		timeStampMap.put(key, t);
	}

	public String get(String key, int timestamp) {
		if (timeStampMap.get(key) == null) {
			return "";
		} else {
			Map<Integer, String> tempMap = timeStampMap.get(key);
			List<Integer> keys = new ArrayList<>(tempMap.keySet());
			int l = 0, r = keys.size();
			while (l < r) {
				int mid = (l + r) / 2;
				if (keys.get(mid) > timestamp) {
					r = mid;
				} else {
					l = mid + 1;
				}
			}
			if(l==0) {
				return "";
			}
			return tempMap.get(keys.get(l-1));
		}
	}
}

/**
 * Your TimeMap object will be instantiated and called as such: TimeMap obj =
 * new TimeMap(); obj.set(key,value,timestamp); String param_2 =
 * obj.get(key,timestamp);
 */