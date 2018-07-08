package com.codeabbey.solutions;

import java.util.ArrayList;
import java.util.Scanner;

public class SharePrice {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		ArrayList<String> problems = new ArrayList<String>();
		int nLines = Integer.parseInt(input.nextLine());

		for (int x = 0; x < nLines; x++) {
			problems.add(input.nextLine());
		}

		input.close();

		for (int x = 0; x < problems.size(); x++) {
			float mean = getMean(problems.get(x).substring(5, problems.get(x).length()));
			float stdDeviation = getStandardDeviation(mean, problems.get(x).substring(5, problems.get(x).length()));
			float brkrComm = (mean / 100) * 4;
			if (brkrComm < stdDeviation) {
				System.out.print(problems.get(x).substring(0, 4) + " ");
			}

		}

	}

	static float getMean(String v) {
		float total = 0;
		String[] vals = v.split(" ");
		for (String s : vals) {
			total += Float.parseFloat(s);
		}

		return (total / vals.length);
	}

	static float getStandardDeviation(float avg, String v) {
		float total = 0;
		String[] vals = v.split(" ");

		for (String s : vals) {
			float x = Float.parseFloat(s) - avg;
			x *= x;
			total += x;
		}
		return (float) Math.sqrt((double) (total / (vals.length - 1)));

	}

}
