package ex41;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NameFunctionsTest
{

    @Test
    void readNames() throws FileNotFoundException
    {
        //Allows the file to be accessed
        File test41 = new File("src/main/java/ex41/exercise41_input.txt");

        //Add names into ArrayList
        ArrayList<String> actual = new ArrayList<String>();
        actual.add("Ling, Mai");
        actual.add("Johnson, Jim");
        actual.add("Zarnecki, Sabrina");
        actual.add("Jones, Chris");
        actual.add("Jones, Aaron");
        actual.add("Swift, Geoffrey");
        actual.add("Xiong, Fong");

        //Add names into the expected list
        ArrayList<String> expected = new ArrayList<String>();
        Scanner scan = new Scanner(test41);

        while (scan.hasNextLine())
        {
            String people = scan.nextLine();
            expected.add(people);
        }
        scan.close();

        //THIS IS WHERE THE COMPARISON HAPPENS
        assertEquals(expected, actual);
    }


    //SEPARATE TESTS

    @Test
    void outputNames() throws IOException
    {

        //Add names into ArrayList
        ArrayList<String> testNames = new ArrayList<String>();
        testNames.add("Ling, Mai");
        testNames.add("Johnson, Jim");
        testNames.add("Zarnecki, Sabrina");
        testNames.add("Jones, Chris");
        testNames.add("Jones, Aaron");
        testNames.add("Swift, Geoffrey");
        testNames.add("Xiong, Fong");

        //Must create FileWriter here since we don't have access to main
        //This is so we can test it later
        FileWriter outputWriter = new FileWriter("src/test/java/ex41/exercise41_testOutput.txt");

        //Used to sort the names in ascending order (alphabetically in this case)
        Collections.sort(testNames);

        //Header formatting
        outputWriter.write("Total of " + testNames.size() + " names\n");
        outputWriter.write("-------------------------\n");

        //Puts names into the file
        for(String testTests : testNames)
        {
            outputWriter.write(testTests + "\n");
        }
        outputWriter.close();

        //THIS IS WHERE THE COMPARISON HAPPENS

        //Opens the file, reads the file into a byte array, and then closes it
        //Used to compare the two later
        //This is the original
        String expected = new String(Files.readAllBytes
                (Paths.get("src/main/java/ex41/exercise41_output.txt")));

        //This is the new one in this class
        String actual = new String(Files.readAllBytes
                (Paths.get("src/test/java/ex41/exercise41_testOutput.txt")));

        //Compares both strings to see if they were equal
        assertEquals(expected, actual);
    }
}
