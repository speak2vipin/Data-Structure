package com.vipin.algorithm.recurssion;

import java.util.ArrayList;

public class GrayNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrayNumber GrayNumber = new GrayNumber();
		//GrayNumber.grayCode(10);
		System.out.println(Integer.toBinaryString(12));
		System.out.println(Long.parseLong("1001", 2));

	}
	
	public ArrayList<Integer> grayCode(int a) {
        String s = "";
        for(int i=0; i<a; i++) {
            s+="1";
        }
        ArrayList<String> temp = new ArrayList<String> ();
        temp = grayCodeReturn(s, temp, 0);
        ArrayList<Integer> ans = new ArrayList<Integer> ();
        for(String t : temp) {
            ans.add(Integer.parseInt(t,2));
        }
        return ans;
	}
	ArrayList<String> grayCodeReturn(String s,  ArrayList<String> ans, int index) {
        if(s.length()==index) {
            return ans;
        }
        ans.add(s.substring(0,index)+"0"+s.substring(index+1));
        return grayCodeReturn(s, ans, index+1);
    }

}
