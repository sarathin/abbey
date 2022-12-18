package com.abbey;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CaesarShiftCipher {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);

		String firstInput = input.nextLine();
		int numberOfInputs = Integer.parseInt(firstInput.split(" ")[0]);
		int k = Integer.parseInt(firstInput.split(" ")[1]);
		ArrayList<String> codes = new ArrayList<String>();

		for (int i = 0; i < numberOfInputs; i++) {
			codes.add(input.nextLine());
		}

		input.close();
		int idx;
		String[] breaker = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
		ArrayList<StringBuffer> result = new ArrayList<StringBuffer>();
		StringBuffer answer = new StringBuffer();

		for (String code : codes) {
			answer = new StringBuffer();
			for (int i = 0; i < code.length() - 1; i++) {
				if (code.charAt(i) == ' ') {
					answer.append(" ");
				} else {
					idx = Arrays.binarySearch(breaker, Character.toString((code.charAt(i)))) - k;
					if (idx < 0) {
						idx = 26 + idx;
					}
					answer.append(breaker[idx % 26]);
				}
			}
			answer.append('.');
			result.add(answer);
		}

		for (StringBuffer sb : result) {
			System.out.print(sb.toString() + " ");
		}

	}

}
