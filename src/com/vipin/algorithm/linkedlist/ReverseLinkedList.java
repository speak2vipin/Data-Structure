package com.vipin.algorithm.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode1 = new ListNode(5);
		ListNode listNode2 = new ListNode(4, listNode1);
		ListNode listNode3 = new ListNode(3, listNode2);
		ListNode listNode4 = new ListNode(2, listNode3);
		ListNode listNode5 = new ListNode(1, listNode4);
		reverseList(listNode5);
	}
	
	static ListNode reverseList(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        while(head!=null){
            head = head.next;
            temp.next = prev;
            prev = temp;
            temp = head;
        }
        
        return prev;
	}

}
