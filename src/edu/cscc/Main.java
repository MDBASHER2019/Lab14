package edu.cscc;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * author@ Md Basher
 * Date: 12/08/2019
 * ProjectName: CSCI-2467 Lab 14 – Sorting Algorithms
 * SourceNote:
 * Implement a Bubble Sort for sorting arrays of Strings.
 * Modify the Main method to first call your Bubble Sort sort method and then call Java’s built-in sort.
 * Make sure that your Bubble Sort is working properly. When you run the program, it will compare the run times of
 * ...your Bubble Sort and the Java sort algorithm using the list of 100 surnames.
 * Once you are convinced the program is working, change the program to use the larger dataset.
 * Run the program and compare the run times of the two algorithms.
 *
 * Once you’ve completed the program, answer the following questions.
 * Zip your project and submit your zipped project for grading and the answers to the following questions:
 * 1.	For a list of 100 surnames, how many milliseconds did a Bubble Sort take?
 * 2.	For a list of 100 surnames, how many milliseconds did a Java’s Sort take?
 * 3.	For a list of 25,000 surnames, how many milliseconds did a Bubble Sort take?
 * 4.	For a list of 25,000 surnames, how many milliseconds did a Java’s Sort take?
 * 5.	Which algorithm is more efficient?
 */

public class Main {

    // SourceNote: Once your code is working and tested, switch to the file bigsurnames.ser
   // private static final String SERFNAME = "surnames.ser";
    public static String SERFNAME = "surnames.ser";

    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String[] surnames;
        String str;

        do {
            System.out.println("Which file would you like to use?\n a)100 names Or\n b) 25,000 names");
            str = input.nextLine();
            if (str.equalsIgnoreCase("a")){
                SERFNAME = "surnames.ser";
            } else if (str.equalsIgnoreCase("b")){
                SERFNAME = "bigsurnames.ser";
            }

        } while (!(str.equalsIgnoreCase("a")|| str.equalsIgnoreCase("b")));

        try {
            surnames = CensusData.deserialize(SERFNAME);
            System.out.println("Unsorted array of "+surnames.length+" names");
            top5names(surnames);
            System.out.println("=========================");

            System.out.println("Sort array with Bubble Sort");
            long start = System.currentTimeMillis();
            // SorceNote: Once you've implemented Bubble Sort - call your Bubble Sort's sort method to sort the array
            BubbleSort.sort(surnames);
            long stop = System.currentTimeMillis();
            System.out.println("Elapsed time: "+(stop-start)+" milliseconds");
            top5names(surnames);
            System.out.println("=========================");

            surnames = CensusData.deserialize(SERFNAME);
            System.out.println("Sort array with Java built-in sort");
            start = System.currentTimeMillis();
            // Using Java's built-in sort method to sort the array
            Arrays.sort(surnames);
            stop = System.currentTimeMillis();
            System.out.println("Elapsed time: "+(stop-start)+" milliseconds");
            top5names(surnames);
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("Cannot read file "+SERFNAME);
        }
    }

    public static void top5names(String[] names) {
        System.out.println("Top 5 names in list");
        for (int i=0; i<5; ++i) {
            System.out.println(names[i]);
        }
    }
}
