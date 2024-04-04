package com.vipin.algorithm.graph.BFS;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfBlackSpots {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input[] = {"XXX", "XXX", "XXX"};
		NumberOfBlackSpots n = new NumberOfBlackSpots();
		System.out.println(n.black(input));
	}
	
	int xBoundary = 0;
    int yBoundary = 0;
    public int black(String[] A) {
        
        int N = A.length;
        xBoundary = N;
        yBoundary = A[0].length();
        int count = 0;
        char input[][] = new char[N][A[0].length()];
        for(int i=0; i<N; i++) {
            input[i] = A[i].toCharArray();
        }
        int dx[] = {-1, 0, 1, 0};
        int dy[] = { 0, 1, 0,-1};
        Queue<int[]> qe = new LinkedList<>();
        for(int i=0; i<xBoundary; i++) {
            for(int j=0; j<yBoundary; j++) {
                char letter = input[i][j];
                if(letter=='O') {
                    continue;
                } else {
                	count++;
                    qe.offer(new int[] {i, j});
                    while(!qe.isEmpty()) {
                        int [] top = qe.poll();
                        input[top[0]][top[1]]='O';
                        for(int k=0; k<4; k++) {
                            int newX = top[0] + dx[k];
                            int newY = top[1] + dy[k];
                            if(isValid(newX, newY) && input[newX][newY]=='X') {
                                qe.offer(new int[] {newX, newY});
                            }
                        }
                    }
                }
            }
        }
        return count;
    }

    boolean isValid(int x, int y) {
        return (x>-1 && x<xBoundary) && (y>-1 && y<yBoundary);
    }
    

}
