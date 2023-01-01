package com.codeabbey.solutions;

import java.util.ArrayList;
import java.util.List;

public class PrimeNumbersGeneration {
    public static void main(String[] args){
        List<Integer> numberToChk = getOddNumbersInRange(101);
        List<Integer> primeStorage = new ArrayList<>();
        for (Integer i : numberToChk){
            System.out.print(i + " ");
        }

        removeNonPrime(numberToChk);

    }

    static void removeNonPrime(List<Integer> listToUpdate){
        int n = listToUpdate.get(0);
    }

    static List<Integer> getOddNumbersInRange(int max){
        ArrayList<Integer> oddNumbers = new ArrayList<>();
        for(int x=1; x<= max; x+=2){
            oddNumbers.add(x);
        }
        return oddNumbers;
    }
}
