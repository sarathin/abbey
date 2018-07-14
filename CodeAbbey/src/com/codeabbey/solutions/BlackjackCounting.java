package com.codeabbey.solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class BlackjackCounting {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		int count = Integer.parseInt(input.nextLine());

		ArrayList<String> problems = new ArrayList<String>();

		for (int i = 0; i < count; i++) {
			problems.add(input.nextLine());
		}
		input.close();

		for (String p : problems) {
			solve(p);
		}

	}

	static void solve(String prob) {

		String[] vals = prob.split(" ");
		int aCount = 0;
		int total = 0;

		for (String v : vals) {

			switch (v) {

			case "A":
				aCount++;
				break;

			case "K":
			case "Q":
			case "J":
			case "T":
				total += 10;
				break;

			default:
				total += Integer.parseInt(v);
			}
		}

		while (aCount > 0) {

			if (total + 11 <= 20 && (aCount - 1 == 1 || aCount - 1 == 0)) {
				total += 11;
			} else if (total + 11 <= 21 && aCount - 1 == 0) {
				total += 11;
			} else if (total + 1 <= 20 && (aCount - 1 == 1 || aCount - 1 == 0)) {
				total += 1;
			} else {
				total += 1;
			}
			aCount--;
		}

		if (total > 21) {
			System.out.print("BUST ");
		} else {
			System.out.print(total + " ");
		}

	}

}
