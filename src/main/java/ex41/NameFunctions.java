package ex41;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class NameFunctions
{
    //you have to put in the names in the input file for it to work
    //nameList = NameFunctions.readNames(inputNames) that's where the function is in main
    //function reads names and then puts them into an ArrayList
    //Returns list at the end
    public static ArrayList<String> readNames(File inputNames) throws FileNotFoundException
    {
        //Create Array List so we can return it later
        ArrayList<String> names = new ArrayList<String>();

        //Create scanner so it can read the input file for the names
        Scanner scan = new Scanner(inputNames);

        //reads the data until it reaches a nextLine, then it adds the data to the list of names
        while (scan.hasNextLine())
        {
            String people = scan.nextLine();
            names.add(people);
        }

        scan.close();

        //returns the list, then it's going to be sent into output names through the main function
        return names;
    }

    //OUTPUTNAMES HAPPENS AFTER READNAMES

    //insert names into the output file
    //NameFunctions.outputNames(nameList, outputWriter) is where it happens in main
    //Doesn't return anything
    public static void outputNames(ArrayList<String> nameList, FileWriter outputWriter) throws IOException
    {
        //header of file, it's just formatting
        outputWriter.write("Total of " + nameList.size() + " names\n");
        outputWriter.write("--------------------\n");

        //Put names in file
        for (String i : nameList)
        {
            outputWriter.write(i + "\n");
        }

        outputWriter.close();
    }
}