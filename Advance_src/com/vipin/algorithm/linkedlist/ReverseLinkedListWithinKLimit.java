package com.vipin.algorithm.linkedlist;

public class ReverseLinkedListWithinKLimit {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ListNode listNode1 = new ListNode(5);
		//ListNode listNode2 = new ListNode(4, listNode1);
		//ListNode listNode3 = new ListNode(3, listNode2);
		ListNode listNode4 = new ListNode(2, null);
		ListNode listNode5 = new ListNode(1, listNode4);
		reverseBetween(listNode5, 1, 2);

	}

	public static ListNode reverseBetween(ListNode A, int B, int C) {
		// check if we don't need to reverse any element means B==C or there is only 1 element
		if(B==C || (B==1 && C==1)) {
			return A; 
		}
		ListNode start = A;
		ListNode preStart = A;
		ListNode end = A;
		ListNode preEnd = null;
		int count = 1;
		
		while (count <= C) { // Traverse to the end element
			if(count<B) {
				preStart = start; // Traverse to preStart
				start = start.next; // Traverse to start
			}
			preEnd = end;
			end = end.next;
			count++;
		}
		
		// the code to reverse the found array list
		ListNode head = start;
		ListNode prev = start;
		ListNode temp = null;
		while (head!=end) {
			head = head.next;
			prev.next = temp;
			temp = prev;
			prev = head;
		}
		
		// now replacing the reverse array to the actual position with the help of stored previous and last element
		preStart.next = temp;
		if(B==1) {
			A=temp;
		}	
		start.next = end;
		
		return A;
	}
	
	 public ListNode reverseBetween1(ListNode A, int B, int C) {
	        if(B==C || (B==1 && C==1)) return A; // check if we don't need to reverse any element means B==C or there is only 1 element
	        int count=1;
	        ListNode start=A;
	        ListNode preStart=A; // to store the previous and last elements of reversing list to replace then back with there address
	        ListNode preEnd=A;
	        ListNode end=A;
	        while(count<=C){ // loop to find the actual elements to reverse
	            if(count<B) {
	                preStart=start; // storing the previous element
	                start=start.next;
	            }
	            preEnd=end; // storing the last element
	            end=end.next;
	            count++;
	        }

	// the code to reverse the found array list
	        ListNode head=start;
	        ListNode curr=head;
	        ListNode pre=null;
	        ListNode Next=null;
	        while(curr!=end){
	            Next  = curr.next;
	            curr.next = pre;
	            pre = curr;
	            curr = Next;
	        }

	// now replacing the reverse array to the actual position with the help of stored previous and last element

	        preStart.next=pre;
	        if(B==1) A=pre;
	        start.next=end;
	        return A;
	    }
}
