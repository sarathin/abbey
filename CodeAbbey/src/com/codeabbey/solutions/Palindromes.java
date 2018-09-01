package com.codeabbey.solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class Palindromes {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int count = Integer.parseInt(input.nextLine());
		ArrayList<String> inputs = new ArrayList<String>();

		for (int x = 0; x < count; x++) {
			inputs.add(input.nextLine());
		}
		input.close();

		for (String s : inputs) {
			IsAPalindrome(s);
		}
	}

	static int IsAPalindrome(String val) {

		val = stripNonAlpha(val);

		for (int x = 0, y = val.length() - 1; x < val.length() / 2; x++, y--) {
			if (val.charAt(x) != val.charAt(y)) {
				System.out.print("N ");
				return 1;
			}
		}

		System.out.print("Y ");
		return 0;
	}

	static String stripNonAlpha(String val) {
		StringBuffer sb = new StringBuffer();

		val = val.toLowerCase();
		for (int x = 0; x < val.length(); x++) {
			if (val.charAt(x) >= 'a' && val.charAt(x) <= 'z') {
				sb.append(val.charAt(x));
			}
		}

		return sb.toString();
	}

}
