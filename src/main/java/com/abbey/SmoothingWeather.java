package com.abbey;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class SmoothingWeather {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		in.nextLine();
		String[] values =in.nextLine().split(" ");
		in.close();
		StringBuffer answer = new StringBuffer();
		answer.append(values[0] + " ");
		MathContext mc = new MathContext(12, RoundingMode.HALF_UP);
		BigDecimal div = new BigDecimal(3);
		for(int i=1; i<values.length-1; i++) {
			
			BigDecimal db = new BigDecimal(values[i-1]).add(new BigDecimal(values[i], mc)).add(new BigDecimal(values[i+1], mc)).divide(div, mc);
			answer.append(new BigDecimal(db.stripTrailingZeros().toPlainString()));
			answer.append(" ");
		}
		answer.append(values[values.length-1]);
		System.out.println(answer);
	}

}
