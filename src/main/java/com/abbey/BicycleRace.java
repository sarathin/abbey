package com.abbey;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class BicycleRace {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int noOfProblem = Integer.parseInt(in.nextLine());
		StringBuffer answer = new StringBuffer();
		NumberFormat nf = new DecimalFormat("###.#######");
		
		for(int i=0; i<noOfProblem; i++) {
			String[] input = in.nextLine().split(" ");
			double d = Integer.parseInt(input[0]);
			double s1 = Integer.parseInt(input[1]);
			double s2 = Integer.parseInt(input[2]);
			
			answer.append(nf.format(s1 * ( d / (s1+s2))) );
			answer.append(" ");
			
			
		}
		in.close();
		System.out.println(answer);
	}

}
