package com.abbey;

import java.util.ArrayList;
import java.util.Scanner;

public class QuadraticEquation {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner input = new Scanner(System.in);
		int i;

		int count = Integer.parseInt(input.nextLine());
		ArrayList<String> problems = new ArrayList<String>();
		for (i = 0; i < count; i++) {
			problems.add(input.nextLine());
		}
		input.close();
		i = 0;

		for (String p : problems) {
			printSolution(p);
			i++;
			if (i < problems.size()) {
				System.out.print("; ");
			}
		}

	}

	static void printSolution(String prob) {

		int a = Integer.parseInt(prob.split(" ")[0]);
		int b = Integer.parseInt(prob.split(" ")[1]);
		int c = Integer.parseInt(prob.split(" ")[2]);

		int findSQRTFor = (b * b) - (4 * a * c);

		if (findSQRTFor < 0) {
			findSQRTFor *= -1;

			System.out.print(((-1 * b / (2 * a))) + "+" + (int) Math.sqrt(findSQRTFor) / (2 * a) + "i ");
			System.out.print(((-1 * b / (2 * a))) + "-" + (int) Math.sqrt(findSQRTFor) / (2 * a) + "i");

		} else {
			System.out.print((int) ((-1 * b) + Math.sqrt(findSQRTFor)) / (2 * a) + " ");
			System.out.print((int) ((-1 * b) - Math.sqrt(findSQRTFor)) / (2 * a));
		}

	}

}
