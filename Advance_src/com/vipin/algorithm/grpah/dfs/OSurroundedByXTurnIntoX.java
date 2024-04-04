package com.vipin.algorithm.grpah.dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import com.vipin.algorithm.array.MinNoOfSwapRequiredToMakeAllNumberTogetherLesserThanB.Solution;

public class OSurroundedByXTurnIntoX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Character>> a = new ArrayList<ArrayList<Character>> ();
		ArrayList<Character> a1 = new ArrayList<Character>();
		a1.add('X');a1.add('X');a1.add('X');a1.add('X');
		
		ArrayList<Character> a2 = new ArrayList<Character>();
		a2.add('O');a2.add('O');a2.add('O');a2.add('X');
		
		ArrayList<Character> a3 = new ArrayList<Character>();
		a3.add('X');a3.add('X');a3.add('O');a3.add('X');
		
		ArrayList<Character> a4 = new ArrayList<Character>();
		a4.add('X');a4.add('O');a4.add('X');a4.add('X');
		a.add(a1);a.add(a2);a.add(a3);a.add(a4);
		
		OSurroundedByXTurnIntoX o = new OSurroundedByXTurnIntoX();
		o.solve(a);
		
	}
	
	public void solve(ArrayList<ArrayList<Character>> a) {
        int N = a.size();
        int M = a.get(0).size();
        boolean [][]visit = new boolean[N][M];
        
        bfs(a, visit);
	}

    void bfs(ArrayList<ArrayList<Character>> a, boolean [][]visit) {
        Queue<int[]>qe = new LinkedList<int[]>();
        int N = a.size();
        ArrayList<Character> rows = a.get(0);
        int M = rows.size();

        for(int i=0; i<M; i++) {
            if(rows.get(i)=='O') {
                qe.offer(new int[]{0,i});
            }
        }
        ArrayList<Character> lastRows = a.get(N-1);
        for(int i=0; i<M; i++) {
            if(lastRows.get(i)=='O') {
                qe.offer(new int[]{N-1,i});
            }
        }
        for(int i=0; i<N; i++) {
            ArrayList<Character> row = a.get(i);
            if(row.get(0)=='O') {
                qe.offer(new int[]{i,0});
            }
            if(row.get(M-1)=='O') {
                qe.offer(new int[]{i,M-1});
            }
        }
        int dx[] = {-1,0, 1,  0};
        int dy[] = {0, 1, 0, -1};
        while(!qe.isEmpty()) {
            int[] top = qe.poll();
            int row = top[0];
            int col = top[1];
            visit[row][col]=true;
            for(int i=0; i<4; i++) {
                if((row + dx[i]>-1 && row + dx[i]<N) && (col+dy[i]>-1 && col+dy[i]<M)) {
                    if(a.get(row+dx[i]).get(col+dy[i])=='O' && !visit[row+dx[i]][col+dy[i]]) {
                        visit[row+dx[i]][col+dy[i]]=true;
                        qe.offer(new int[]{row+dx[i], col+dy[i]});
                    }
                }
            }
        }

        for(int i=1; i<N-1; i++) {
            for(int j=1; j<M-1; j++) {
                if(a.get(i).get(j)=='O' && !visit[i][j]) {
                    a.get(i).set(j, 'X');
                }
            }
        }
        return;
        
    }

}
