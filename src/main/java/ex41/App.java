/*
 *  UCF COP3330 Fall 2021 Assignment 3 Solution
 *  Copyright 2021 Koby Montenegro
 */

package ex41;

import java.util.ArrayList;
import java.util.Collections;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class App
{

    public static void main(String[] args) throws IOException
    {

        //create array to hold the list of names
        ArrayList<String> nameList = new ArrayList<String>();

        //make a new file so later it can open the file so it can be accessed
        //MUST INCLUDE src/main/java/ex41/ OR ELSE IT WON'T WORK
        File inputNames = new File("src/main/java/ex41/exercise41_input.txt");

        //make a new fileWriter so it reads each string so it can be put into the array
        //MUST INCLUDE src/main/java/ex41/ OR ELSE IT WON'T WORK
        FileWriter outputWriter = new FileWriter("src/main/java/ex41/exercise41_output.txt");

        //reads the array and puts it into a list
        nameList = NameFunctions.readNames(inputNames);

        //sorts in ascending order (alphabetically in this case)
        Collections.sort(nameList);

        //puts sorted array into the output file
        NameFunctions.outputNames(nameList, outputWriter);

        //names won't show up in the IDE, it shows up in the output.txt file
    }
}
