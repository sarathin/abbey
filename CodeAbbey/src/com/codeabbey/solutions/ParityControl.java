package com.codeabbey.solutions;

import java.util.Scanner;

public class ParityControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String[] pStatement = input.nextLine().split(" ");
		String fmt = new String();
		StringBuffer tmp ;
		input.close();
		String binary = new String();

		for (int x = 0; x < pStatement.length-1; x++) {
			// convert string to binary value
			binary = Integer.toBinaryString(Integer.parseInt(pStatement[x]));
			System.out.print(pStatement[x] + "\t" + binary.length() + "\t");
			if (binary.length() != 8) {
				fmt = "%" + (8 - binary.length()) + "s";
				binary = String.format(fmt, "0") + binary;
			}
			System.out.print(binary.length() + "\t" + binary + "\t");
			
			if (isOdd(binary)) {
				if (binary.charAt(0) == '1') {
					 tmp = new StringBuffer(binary);
					 binary = tmp.replace(0, 1, "0").toString();
					 System.out.print( "\t" + binary);
				}else {
					System.out.print("\t        ");
				}
				System.out.println("\t" + Integer.parseInt(binary, 2) + "\t" + (char) Integer.parseInt(binary, 2));
				
			}else {
				System.out.println("");
			}
		}

	}
	
	static boolean isOdd(String v) {
		
		int total=0;
		
		
		for(int x=0; x<v.length(); x++) {
			total+= Integer.parseInt( Character.toString( v.charAt(x)));
		}
		
		return (total%2 == 0);
		
	}

}
