package com.vipin.algorithm.linkedlist;

public class RemoveCycle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l6 = new ListNode(6);
		ListNode l5 = new ListNode(5, l6);
		ListNode l4 = new ListNode(4, l5);
		ListNode l3 = new ListNode(3, l4);
		l6.next = l3;
		ListNode l2 = new ListNode(2, l3);
		ListNode l1 = new ListNode(1, l2);
		System.out.println(solve(l1).val);

	}
	
	public static ListNode solve(ListNode A) {
        ListNode slow = A;
        ListNode fast = A;
        ListNode temp = null;
        while(slow!=null && fast.next!=null) {
            slow = slow.next;
            temp = fast.next;
            fast = fast.next.next;
            if(slow == fast) {
                break;
            }
        }
        fast = A;
        while(fast!=null && slow!=null){
        	if(slow == fast) {
        		temp.next = null;
        		break;
        	}
            fast = fast.next;
            slow = slow.next;
            temp = temp.next;
        } 
        return A;
    }

}
