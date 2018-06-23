package com.codeabbey.solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner input = new Scanner(System.in);
		
		int noOfProblems =  Integer.parseInt(input.nextLine());
		ArrayList<String> problems = new ArrayList<String>();
		
		
		for (int x=0; x< noOfProblems; x++) {
			problems.add(input.nextLine());
			
		}
		
		for(int x=0; x< problems.size(); x++) {
			System.out.print( findX( problems.get(x))  + " " );			
		}
		
		input.close();

	}
	
	static double findX(String input) {
		double x=0d;
		double a,b,c,d;
		int counter=0;
		String[] problem = input.split(" ");
		a = Double.parseDouble(problem[0]);
		b = Double.parseDouble(problem[1]);
		c = Double.parseDouble(problem[2]);
		d = Double.parseDouble(problem[3]);
		
		double min=0, max=100;
		double result=0d;
		//x = max;
		//x=73.595368554162;
		while(counter++<100) {
			x = (min + max)/2;
			result = a * x + b * Math.sqrt( Math.pow(x, 3) ) - c * Math.exp( (0-x) / 50) -d;
			
			if ( result == 0d) {
				break;
			}else {
				if ( result > 0) {
					max = x;
				}else {
					min = x;
				}
			}
		}
		
		return x;
	}

}
