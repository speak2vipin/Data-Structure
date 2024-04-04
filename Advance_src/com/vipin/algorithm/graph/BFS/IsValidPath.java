package com.vipin.algorithm.graph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class IsValidPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x = 3;
		int	y = 3;
		int N = 1;
		int	R = 1;
		int[]A = {0};
		int[]B = {3};
		IsValidPath i = new IsValidPath();
		System.out.println(i.solve(x, y, N, R, A, B));
	}

	int dx[] = { -1, -1, 0, 1, 1, 1, 0, -1 };
	int dy[] = { 0, 1, 1, 1, 0, -1, -1, -1 };
	int [][]rectangle = null;
	public String solve(int A, int B, int C, int D, int[] E, int[] F) {
		rectangle = new int[A+1][B+1];
		redZone(A, B, D, E, F);
		
		Queue<int[]> qe = new LinkedList<>();
		if(isValidPath(0, 0, A, B))
			qe.offer(new int[] { 0, 0 });
		rectangle[0][0] = 1;
		
		while (!qe.isEmpty()) {
			int top[] = qe.poll();
			System.out.println(top[0] + " " + top[1]);
			if (top[0] == A && top[1] == B) {
				return "YES";
			}

			int tempX = top[0];
			int tempY = top[1];
			rectangle[tempX][tempY] = 1;
			for (int j = 0; j < 8; j++) {
				int newX = tempX + dx[j];
				int newY = tempY + dy[j];
				if (isValidPath(newX, newY, A, B)) {
					rectangle[newX][newY] = 1;
					qe.offer(new int[] { newX, newY });
				}
			}
		}
		return "NO";
	}

	boolean isValidPath(int newX, int newY, int boundaryX, int boundaryY) {
		return newX >= 0 && newX <= boundaryX && newY >= 0 && newY <= boundaryY && rectangle[newX][newY]==0;
	}

	void redZone(int boundaryX, int boundaryY, int R, int[] E, int[] F) {
		int N = E.length;
		for (int i = 0; i < N; i++) {
			int stX = Math.max(0, E[i]-R);
			int enX = Math.min(boundaryX, E[i]+R);
			int stY = Math.max(0, F[i]-R);
			int enY = Math.min(boundaryY, F[i]+R);
			for(int x=stX; x<=enX; x++) {
				for(int y=stY; y<=enY; y++) {
					int dx = E[i]-x;
					int dy = F[i]-y;
					double tempR = Math.sqrt(dx*dx + dy*dy);
					if(tempR<=R) {
						rectangle[x][y] = 1;
					}
				}
			}
		}
	}
	
	

}

class Solution {
    private List<int[]> bfsQueue;

    // Recursively check the neighboring land cell of current cell grid[x][y] and add all
    // land cells of island A to bfsQueue.
    private void dfs(int[][] grid, int x, int y, int n) {
        grid[x][y] = 2;
        bfsQueue.add(new int[]{x, y});
        for (int[] pair : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
            int curX = pair[0], curY = pair[1];
            if (0 <= curX && curX < n && 0 <= curY && curY < n && grid[curX][curY] == 1) {
                dfs(grid, curX, curY, n);
            }
        }
    }
    
    // Find any land cell, and we treat it as a cell of island A.
    public int shortestBridge(int[][] grid) {    
        int n = grid.length;
        int firstX = -1, firstY = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    firstX = i;
                    firstY = j;
                    break;
                }
            }
        }
        
        // Add all land cells of island A to bfsQueue.
        bfsQueue = new ArrayList<>();
        dfs(grid, firstX, firstY, n);
        
        int distance = 0;
        while (!bfsQueue.isEmpty()) {
            List<int[]> newBfs = new ArrayList<>();
            for (int[] pair : bfsQueue) {
                int x = pair[0], y = pair[1];
                for (int[] nextPair : new int[][]{{x + 1, y}, {x - 1, y}, {x, y + 1}, {x, y - 1}}) {
                    int curX = nextPair[0], curY = nextPair[1];
                    if (0 <= curX && curX < n && 0 <= curY && curY < n) {
                        if (grid[curX][curY] == 1) {
                            return distance;
                        } else if (grid[curX][curY] == 0) {
                            newBfs.add(nextPair);
                            grid[curX][curY] = -1;
                        }
                    }
                }
            }

            // Once we finish one round without finding land cells of island B, we will
            // start the next round on all water cells that are 1 cell further away from
            // island A and increment the distance by 1.
            bfsQueue = newBfs;
            distance++;
        }
        
        return distance;
    }   
}
