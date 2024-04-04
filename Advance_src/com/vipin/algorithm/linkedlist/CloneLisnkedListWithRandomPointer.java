package com.vipin.algorithm.linkedlist;

public class CloneLisnkedListWithRandomPointer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RandomNode r1 = new RandomNode(1, null, null);
		RandomNode r10 = new RandomNode(10, r1, null);
		RandomNode r11 = new RandomNode(11, r10, null);
		RandomNode r13= new RandomNode(13, r11, null);
		RandomNode r7 = new RandomNode(7, r13, null);
		
		r13.random = r7;
		r11.random = r1;
		r10.random = r11;
		r1.random = r7;
		RandomNode res = copyRandomList(r7);
		

	}

	public static RandomNode copyRandomList(RandomNode head) {
		return copyRandomListWithoutSpaceComplexity(head);
	}

	public static RandomNode copyRandomListWithoutSpaceComplexity(RandomNode head) {
		RandomNode originalHead = head;
        
        while(originalHead!=null) {
        	RandomNode temp = new RandomNode(originalHead.val);
        	RandomNode prev = originalHead;
            originalHead = originalHead.next;
            prev.next = temp;
            temp.next = originalHead;
        }
         
        originalHead = head;
        while(originalHead!=null) {
            if(originalHead.random!=null) {
                originalHead.next.random = originalHead.random.next;
            }
            originalHead = originalHead.next.next;
        }
         
        originalHead = head;
        RandomNode res = originalHead.next;
        RandomNode curr = res;
        while(originalHead!=null && originalHead.next!=null) {
        	RandomNode temp = originalHead.next;
            originalHead.next = originalHead.next.next;
            if(temp.next!=null) { 
            	temp.next = temp.next.next;
            }
            originalHead = originalHead.next;
            
        }
        return res;
    
	}

}

class RandomNode {
	int val;
	RandomNode next;
	RandomNode random;

	public RandomNode(int val, RandomNode next, RandomNode random) {
		super();
		this.val = val;
		this.next = next;
		this.random = random;
	}
	
	public RandomNode(int val) {
		super();
		this.val = val;
	}

}