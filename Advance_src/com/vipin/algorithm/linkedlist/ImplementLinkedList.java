package com.vipin.algorithm.linkedlist;

public class ImplementLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

    static class Node {
        int value;
        Node next;
        public Node(int value) {
            this.value = value;
            this.next = null;
        }
    }
    //initial head node is null
	private static Node head = null;

    public static void insert_node(int position, int value) {
        // @params position, integer
        // @params value, integer
        Node temp = null;
        if(position==1) {
            temp = new Node(value);
            temp.next = head;
            head = temp;
            return; 
        }
        int count = 1;
        temp = head;
        while(temp!=null) {
            if(count==position-1 && temp.next!=null) {
                temp.next = new Node(value);
                return;
            }
            temp = temp.next;
            count++; 
        }
    }

    public static void delete_node(int position) {
        // @params position, integer
    	if(head==null) {
    		return;
    	} else if(position == 1) {
            head = head.next;
            return;
        }
        int count = 1;
        Node temp = head;
        while(temp!=null) {
            if(count==position-1 && temp.next!=null) {
                temp.next = temp.next.next;
                return;
            }
            count++;
        }

    }

    public static void print_ll() {
        // Output each element followed by a space
        Node temp = head;
        while(temp!=null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}
