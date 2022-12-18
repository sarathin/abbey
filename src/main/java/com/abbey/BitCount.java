package com.abbey;

import java.util.Scanner;

public class BitCount {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		in.nextLine();
		String[] values = in.nextLine().split(" ");
		in.close();
		StringBuffer answer = new StringBuffer();
		for (int i = 0; i < values.length; i++) {
			String binary = Integer.toBinaryString(Integer.parseInt(values[i]));
			answer.append(getCountOfOnes(binary));
			answer.append(" ");
		}
		System.out.println(answer);
	}
	
	static int getCountOfOnes(String v) {
		int value=0;
		for(int i=0; i<v.length(); i++) {
//			if (String.valueOf(v.charAt(i)).equals("1"))
//				value++;
//			Another solution
			value+=Integer.parseInt(String.valueOf(v.charAt(i)));
		}
		
		return value;
	}

}
