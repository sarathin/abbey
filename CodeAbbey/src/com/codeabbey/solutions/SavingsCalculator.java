package com.codeabbey.solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class SavingsCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int noOfProbs = Integer.parseInt(input.nextLine());
		ArrayList<String> probs = new ArrayList<String>();
		for(int x =0; x< noOfProbs; x++) {
			probs.add(input.nextLine());
		}
		
		for(int x=0; x<probs.size(); x++) {
			System.out.print(findYears(probs.get(x)) + " ");
		}
		
		input.close();

	}
	
	static int findYears(String problem) {
		int years = 0 ; //, cnt=0;
		String [] parts = problem.split(" ");
		double S = Double.parseDouble( parts[0]);
		double I =0;
		
		double R = Double.parseDouble(parts[1]);
		double P = Double.parseDouble(parts[2]);
		
		while(S < R) {
			//S = Double.parseDouble( df.format(  ( S * P/100)));
			I = (double) Math.round( (S * P /100) * 100 )/100;
			//System.out.println(" \t " + S + " \t " + I);
			S =  S + I;
			S = (double) Math.round(S*100)/100;
			years++;
		}
		//System.out.println( "\t\t in " + years + "  " +  S + " vs " + R);
		return years;
	}

}
