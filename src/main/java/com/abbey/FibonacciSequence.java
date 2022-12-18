package com.abbey;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

public class FibonacciSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		ArrayList<String> problems = new ArrayList<>();
		
		
		int noOfInputs = Integer.parseInt(in.nextLine());
		
		for(int x=0; x<noOfInputs; x++) {
			problems.add(in.nextLine());
		}
		in.close();
		
		for(String p : problems) {
			int no = getFibonacciIndex(p);
			//System.out.print( no + "\n\t" + p + "\n\t" + getFib(no) + "\n" );
			System.out.print(no + " ");
		}
		System.out.println("");

	}
	
	
	public static String getFib(int no) {
		double goldenMean = (1 + Math.sqrt(5)) / 2;
		double associatedGoldenMean = (1 - Math.sqrt(5)) / 2;
		BigDecimal diviser = new BigDecimal(Math.sqrt(5));
		BigDecimal bdGoldenMean = new BigDecimal(goldenMean);
		BigDecimal bdAssociatedMean = new BigDecimal(associatedGoldenMean);

		return (bdGoldenMean.pow(no).subtract( bdAssociatedMean.pow(no))).divide(diviser).toBigInteger().toString();
		//return BigDecimal.valueOf(((Math.pow(goldenMean, no) - Math.pow(associatedGoldenMean, no)) / Math.sqrt(5))).toPlainString();
	}

	public static int getFibonacciIndex(String febNo) {

		if (febNo.equals("0")) {
			return 0;
		}
		String calculatedValue = null; 
		BigDecimal bd = null;
		BigDecimal biFebNo = new BigDecimal(febNo);
//		System.out.println(biFebNo);
		int fibIdxLow = 1;
		int fibIdxHigh = 1000;
		int fibIdx = 0;
		
		int oldIdx = -1 ;
		int max=0;
		do {
			if (bd == null) {
				fibIdx = (fibIdxLow + fibIdxHigh) /2;
			}else if(bd.compareTo(biFebNo) < 0 )  {
//				System.out.println("\tincreasing lower limit");
				fibIdxLow = (int) fibIdx ;
				fibIdx = (fibIdxLow + fibIdxHigh) /2;
			}else if (bd.compareTo(biFebNo) > 0 ) {
//				System.out.println("\tdecreasing upper imit");
				fibIdxHigh = (int) fibIdx;
				fibIdx = (fibIdxLow + fibIdxHigh) /2;
			}
			
			if (fibIdx == oldIdx) 
				break;
			
			oldIdx = fibIdx;
			
			calculatedValue = getFib(fibIdx);
			//System.out.println( "(" + fibIdx + ")" + "\n\t" + febNo + "\n\t" + calculatedValue);
			if (calculatedValue.equals(febNo)) {
				break;
			}else {
				bd = new BigDecimal(calculatedValue);
			}
			
			max = (bd.toString().length() < febNo.length()) ? bd.toString().length() : febNo.length();
			max = (max<11)?max:11;
			
		}while(! bd.toBigInteger().toString().substring(0, max).equals(febNo.substring(0,max)) ); //&& count-- >0);
		
		return fibIdx;

	}

}
