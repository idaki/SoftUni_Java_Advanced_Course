package LAB;

import java.io.*;
import java.util.Scanner;

public class PB04_Extract_Integers {
    public static void main(String[] args) throws FileNotFoundException {

        String inputPath = "C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath ="C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\04.ExtractIntegersOutput.txt";
        Scanner scanner = new Scanner(new FileInputStream(inputPath));

       PrintWriter out = new PrintWriter(new FileOutputStream(outputPath));

        while (scanner.hasNext()){
            if(scanner.hasNextInt()){
                out.println(scanner.nextInt());
            }
            scanner.next();
        }
        out.close();
    }
}
