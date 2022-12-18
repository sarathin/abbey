package com.abbey;

import java.util.Scanner;

public class PythagoreanTheorem {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		StringBuilder answer = new StringBuilder();
		
		int noOfProblems = Integer.parseInt(in.nextLine());
		for(int i=0; i<noOfProblems; i++) {
			String[] values = in.nextLine().split(" ");
			int a = Integer.parseInt(values[0]);
			int b = Integer.parseInt(values[1]);
			int c = Integer.parseInt(values[2]);
			
			
			int r = (int) (c - Math.sqrt( a*a + b*b ));
			
			if (r==0)
				answer.append("R ");
			else if (r < 0)
				answer.append("A ");
			else
				answer.append("O ");
		}
		in.close();
		System.out.println(answer);

	}

}
