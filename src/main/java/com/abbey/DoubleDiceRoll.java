package com.abbey;

import java.util.Scanner;

public class DoubleDiceRoll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int noOfCases = Integer.parseInt(in.nextLine());
		StringBuffer answer = new StringBuffer();
		for(int i=0; i<noOfCases; i++) {
			String value = in.nextLine();
			int a = (Integer.parseInt(value.split(" ")[0])%6)+1;
			int b = (Integer.parseInt(value.split(" ")[1])%6)+1;
			answer.append(a+b);
			answer.append(" ");
		}
		in.close();
		System.out.println(answer);
	}

}
