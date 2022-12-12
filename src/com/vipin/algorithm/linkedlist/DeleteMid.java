package com.vipin.algorithm.linkedlist;

public class DeleteMid {

	/**
	 * Definition for singly-linked list.
	 */
	 public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(convertToTitle(27));
		System.out.println(convertToTitle(78));

	}
	
	public ListNode deleteMiddle(ListNode head) {
        if(head==null | head.next==null) {
            return head;
        }
        ListNode prev = head;
        ListNode oneJump = head;
        ListNode doubleJump = head;
        while(doubleJump!=null && doubleJump.next!=null) {
            prev = oneJump;
            oneJump = oneJump.next;
            doubleJump = doubleJump.next.next;
        }
        prev.next = oneJump.next;
        return head;
    }
	
	 public static String convertToTitle(int A) {
	        StringBuilder sb = new StringBuilder();
	        while(A>0) {
	            int r = (A-1)%26;
	            sb.append((char)('a' + r));
	            A = (A-1)/26;
	        }
	        return sb.reverse().toString();

	    }

}
