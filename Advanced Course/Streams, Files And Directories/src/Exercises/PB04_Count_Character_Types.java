package Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class PB04_Count_Character_Types {
    public static void main(String[] args) throws IOException {


        Path pathRead = Paths.get("C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams, Files And Directories\\Resources\\input.txt");
        Path pathWrite = Paths.get("C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams, Files And Directories\\Resources\\output.txt");
        List<String> allLines = Files.readAllLines(pathRead);
        final int[] vowels = {0};
        final int[] punctuation = {0};
        final int[] others = {0};
        for (String line : allLines) {
            line.chars().forEach(e -> {
                char c = (char) e;
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels[0]++;
                } else if (c == '!' || c == '.' || c == ',') {
                    punctuation[0]++;
                } else if (c != ' ') {
                    others[0]++;
                }
            });
        }
        System.out.println("Vowels: " +Arrays.toString(vowels).replaceAll("[\\[\\]]","") );
        System.out.println("Other symbols: "+ Arrays.toString(others).replaceAll("[\\[\\]]","") );
        System.out.println("Punctuation: "+ Arrays.toString(punctuation).replaceAll("[\\[\\]]","") );
    }
}
