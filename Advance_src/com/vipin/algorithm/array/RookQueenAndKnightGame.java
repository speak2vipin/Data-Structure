package com.vipin.algorithm.array;

import java.util.Arrays;

public class RookQueenAndKnightGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RookQueenAndKnightGame r = new RookQueenAndKnightGame();
		String[]A= {"...", "...", ".QR"};
		System.out.println(r.solve(A));
	}
	
	// DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
    public int solve(final String[] A) {
        int N = A.length;
        char [][]input = new char[N][N];
        for(int i=0; i<N; i++) {
        	input[i] = A[i].toCharArray();
        }
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
                if(input[i][j]=='Q') {
                	queenOpretaion(input, i, j, 'Q');
                }
                if(input[i][j]=='R') {
                	rookOpretaion(input, i, j, 'R');
                }
            }
        }
        int count = 0;
        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {
            	if(input[i][j]=='.') {
            		count++;
            	}
            }
        }
        return count;
    }
    
    void rookOpretaion(char [][]input, int i, int j, char temp) {
    	int N = input.length;
        for(int k=0; k<N; k++) {
        	if(input[i][k]=='.' || input[i][k]==temp)
        		input[i][k] = 'X';
        }
        for(int k=0; k<N; k++) {
        	if(input[k][j]=='.' || input[i][k]==temp)
        		input[k][j] = 'X';
        }
    }
    
    void queenOpretaion(char [][]input, int i, int j, char temp) {
    	int N = input.length;
        for(int k=0; k<N; k++) {
        	if(input[k][j]=='.' || input[k][j]==temp)
        		input[k][j] = 'X';
        }
        for(int k=0; k<N; k++) {
        	if(input[i][k]=='.' || input[i][k]==temp)
        		input[i][k] = 'X';
        }
        //Arrays.fill(input[i], 'X');
        int col = j;
        int row = i;
        while(row>-1 && col>-1) {
        	if(input[row][col]=='.' || input[row][col]==temp)
        		input[row][col]='X';
        	row--;
        	col--;
        }
        col = j;
        row = i;
        while(row<N && col>-1) {
        	if(input[row][col]=='.' || input[row][col]==temp)
        		input[row][col]='X';
        	row++;
        	col--;
        }
        
        col = j;
        row = i;
        while(row<N && col<N) {
        	if(input[row][col]=='.' || input[row][col]==temp)
        		input[row][col]='X';
        	row++;
        	col++;
        }
        col = j;
        row = i;
        while(row>-1 && col<N) {
        	if(input[row][col]=='.' || input[row][col]==temp)
        		input[row][col]='X';
        	row--;
        	col++;
        }
    }

}


