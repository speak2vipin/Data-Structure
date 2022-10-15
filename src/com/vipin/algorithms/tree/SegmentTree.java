package com.vipin.algorithms.tree;

public class SegmentTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num[] = {1,2,3,4,5,6,7,8,9, 10};
		SegmentTree st = new SegmentTree(num);
		System.out.println(st.sumRange(3, 8));
	}
	

    int[] nums;
    double sqrt;
    int block;
    int[]b;

    public SegmentTree(int[] nums) {
        this.nums = nums;
        this.sqrt = Math.sqrt(nums.length);
        this.block = (int)Math.ceil(nums.length/sqrt);
        b = new int[block];
        for(int i=0;i<nums.length;i++) {
        	b[(int)(i/block)]+=nums[i];
        }
        
    }
    
    public void update(int i, int val) {
	    int b_l = (int)(i / sqrt);
	    b[b_l] = b[b_l] - nums[i] + val;
	    nums[i] = val;
	}
    
    public int sumRange(int left, int right) {
        int sum =0;
        int startblock = (int)(left/block);
        int endblock = (int)(right/block);
        if(startblock==endblock) {
            for(int i=left; i<=right;i++) {
                sum+=nums[i];
            }
        } else {
            for(int i=left;i<(startblock+1)*block;i++) {
            	sum+=nums[i];
            }
           
            for(int i=startblock+1;i<endblock;i++) {
        	    sum+=b[i];
            }
            for(int i=endblock*block;i<=right;i++) {
            	sum+=nums[i];
            }
            	
        }
        return sum;
    }

	/*public SegmentTree(int[] nums) {
	    this.nums = nums;
	    double l = Math.sqrt(nums.length);
	    len = (int) Math.ceil(nums.length/l);
	    b = new int [len];
	    for (int i = 0; i < nums.length; i++)
	        b[i / len] += nums[i];
	}

	public int sumRange(int i, int j) {
	    int sum = 0;
	    int startBlock = i / len;
	    int endBlock = j / len;
	    if (startBlock == endBlock) {
	        for (int k = i; k <= j; k++)
	            sum += nums[k];
	    } else {
	        for (int k = i; k <= (startBlock + 1) * len - 1; k++)
	            sum += nums[k];
	        for (int k = startBlock + 1; k <= endBlock - 1; k++)
	            sum += b[k];
	        for (int k = endBlock * len; k <= j; k++)
	            sum += nums[k];
	    }
	    return sum;
	}

	public void update(int i, int val) {
	    int b_l = i / len;
	    b[b_l] = b[b_l] - nums[i] + val;
	    nums[i] = val;
	}*/
	// Accepted

}
