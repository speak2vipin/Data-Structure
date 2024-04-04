package com.oracle.interview.schema;

public class Timing {

	private Integer startTime;
	private Integer endTime;
	
	
	public Timing(int startTime, int endTime) {
		super();
		this.startTime = startTime;
		this.endTime = endTime;
	}
	
	public int getStartTime() {
		return startTime;
	}
	public void setStartTime(int startTime) {
		this.startTime = startTime;
	}
	public int getEndTime() {
		return endTime;
	}
	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}
	
}

private int util(int[] A,int[] val,int ind,int sub,int[][] dp){
    int n = A.length;
    if(ind == n){
        return -848483;
    }
    if(sub == 3){
        return 0;
    }
    if(dp[ind][sub] != 0){
        return dp[ind][sub];
    }
    int res = Integer.MIN_VALUE;
    int ans1 = (A[ind] * val[sub]) + util(A,val,ind,sub + 1,dp); // force to use same index for next value
    int ans2 = (A[ind] * val[sub]) + util(A,val,ind + 1,sub + 1,dp);  // force to use next index for next value
    int ans3 = util(A,val,ind + 1,sub,dp); // Dont use the current index for calculation use next indexes
    res = Math.max(res,Math.max(ans1,Math.max(ans2,ans3))); // return max out of it
    return dp[ind][sub] = res;
}
public int solve(int[] A, int B, int C, int D) {
    return util(A,new int[]{B,C,D},0,0,new int[A.length][3]);
}
}
