package com.vipin.algorithm.linkedlist;

public class SwapNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ListNode node1 = new ListNode(47);
		ListNode node2 = new ListNode(22, node1);
		ListNode node3 = new ListNode(81, node2);
		ListNode node4 = new ListNode(46, node3);
		ListNode node5 = new ListNode(94, node4);
		ListNode node6 = new ListNode(95, node5);
		ListNode node7 = new ListNode(90, node6);
		ListNode node8 = new ListNode(22, node7);
		ListNode node9 = new ListNode(55, node8);
		ListNode node10 = new ListNode(91, node9);
		// [47,22,81,46,94,95,90,22,55,91,6,83,49,65,10,32,41,26,83,99,14,85,42,99,89,69,30,92,32,74,9,81,5,9]

		SwapNode s = new SwapNode();
		s.swapNodes(node10, 5);
		System.out.println(s.pairSum(node10));

		ListNode node11 = new ListNode(8);
		ListNode node12 = new ListNode(4, node11);
		ListNode node13 = new ListNode(3, node12);
		ListNode node14 = new ListNode(0, node13);
		ListNode node15 = new ListNode(10, node14);
		ListNode node16 = new ListNode(6, node15);
		System.out.println(s.reverseList(node16, 3));

	}

	public ListNode swapNodes(ListNode head, int k) {
		ListNode pre = head;
		ListNode post = head;
		int total = 1;
		while (pre.next != null) {
			pre = pre.next;
			total++;
		}
		pre = head;
		int j = 1;

		while (j != total - k) {
			post = post.next;
			j++;
		}
		if (k == 1) {
			ListNode fNext = post.next.next;
			post.next.next = head.next;
			head = post.next;
			post.next = head;
			head.next = fNext;

		} else {
			pre = head;
			int i = 1;
			while (i != k - 1) {
				pre = pre.next;
				i++;
			}
			// 7,9,6,6,7,8,3,0,9,5
			ListNode temp1 = pre;
			ListNode temp2 = post;
			pre.next = post.next;
			// pre.next.next = temp1.next;

			temp1.next.next = temp2.next.next;
			temp2.next = temp1;

			// post.next.next = pre.next.next;
			// pre.next.next = temp;
			// back.next = front.next;
			// post.next = back;
			// pre.next = front;
			// front.next = pre.next.next;
		}
		return head;
	}

	public int pairSum(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;

		// Find mid element
		while (fast != null && fast.next != null) {
			// join = slow;
			slow = slow.next;
			fast = fast.next;
		}

		ListNode dummy = null;
		ListNode curr = null;

		// Reversing second half list
		while (slow != null) {
			curr = slow;
			slow = slow.next;
			curr.next = dummy;
			dummy = curr;
		}

		slow = head;
		int max = Integer.MIN_VALUE;

		while (curr != null) {
			max = Math.max(max, slow.val + curr.val);
			slow = slow.next;
			curr = curr.next;
		}
		return max;
	}

	public ListNode reverseList(ListNode A, int B) {

		ListNode head = A;
		ListNode prev = null;
		ListNode curr = null;

		ListNode join = null;
		ListNode start = null;

		while (head != null) {
			int count = 1;
			start = head;
			prev = head;
			head = head.next;
			while (count < B && head != null) {
				curr = head;
				head = head.next;
				curr.next = prev;
				prev = curr;
				count++;
			}
			if (join == null) {
				A = prev;
			} else {
				join.next = prev;
			}
			join = start;
		}
		start.next = null;
		return A;
	}

}
