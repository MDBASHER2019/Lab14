package edu.cscc;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 *author@ Md Basher
 * Date: 12/08/2019
 * ProjectName: CSCI-2467 Lab 14 – Sorting Algorithms
 */

public class CensusData {
    public static String[] deserialize(String fname) throws IOException, ClassNotFoundException {
        ObjectInputStream objIn = new ObjectInputStream(new FileInputStream(fname));
        String[] names = (String[]) objIn.readObject();
        objIn.close();
        return names;
    }
}
