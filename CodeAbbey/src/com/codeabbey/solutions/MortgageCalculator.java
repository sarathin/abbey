package com.codeabbey.solutions;

import java.util.Scanner;

public class MortgageCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		String problem = input.nextLine();
		input.close();
		
		
		double loan = Double.parseDouble(problem.split(" ")[0]);
		float ratePA = Float.parseFloat(problem.split(" ")[1]);
		int months = Integer.parseInt(problem.split(" ")[2]);
		float ratePM = (ratePA / 1200);
		
		System.out.println((int) Math.ceil( (loan * ratePM * Math.pow( 1+ratePM, months)) / ( Math.pow( (1+ratePM), months)-1)) );
	}

}
