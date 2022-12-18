package com.abbey;

import java.util.Scanner;

public class ParityControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);

		String[] pStatement = input.nextLine().split(" ");
		String fmt = new String();
		StringBuffer tmp;
		input.close();
		String binary = new String();
		StringBuffer answer = new StringBuffer();

		for (int x = 0; x < pStatement.length - 1; x++) {
			// convert string to binary value
			binary = Integer.toBinaryString(Integer.parseInt(pStatement[x]));
			if (binary.length() != 8) {
				fmt = "%0" + (8 - binary.length()) + "d";
				binary = String.format(fmt, 0) + binary;
			}

			if (isOdd(binary)) {
				if (binary.charAt(0) == '1') {
					tmp = new StringBuffer(binary);
					binary = tmp.replace(0, 1, "0").toString();
				}
				answer.append(Character.toString((char) Integer.parseInt(binary, 2)));

			}
		}
		System.out.println(answer.toString() + ".");
	}

	static boolean isOdd(String v) {

		int total = 0;

		try {
			for (int x = 0; x < v.length(); x++) {
				total += Integer.parseInt(Character.toString(v.charAt(x)));
			}
		} catch (Exception e) {
			System.out.println("\n\nException occured\n\n");
			System.out.println(e.getMessage());
			e.printStackTrace();
			System.out.println("=========================");
			return false;
		}

		return (total % 2 == 0);

	}

}
