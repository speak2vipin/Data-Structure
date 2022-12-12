package com.vipin.algorithm.linkedlist;

public class MergeTwoSortLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode listNode1 = new ListNode(8);
		ListNode listNode2 = new ListNode(7, listNode1);
		ListNode listNode3 = new ListNode(5, listNode2);
		ListNode listNode4 = new ListNode(3, listNode3);
		ListNode listNode5 = new ListNode(1, listNode4);
		
		ListNode listNode10 = new ListNode(15);
		ListNode listNode9 = new ListNode(9, listNode10);
		ListNode listNode8 = new ListNode(6, listNode9);
		ListNode listNode7 = new ListNode(4, listNode8);
		ListNode listNode6 = new ListNode(2, listNode7);
		mergeTwoLists(listNode5, listNode6);
	}
	
	public static ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode sortedHead = null;
        if(A==null) {
            sortedHead = B; 
        } else if(B==null) {
            sortedHead = A;
        } else {
            ListNode headA = A;
            ListNode headB = B;
                
            if(headA.val<headB.val) {
                sortedHead = headA;
                headA = headA.next;
            } else {
                sortedHead = headB;
                headB = headB.next;
            }
            ListNode temp = sortedHead;

            while(headA !=null && headB !=null) {
                if(headA.val<headB.val) {
                    temp.next = headA;
                    headA = headA.next;
                } else {
                    temp.next = headB;
                    headB = headB.next;
                }
                temp = temp.next;
            }
            if(headA==null) {
                temp.next = headB;
            } else {
                temp.next = headA;
            }
        }
        return sortedHead;
    }

}
