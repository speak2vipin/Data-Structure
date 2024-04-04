package com.vipin.algorithm.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class LRUMine {
	Map<Integer, Node> link = null;
	int capacity = 0;
	Node head = null;
	Node tail = null;

	public LRUMine(int capacity) {
		link = new HashMap<>();
		this.capacity = capacity;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int get(int key) {
		if (link.get(key) == null) {
			return -1;
		}
		int val = link.get(key).val;
		delete(key);
		add(key, val);
		return val;
	}

	public void set(int key, int value) {
		if (link.size() == capacity) {
			delete(tail.val);
		}
		add(key, value);
	}

	public void delete(int key) {
		Node curr = link.get(key);
		if (head == tail) {
			head = null;
			tail = null;
		} else if (curr.prev == null) {
			tail = tail.next;
			if (tail != null) {
				tail.prev = null;
			}
		} else {
			curr.prev.next = curr.next;
			if (curr.next != null) {
				curr.next.prev = curr.prev;
			} else {
				head = curr.prev;
			}
		}
		link.remove(key);
	}

	public void add(int key, int val) {
		Node curr = new Node(val, null, null);
		if (head == null && tail == null) {
			head = curr;
			tail = curr;
		} else {
			curr.next = null;
			curr.prev = head;
			head.next = curr;
			head = head.next;
		}
		link.put(key, curr);
	}

}

class Node {
	int val;
	Node next;
	Node prev;

	public Node(int val, Node next, Node prev) {
		this.val = val;
		this.next = next;
		this.prev = prev;
	}
}
