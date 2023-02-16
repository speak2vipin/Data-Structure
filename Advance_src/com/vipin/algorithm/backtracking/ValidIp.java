package com.vipin.algorithm.backtracking;

import java.util.ArrayList;
import java.util.List;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.RestoreAction;

public class ValidIp {
	int L = 0;
	ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidIp v = new ValidIp();
		System.out.println(v.restoreIpAddresses("101023"));

	}
	
	public List<String> restoreIpAddresses(String s) {
		if (s.length() > 4) {
			helper(1, "" + s.charAt(0), s, 0);
		}
		return list;
	}

	void helper(int index, String ip, String input, int count,  int charCount) {
		if (index <= input.length()) {
			if (count == 3 && ip.length()-3 != input.length()) {
				if (ip.length()-3 != input.length()) {
					return;

				}
				list.add(ip);
				return;
			}
			if(charCount==3) {
				
			}
			if(!isValid(temp)) {
				return;
			}
			
			helper(index + 1, temp, input, count + 1);
			
			
			temp = temp.substring(0, temp.lastIndexOf('.')) + input.charAt(index);
			if(!isValid(temp)) {
				return;
			}
			helper(index + 1, temp, input, count);
		}
//	1.0.10.23","1.0.102.3","10.1.0.23","10.10.2.3","101.0.2.3
///10.1.0.23, 10.10.2.3, 101.0.2.3
	}
	boolean isValid(String s) {
		if(s.lastIndexOf('.')<0) {
			return Integer.parseInt(s) < 255;
		} else {
			if(s.substring(s.lastIndexOf('.')+1).startsWith("0") && s.substring(s.lastIndexOf('.')+1).length()>1) {
				return false;
			} else {
				return Integer.parseInt(s.substring(s.lastIndexOf('.')+1)) < 255;
			}
		}
	}

}
