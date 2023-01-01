package com.codeabbey.solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class RockPaperScissors {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input = new Scanner(System.in);
		int problems = Integer.parseInt(input.nextLine());
		ArrayList<String> problemList = new ArrayList<String>();

		for (int x = 0; x < problems; x++) {
			problemList.add(input.nextLine());
		}
		input.close();

		System.out.println("");

		for (String p : problemList) {
			findWinner(p);
		}
	}

	static void findWinner(String resultList) {
		String[] matches = resultList.split(" ");
		int one = 0, two = 0;
		char p1, p2;
		for (int x = 0; x < matches.length; x++) {
			p1 = matches[x].charAt(0);
			p2 = matches[x].charAt(1);

			if (p1 == 'R') {
				if (p2 == 'S') {
					one++;
				} else if (p2 == 'P') {
					two++;
				}
			} else if (p1 == 'P') {
				if (p2 == 'R') {
					one++;
				} else if (p2 == 'S') {
					two++;
				}
			} else if (p1 == 'S') {
				if (p2 == 'R') {
					two++;
				} else if (p2 == 'P') {
					one++;
				}
			}
		}

		System.out.print(one > two ? "1 " : "2 ");
	}
}
