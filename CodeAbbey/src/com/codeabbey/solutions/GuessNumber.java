package com.codeabbey.solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GuessNumber {
    static ArrayList<Number> clues = new ArrayList<>();
    static ArrayList<Number> exclude = new ArrayList<>();
    static String[] answer;

    public static void main(String[] args) {

        int noOfClues;
        Scanner in = new Scanner(System.in);

        noOfClues = Integer.parseInt(in.nextLine());

        for (int i = 0; i < noOfClues; i++) {
            clues.add(new Number(in.nextLine()));
        }
        in.close();

        updateExcludes();

        // if the same number occurs in the same position for all clues, then confirm it
        // as answer
        Number tmp = clues.get(0);
        answer = new String[tmp.size];
        for (int i = 0; i < tmp.size; i++) {
            boolean matchFound = true;
            for (Number a : clues) {

                // if the position value is same across all clues, break the
                // loop
                if (!a.getValue()[i].equals(tmp.getValue()[i])) {
                    matchFound = false;
                    break;
                }
            }
            if (matchFound) {
                answer[i] = tmp.getValue()[i];
            } else {
                answer[i] = " ";
            }
        }

        // if a unique position value is added, remove it from clue and reduce count
        for (int i = 0; i < answer.length; i++) {
            if (!answer[i].equals(" ")) {
                for (Number a : clues) {
                    a.removeValueAt(i);
                }
            }
        }
        updateExcludes();

        int maxTries = 0;
        while (maxTries++ < tmp.size) {
            // in the clues, remove any values that part of exclusion list
            for (Number n : clues) {
                for (Number e : exclude) {
                    for (int i = 0; i < n.size; i++) {
                        if (e.getValue()[i].contains(n.getValue()[i])) {
                            n.removeExcludedValue(i);
                        }
                    }
                }
            }

            // if the match count matches the number of values present in the clue these values can be confirmed as answer
            for (Number n : clues) {
                if (n.getMatchCount() == n.getPopulatedCount()) {
                    for (int i = 0; i < n.size; i++) {
                        if (answer[i].equals(" ") && !n.getValue()[i].equals(" ")) {
                            answer[i] = n.getValue()[i];
                            n.removeValueAt(i);
                        }
                    }
                }
            }

            // cross-check answer & clues and remove known answers from clues
            for (Number n : clues) {
                for (int i = 0; i < answer.length; i++) {
                    if (!answer[i].equals(" ") && !n.getValue()[i].equals(" ")) {
                        n.removeExcludedValue(i);
                    }
                }
            }
        }

        System.out.println(String.join("", answer));

    }

    static void updateExcludes() {
        for (Number n : clues) {
            if (n.getMatchCount() == 0) {
                exclude.add(n);
            }
        }

        // remove all the excluded numbers from clues
        for (Number n : exclude) {
            clues.remove(n);
        }

    }
}

class Number {
    private final String[] value;
    private int matches;
    private int populatedPos;
    int size;

    public Number(String line) {
        matches = Integer.parseInt(line.split(" ")[1]);
        value = line.split(" ")[0].split("");
        size = value.length;
        populatedPos = size;
    }

    public int getMatchCount() {
        return matches;
    }

    public String[] getValue() {
        return value;
    }

    public String toString() {
        return "{Value :" + Arrays.deepToString(value) + ", Matches :" + matches + ", populatedPos :" + populatedPos + "}";
    }

    public void removeValueAt(int index) {
        if (!value[index].equals(" ")) {
            value[index] = " ";
            matches--;
            populatedPos--;
        }
    }

    public void removeExcludedValue(int index) {
        if (!value[index].equals(" ")) {
            value[index] = " ";
            populatedPos--;
        }
    }

    public int getPopulatedCount() {
        return populatedPos;
    }
}
