package com.vipin.algorithm.linkedlist;

public class LinkedsListSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(9);
		ListNode l2 = new ListNode(9);
		ListNode l3 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		
		ListNode l11 = new ListNode(1);
		LinkedsListSum l = new LinkedsListSum();
		l.addTwoNumbers(l1, l11);
	}

	public ListNode addTwoNumbers(ListNode A, ListNode B) {
		ListNode head1 = A;
		ListNode head2 = B;
		ListNode temp = A;
		int sum = 0;
		int carry = 0;
		while (head1 != null && head2 != null) {
			temp = head1;
			head1 = head1.next;
			sum = temp.val + head2.val + carry;
			head2 = head2.next;
			carry = 0;
			if (sum > 9) {
				temp.val = sum % 10;
				carry = sum / 10;
			} else {
				temp.val = sum;
			}
		}
		if (head1 == null) {
			remainingSum(temp, head2, carry);
		} else if (head2 == null) {
			remainingSum(temp, head1, carry);
		}
		
		return A;
	}
	
	void remainingSum(ListNode temp, ListNode head, int carry) {
		int sum = 0;
		while (head != null) {
			sum = head.val + carry;
			carry = 0;
			if (sum > 9) {
				head.val = sum % 10;
				carry = sum / 10;
			} else {
				head.val = sum;
			}
			temp.next = head;
			head = head.next;
			temp = temp.next;
		}
		if(carry!=0) {
			temp.next = new ListNode(carry);
		}
	}

}
