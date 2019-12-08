package edu.cscc;

/**
 * author@ Md Basher
 * Date: 12/08/2019
 * ProjectName: CSCI-2467 Lab 14 – Sorting Algorithms
 */

public class BubbleSort {
    public static void sort(String[] list) {
        /*
        Implementing a Bubble Sort for a String array
        Use the integer Bubble Sort from Unit 14 as a starting point
        You'll need to use the String compareTo() method to compare Strings
        */
        boolean change;


        do {
            change = false;
            for (int i = 0; i<= list.length - 2; i++){
                if (list[i].compareTo(list[i+1])>0) {
                    String temp = list[i + 1];
                    list[i +1] = list[i];
                    list[i] = temp;
                    change = true;

                }
            }
        } while (change);
    }
}
