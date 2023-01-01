package com.codeabbey.solutions;

import java.util.Arrays;
import java.util.Scanner;

public class MatchingWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String[] input = in.nextLine().replace("end", "").split(" ");
		StringBuffer answer = new StringBuffer();
		Arrays.sort(input);
		
		for(int i=1; i<input.length; i++) {
			if (input[i-1].equals(input[i]) && answer.indexOf(input[i])==-1) {
				answer.append(input[i]);
				answer.append(" ");
			}
		}
		System.out.println(answer);
		in.close();
	}

}
