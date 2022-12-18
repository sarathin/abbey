package com.abbey;

import java.util.Scanner;

public class BullsAndCows {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String no2Guess = line.split(" ")[0];
		int noOfGuess = Integer.parseInt(line.split(" ")[1]);
		String[] guesses =in.nextLine().split(" ");
		in.close();
		
		StringBuffer answer = new StringBuffer();
		for(int i=0; i<noOfGuess; i++) {
			answer.append(getCowsAndBulls(no2Guess, guesses[i]));
			answer.append(" ");
		}
		System.out.println(answer);
	}
	
	static String getCowsAndBulls(String source, String target) {
		int cows=0;
		int bulls=0;
		for(int i=0; i<source.length(); i++) {
			if (source.contains(String.valueOf(target.charAt(i)))) {
				if (source.indexOf(target.charAt(i)) == i)
					cows++;
				else
					bulls++;
			}
		}
		
		return cows + "-" + bulls;
	}

}
