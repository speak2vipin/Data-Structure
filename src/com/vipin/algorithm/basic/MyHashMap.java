package com.vipin.algorithm.basic;

import java.util.ArrayList;
import java.util.List;

public class MyHashMap {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	List<Integer> list = null;

	public MyHashMap() {
        list = new ArrayList<>();
    }

	public void put(int key, int value) {
		list.set(key, value);
	}

	public int get(int key) {
		return list.size() < key - 1 ? -1 : list.get(key);
	}

	public void remove(int key) {
        Integer x = list.get(key)!=null?list.remove(key):null;
    }

}
