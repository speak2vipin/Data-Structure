package com.vipin.algorithm.string;

import java.util.Arrays;

public class IsAnagram {
	
	static boolean isAnagraString(String s1, String s2) {
		char[] s1Array = s1.toCharArray();
		char[] s2Array = s2.toCharArray();
		Arrays.sort(s1Array);
		Arrays.sort(s2Array);
		return new String (s1Array).equals(s2Array);
	}

}
