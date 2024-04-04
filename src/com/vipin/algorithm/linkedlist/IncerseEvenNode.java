package com.vipin.algorithm.linkedlist;

public class IncerseEvenNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		IncerseEvenNode i = new IncerseEvenNode();
		i.solve(l1);
	}
	
	int count = 0;
    public ListNode solve(ListNode A) {
        ListNode odd = A;
        ListNode even = copy(A);
        even = reverse(even);
       /* while(odd!=null && even!=null && even.next!=null && even.next.next!=null) {
            odd.next = even.next.next;
            ListNode forwardNext = even.next.next.next;
            ListNode backwardNext = even.next;
            even.next.next.next = backwardNext;
            backwardNext.next = even;
            even.next = forwardNext;
            odd = odd.next.next;
            if(odd!=null) {
                even = odd.next;
            }
        }
        return A;
        */
        if(count%2==0) {
        	while(odd!=null && odd.next!=null) {
                ListNode temp = odd;
                odd = odd.next;
                temp.next = even;
                even = even.next;
                
                if(odd!=null)
                    odd = odd.next;
                if(temp.next!=null)
                    temp.next.next = odd;
                if(even!=null)
                even = even.next;
            }
        } else {
            while(odd!=null && odd.next!=null) {
                ListNode curr = odd;
                odd = odd.next.next;
                ListNode currEven = even.next;
                even = even.next.next;
                curr.next = currEven;
                currEven.next = odd;
            }
        }
        return A;
        
    }
    
    ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = null;
        while(head!=null) {
        	curr = head;
            head = head.next;
            curr.next = prev;
            prev = curr;
            
            
        }
        return curr;
    }
    
    ListNode copy(ListNode head) {
        ListNode f = null;
        ListNode t = null;
        while(head!=null) {
            count++;
            if(t==null) {
                f = new ListNode(head.val);
                t = f;
            } else {
                t.next = new ListNode(head.val);
                t = t.next;
            }
            //t = t.next;
            head = head.next;
        }
        return f;
    }



}
