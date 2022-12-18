package com.abbey;

import java.util.ArrayList;
import java.util.Scanner;

public class TicTacToe {

	static String t3Board[][]; 
	static StringBuffer answer = new StringBuffer();
	
	public static void main(String[] args) throws InterruptedException {
		
		Scanner in = new Scanner(System.in);
		int noOfCases = Integer.parseInt(in.nextLine()); 
		ArrayList<String[]> moves = new ArrayList<String[]>();
		
		for(int i=0; i<noOfCases; i++) {
			moves.add( in.nextLine().split(" "));
		}
		in.close();
		
		for(int i=0;i < noOfCases; i++) {
			t3Board = newBoard(); 
			if ( !populateBoard(moves.get(i))) {
				answer.append("0 ");
			}
		}
		
		System.out.println(answer);
	}

	static String[][] newBoard(){
		return new String[][] {
			{" ", " ", " "},
			{" ", " ", " "},
			{" ", " ", " "}
		};
	}
	static boolean populateBoard(String[] values) throws InterruptedException {
		int row, col;
		for(int i=0; i <9; i++) {
			int pos = Integer.parseInt(values[i])-1;
			row = pos/3;
			col = pos%3;
			t3Board[row][col]= (i%2)==0 ? "x" : "o";
			//printBoard();
			
			if (i > 3) {
				if (getAnswer()) { 
					answer.append( String.valueOf(i+1) + " ");
					return true;
				}
			}
		}
		return false;
	}
	

	private static void printBoard() {
		// TODO Auto-generated method stub
		for(int row=0; row<3; row++) {
			for(int col=0; col<3; col++) {
				System.out.print(t3Board[row][col] + " | ");
			}
			System.out.println();
		}
		System.out.println("\n");
	}

	static boolean getAnswer() {
		boolean solved=false;
		
		//if there is answer in columns
		for(int col=0; col<3 && !solved;col++) {
			if ( t3Board[0][col].equals(t3Board[1][col]) && 
					t3Board[0][col].equals(t3Board[2][col]) &&
					!t3Board[0][col].equals(" ") ) {
				solved = true;
			}
			
		}
		
		if (!solved) {
			for(int row=0; row<3 && !solved; row++) {
				if ( t3Board[row][0].equals(t3Board[row][1]) &&
						t3Board[row][0].equals(t3Board[row][2]) &&
						!t3Board[row][0].equals(" ")) {
					solved=true;
				}
			}
		}
		
		if (!solved) {
			solved = t3Board[0][0].equals(t3Board[1][1]) &&
					t3Board[0][0].equals(t3Board[2][2]) &&
					!t3Board[0][0].equals(" ") ; 
		}
		
		if (!solved) {
			solved = t3Board[0][2].equals(t3Board[1][1]) &&
					t3Board[0][2].equals(t3Board[2][0]) &&
					!t3Board[0][2].equals(" ") ; 
			
		}
			
		return solved;
	}
}
