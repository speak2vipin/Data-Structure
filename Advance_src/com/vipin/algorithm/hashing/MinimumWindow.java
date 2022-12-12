package com.vipin.algorithm.hashing;

import java.util.HashSet;
import java.util.Set;

public class MinimumWindow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String A ="0iEjBOGeHIMIlslpQIZ6jERaAVoHUc9Hrjlv7pQpUSY8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83"
		+ "UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAjvYzkVJPOYCnz7U4"
		+ "hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvRQVHtuHae0xxwCbRh6S7fCLKfXeSFITfKHnLdT65K36v"
		+ "GC7qOEyyT0Sm3Gwl2iXYSN2ELIoITfGW888GXaUNebAr3fnkuR6VwjcsPTldQSiohMkkps0MH1cBedtaKNoFm5HbH15kKok6aYEVsb6wOH2"
		+ "w096OwEyvtDBTQwoLN87JriLwgCBBavbOAiLwkGGySk8nO8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyL"
		+ "RSQxVH70rUTz81oJS3OuZwpI1ifBAmNXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPMIske3RXgBdpPJd5BPpMpPGymdfIw53hnYBNg8NdWAImY3otYHjbl1rqiNQSHVPMbDDvDpwy01sKpEkcZ7R4SLCazPClvrx5oDyYolubdYKcvqtlcyks3UWm2z7kh4SHeiCPKerh83bX0m5xevbTqM2cXC9WxJLrS8q7XF1nh";
		String B = "dO4BRDaT1wd0YBhH88Afu7CI4fwAyXM8pGoGNsO1n8MFMRB7qugS9EPhCauVzj7h";
		//O8dLHuUhk9q7f0rIjXCsQeAZ1dfFHvVLupPYekXzxtWHd84dARvv4Z5L1Z6j8ur2IXWWbum8lCi7aErEcq41WTo8dRlRykyLRSQxVH70rUTz81oJS3OuZwpI1ifBAm
		//NXoTfznG2MXkLtFu4SMYC0bPHNctW7g5kZRwjSBKnGihTY6BQYItRwLUINApd1qZ8W4yVG9tnjx4WyKcDhK7Ieih7yNl68Qb4nXoQl079Vza3SZoKeWphKef1PedfQ6Hw
		//2rv3DpfmtSkulxpSkd9ee8uTyTvyFlh9G1Xh8tNF8viKgsiuCZgLKva32fNfkvW7TJC654Wmz7tPM
		//8oHqXoQYWWll8Pumov89wXDe0Qx6bEjsNJQAQ0A6K21Z0BrmM96FWEdRG69M9CYtdBOrDjzVGPf83UdP3kc4gK0uHVKcPN4HPdccm9Qd2VfmmOwYCYeva6BSG6NGqTt1aQw9BbkNsgAj
		//vYzkVJPOYCnz7U4hBeGpcJkrnlTgNIGnluj6L6zPqKo5Ui75tC0jMojhEAlyFqDs7WMCG3dmSyVoan5tXI5uq1IxhAYZvR
		
		System.out.println(minWindow(A, B));
		System.out.println(minWindow1(A, B));
		char sud[][] = {
		 {'5','3','.','.','7','.','.','.','.'}
		,{'6','.','.','1','9','5','.','.','.'}
		,{'.','9','8','.','.','.','.','6','.'}
		,{'8','.','.','.','6','.','.','.','3'}
		,{'4','.','.','8','.','3','.','.','1'}
		,{'7','.','.','.','2','.','.','.','6'}
		,{'.','6','.','.','.','.','2','8','.'}
		,{'.','.','.','4',',','9','.','.','5'}
		,{'.','.','.','.','8','.','.','7','9'}};
		System.out.println(isValidSudoku(sud));
	}
	
	public static String minWindow(String A, String B) {
        int lenB = B.length();
        int FA[] = new int[256];
        int FB[] = new int[256];
        for(int i=0; i<lenB; i++) {
        	//FA[A.charAt(i)-'0'] += 1;
        	FB[B.charAt(i)-'0'] += 1;
        }
        //if(compare(FA, FB)) {
        	//return A.substring(0, lenB); 
        //}
        int lenA = A.length();
        int l = 0;
        int r = 0;
        int st = 0;
        int en = 0;
        int ans = Integer.MAX_VALUE;
        FA[A.charAt(0)-'0']++;
        int m=A.length();
        while(r<m) {
            if(compare1(FA,FB))
            {
                if(ans>(r-l+1))
                {
                	st=l;
                    en=r;
                    ans=r-l+1;
                }
                FA[A.charAt(l)-'0']--;
                l++;
            }
            else
            {
                r+=1;
                if(r==m) break;
                FA[A.charAt(r)-'0']++;
            }
        }
        if(ans==Integer.MAX_VALUE) {
        	return "";
        }
        System.out.println(st +" " + en+1);
        return A.substring(st, en+1);    
    }
	 static boolean compare(int []a, int []b) {
		int len = 256;
		for(int i=0; i<len; i++) {
			if(b[i]>a[i]) {
				return false;
			}
		}
		return true;
	}
	 
	 public static boolean compare1(int[] fa,int[] fb)
	    {
	        for(int i=0;i<256;i++)
	        {
	            if(fb[i]>fa[i])
	            return false;
	        }
	        return true;
	    }
	    public static String minWindow1(String A, String B) {
	        int[] fb=new int[256];
	        for(int i=0;i<B.length();i++){
	            fb[B.charAt(i)-'0']++;
	        }
	        int ans=Integer.MAX_VALUE;
	        int l=0;
	        int r=0;
	        int m=A.length();
	        int[] fa=new int[256];
	        fa[A.charAt(0)-'0']+=1;
	        int st=0;
	        int en=0;
	        while(r<m)
	        {
	            if(compare1(fa,fb))
	            {
	                if(ans>(r-l+1))
	                {
	                    st=l;
	                    en=r;
	                    ans=r-l+1;
	                }
	                fa[A.charAt(l)-'0']--;
	                l++;
	            }
	            else
	            {
	                r+=1;
	                if(r==m) break;
	                fa[A.charAt(r)-'0']++;
	            }
	        }
	        if(ans==Integer.MAX_VALUE)
	        {
	            return "";
	        }
	        System.out.println(st + " " + en+1);
	        return A.substring(st,en+1);
	    }
	    
	    
	    public static  boolean isValidSudoku(char[][] board) {
	        for(int i=0; i<9; i++) {
	            Set<Character> setX = new HashSet<Character>();
	            Set<Character> setY = new HashSet<Character>();
	            for(int j=0; j<9; j++) {
	                if(board[i][j] == '.' || setX.add(board[i][j])) {
	                	
	                } else {
	                	return false;
	                }
	                
	                if(board[j][i]=='.' || setY.add(board[j][i])) {
	                	continue;
	                } else {
	                	return false;
	                }
	            }
	        }
			for (int k = 0; k < 3; k++) {
				for (int l = 0; l < 3; l++) {
					int temp = 0;
					Set<Character> setZ = new HashSet<Character>();
					for (int j = l * 3; j < (l + 1) * 3; j++) {
						for (int i = k * 3; i < (k + 1) * 3; i++) {
							if (board[i][j] == '.') {
								continue;
							} else if (!setZ.add(board[i][j])) {
								return false;
							}
						}
						temp++;
					}
				}
			}
	        return true;
	        
	        
	    }
	
}
