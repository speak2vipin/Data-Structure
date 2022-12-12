package com.vipin.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class ImplementLRUCache {

	int size = 0;
	Map<Integer, DoubleLinkedList> map = new HashMap<Integer, DoubleLinkedList>();
	DoubleLinkedList head = null;
	DoubleLinkedList tail = null;
	int capacity;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ImplementLRUCache t = new ImplementLRUCache(1);
		t.set(2, 1);
		t.set(2, 2);
		System.out.print(t.get(2));
		t.set(1, 1);
		t.set(4, 1);

		System.out.print(t.get(2));
		System.out.print(t.get(8));
		System.out.print(t.get(14));
		t.set(11, 4);
		t.set(11, 12);
		System.out.print(" " + t.get(10));
		System.out.print(" " + t.get(7));
		t.set(14, 7);
		t.set(12, 9);
		t.set(7, 10);
		System.out.print(" " + t.get(11));
		t.set(9, 3);
		t.set(14, 15);
		System.out.print(" " + t.get(15));
		System.out.print(" " + t.get(9));
		t.set(4, 13);
		System.out.print(" " + t.get(3));
		t.set(13, 7);
		System.out.print(" " + t.get(2));
		// S 2 1 S 2 2 G 2 S 1 1 S 4 1 G 2
		// S 2 1 S 1 10 S 8 13 G 12 S 2 8 G 11 G 7 S 14 7 S 12 9 S 7 10 G 11 S 9 3 S 14
		// 15 G 15 G 9 S 4 13 G 3 S 13 7 G 2
		// 32 4 S 5 13 S 9 6 S 4 1 G 4 S 6 1 S 8 11 G 13 G 1 S 12 12 G 10
		// S 15 13 S 2 13 S 7 5 S 10 3 G 6 G 10 S 15 14 S 5 12 G 5 G 7 G 15 G 5 G 6 G 10
		// S 7 13 G 14 S 8 9 G 4 S 6 11 G 9 S 6 12 G 3
		// 28 3 S 1 12 G 11 S 1 5 G 4 G 8 G 14 S 11 4 S 11 12 G 10 G 8 S 13 11 G 2 G 4 S
		// 14 12 G 10 G 7 S 6 9 G 12 S 11 11
		// G 3 G 7 G 7 G 10 G 15 G 15 G 11 S 4 15 S 4 15

	}

	public ImplementLRUCache(int capacity) {
		this.capacity = capacity;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			int value = map.get(key).val;
			update(key, value);
			return value;
		}
		return -1;
	}
	
	public void update(int key, int value) {
		DoubleLinkedList temp = map.get(key);
		remove(key);
		temp = insert(key, value);
		map.put(key, temp);
	}
	
	void remove(int key) {

		DoubleLinkedList temp = map.get(key);
		if (head == temp) {
			head = head.next;
		}
		if (tail == temp) {
			tail = tail.prev;
		}
		if (temp.next != null) {
			temp.next.prev = temp.prev;
		}
		if (temp.prev != null) {
			temp.prev.next = temp.next;
		}
		map.remove(key);
	
	}

	public void set(int key, int value) {
		int size = map.size();
		if (map.containsKey(key)) {
			update(key, value);
		} else {
			if (size < capacity)
				insert(key, value);
			else {
				removeAtFirst();
				insert(key, value);
			}
		}
	}
	void removeAtFirst() {
		if (head != null) {
			DoubleLinkedList temp = head;
			head = head.next;
			if (head != null)
				head.prev = null;
			temp.next = null;
			if (head == null)
				tail = head;
			map.remove(temp.key);
		}
	}

	DoubleLinkedList insert(int key, int value) {
		DoubleLinkedList newNode = new DoubleLinkedList(key, value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		map.put(key, newNode);
		return newNode;
	}
}

class DoubleLinkedList {
	int key;
	int val;
	DoubleLinkedList next;
	DoubleLinkedList prev;

	public DoubleLinkedList(int key, int val) {
		super();
		this.key = key;
		this.val = val;
		this.next = null;
		this.prev = null;
	}
}

 class Solution {
	int capacity = 0;
	HashMap<Integer, Node> hm;
	Node head = null, tail = null;

	class Node {
		int key;
		int val;
		Node prev;
		Node next;

		Node(int key, int val) {
			this.key = key;
			this.val = val;
			prev = null;
			next = null;
		}
	}

	



	public Node insert(int key, int value) {
		Node newNode = new Node(key, value);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.next = newNode;
			newNode.prev = tail;
			tail = newNode;
		}
		hm.put(key, newNode);
		return newNode;
	}

	

}
