package Exercises;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PB01_Sum_Lines {
    public static void main(String[] args) {


        String inputPath = "C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams, Files And Directories\\Resources\\input.txt";

        {
            try (BufferedReader read = Files.newBufferedReader(Paths.get(inputPath))) {

                String line = read.readLine();
                while (line != null) { int sum = 0;

                    for (char character : line.toCharArray()) {
                        sum += character;
                    }
                line=   read.readLine();
                    System.out.println(sum);
                }


            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
