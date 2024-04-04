package com.vipin.algorithm.basic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class StackClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub


        List<String> list = new LinkedList<>();

        list.add("Scaler");

        list.add("For");

        list.add("Coders");

        list.add("InterviewBit");

        Iterator<Integer> iter = list.iterator();

 

        while (iter.hasNext())

            System.out.printf(iter.next() + " ");

 

        System.out.println();
        
        ArrayList<Integer> a = new ArrayList<Integer>();
        System.out.println(a.remove(0));;


	}

}
