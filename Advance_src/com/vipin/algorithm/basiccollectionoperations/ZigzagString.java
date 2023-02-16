package com.vipin.algorithm.basiccollectionoperations;

import java.util.ArrayList;
//3	-	PAHNAPLSIIGYIR
//PAHNAPLSIIGYIR

//4	-	PINALSIGYAHRPI
// 		PINALSIGYAHRPI
public class ZigzagString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZigzagString z = new ZigzagString();
		System.out.println(z.convert("PAYPALISHIRING", 4));;
	}
	
	public String convert(String s, int numRows) {
        int l = s.length();
        String output = "";
        ArrayList<ArrayList<Character>> A = new ArrayList<ArrayList<Character>>();
        int i=0;
        for(i=0; i<numRows; i++) {
            ArrayList<Character> temp = new ArrayList<Character>();
            temp.add(s.charAt(i));
            A.add(temp);
        }
        boolean flag = true;
        int j=1;

        while(i<l) { 
            if(flag) {
                A.get(numRows-1-j).add(s.charAt(i));
            } else {
                A.get(j).add(s.charAt(i));
            }
            
            if(j == numRows-1) {
                j=1;
                flag = !flag;  
            } else {
            	j++;
            }
            i++;
            
        }
        for(ArrayList<Character> list : A) {
            for(Character c : list) {
                output += c;
            }
        }
        return output;
    }

}
