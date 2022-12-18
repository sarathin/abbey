package com.abbey;

public class SqrUsingBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println( findSqRt(56312));
		System.out.println( Math.sqrt(56312));
		double x = 10;
		double y = -10;
		System.out.println ( Math.exp( (0-x) / 50));
		System.out.println ( Math.exp( (y) / 50));
		System.out.println ( Math.exp( (x * -1) / 50));

	}
	
	public static double findSqRt(double val) {
		double min=0;
		double max = val/2;
		double rVal=0, srt=0;
		double counter=0;
		
		while(counter++<1000) {
			rVal = (min+max)/2;
			srt = rVal * rVal ; 
			if (srt == val) {
				break;
			}else {
				if (srt < val) {
					min = rVal;
				}else {
					max = rVal;
				}
			}
		}
		
		return rVal;
	}

}
