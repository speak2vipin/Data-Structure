package com.vipin.algorithm.linkedlist;

public class LinkListClone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//RandomListNode listNode1 = new RandomListNode(5);
		//RandomListNode listNode2 = new RandomListNode(4, listNode1, listNode1);
		//RandomListNode listNode3 = new RandomListNode(3, listNode2, null);
		//listNode3.random = listNode3;
		RandomListNode listNode4 = new RandomListNode(2, null, null);
		RandomListNode listNode5 = new RandomListNode(1, listNode4, listNode4);
		//RandomListNode listNode5 = new RandomListNode(1, null, null);
		listNode4.random = listNode5;
		copyRandomList(listNode5);
	}

	public static RandomListNode copyRandomList(RandomListNode head) {
		RandomListNode curr = head;
		RandomListNode headCopy = new RandomListNode(curr.label);
		RandomListNode node_1 = headCopy;
		while (curr != null) {
			curr = curr.next;
			if (curr == null) {
				node_1.next = null;
				break;
			}
			RandomListNode node_2 = new RandomListNode(curr.label);
			node_1.next = node_2;
			node_1 = node_2;
		}
		curr = head;
		RandomListNode tempHead = head;
		RandomListNode currRandomCopy = headCopy;
		RandomListNode tempCurrRandomCopy = headCopy;
		while (curr != null) {
			tempHead = curr;
			curr = curr.next;
			tempCurrRandomCopy = headCopy;
			headCopy = headCopy.next;
			tempHead.next = tempCurrRandomCopy;
			tempCurrRandomCopy.next = curr;
		}

		curr = head;
		currRandomCopy = curr.next;
		while (curr != null) {
			tempCurrRandomCopy = curr.next;
			tempCurrRandomCopy.random = curr.random.next;
			curr = curr.next.next;
		}
		curr = head;
		currRandomCopy = curr.next; 
		tempCurrRandomCopy = curr.next;
		curr  = curr.next;
		while (curr != null) {
			curr = curr.next;
			if(curr==null) {
				break;
			}
			tempCurrRandomCopy.next = curr.next;
			tempCurrRandomCopy = tempCurrRandomCopy.next;
			curr = curr.next;
		}

		return currRandomCopy;
	}
	
	public void createCopy(RandomListNode A) {
		while(A!=null) {
			RandomListNode x = new RandomListNode(A.label);
			x.next = A.next;
			A.next = x;
			A = x.next;
		}
	}
	public void addRandomPointersToCopy(RandomListNode A) {
		while(A!=null) {
			if(A.random!=null) {
				A.next.random = A.random.next;
			}
			A = A.next.next;
		}
	}
	public RandomListNode extractCopy(RandomListNode A) {
		RandomListNode curr = A;
		RandomListNode currRandomCopy = curr.next; 
		RandomListNode tempCurrRandomCopy = curr.next;
		curr  = curr.next;
		while (curr != null) {
			curr = curr.next;
			if(curr==null) {
				break;
			}
			tempCurrRandomCopy.next = curr.next;
			tempCurrRandomCopy = tempCurrRandomCopy.next;
			curr = curr.next;
		}
		return currRandomCopy;
	}
}

class RandomListNode {
	int label;
	RandomListNode next, random;

	RandomListNode(int x, RandomListNode next, RandomListNode random) {
		this.label = x;
		this.next = next;
		this.random = random;
	}
	
	RandomListNode(int x) {
		this.label = x;
	}
}
