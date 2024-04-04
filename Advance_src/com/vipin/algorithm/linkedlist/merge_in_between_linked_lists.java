package com.vipin.algorithm.linkedlist;

public class merge_in_between_linked_lists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//list1 = [10,1,13,6,9,5], a = 3, b = 4, list2 = [1000000,1000001,1000002]
	    ListNode node1 = new ListNode(10);
	    node1.next = new ListNode(1);
	    node1.next.next = new ListNode(13);
	    node1.next.next.next = new ListNode(6);
	    node1.next.next.next.next = new ListNode(9);
	    node1.next.next.next.next.next = new ListNode(5);
	    ListNode node2 = new ListNode(1000000);
	    node2.next = new ListNode(1000001);
	    node2.next.next = new ListNode(1000002);
	    mergeInBetween(node1, 3, 4, node2);
	}
	
	public static ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode head = list1;
       
        int count = 1;    
        while(count<a) {
            head = head.next;
            count++;
        }
        ListNode end = head;
        while(count<b+1) {
            end = end.next;
            count++;
        }
        head.next = list2;
        ListNode end2 = list2;
        while(end2.next!=null) {
            end2 = end2.next;
        }
        end2.next = end.next;
        return list1;
	}

}
