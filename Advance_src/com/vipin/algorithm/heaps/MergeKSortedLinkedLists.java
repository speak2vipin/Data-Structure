package com.vipin.algorithm.heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLinkedLists {
	
	public static void main(String[] args) {
		ListNode head1 = new ListNode(1);
		head1.next = new ListNode(2);
		head1.next.next = new ListNode(12);
		
		ListNode head2 = new ListNode(8);
		head2.next = new ListNode(12);
		head2.next.next = new ListNode(22);
		
		ListNode head3 = new ListNode(100);
		head3.next = new ListNode(101);
		head3.next.next = new ListNode(500);
		ArrayList<ListNode> l = new ArrayList<ListNode>();
		l.add(head1);
		l.add(head2);
		l.add(head3);
		
		ListNode head = mergeKLists(l);
		ListNode temp = head;
		
		
	}
	
	public static ListNode mergeKLists(ArrayList<ListNode> a) {
		
		PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(new Comparator<ListNode>() {
			 PriorityQueue <ListNode> min = new PriorityQueue<>((A,B)->{
		            return A.val - B.val;
		        });
			public int compare(ListNode node1, ListNode node2) {
				return Integer.compare(node1.val, node2.val);
			}
		});
		for(ListNode node : a) {
			pq.offer(node);
		}
		ListNode head = pq.poll();
		ListNode temp = head;
		pq.offer(temp.next);
		while(!pq.isEmpty()) {
			ListNode top = pq.poll();
			if(top.next!=null) {
				pq.offer(top.next);
			}
			temp.next = top;
			temp = top;
		}
		return head;			
	}
	
	public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        
        PriorityQueue<ListNode>pq = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            @Override
			public
            int compare(ListNode o1, ListNode o2) {
                return o1.val-o2.val;
            }
        });
        for(ListNode node : lists) {
            pq.offer(node);
        }
        ListNode head = null;
        ListNode curr = null;
        ListNode temp = null;
        while(!pq.isEmpty()) {
            temp = pq.poll();
            if(temp.next!=null)
                pq.offer(temp.next);
            if(head==null) { 
                head = temp;
                curr = temp;
            } else {
                curr.next = temp;
                curr = curr.next;
            }
        }
        return head;
    }
}

class ListNode {
     public int val;
     public ListNode next;
     ListNode(int x) { val = x; next = null; }
 }
