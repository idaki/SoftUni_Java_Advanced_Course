package Exercises;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

public class PB06_Word_Count {
    public static void main(String[] args) throws IOException {
        Path pathRead = Paths.get("C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams, Files And Directories\\Resources\\words.txt");
        String pathOutput = "C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams, Files And Directories\\Resources\\output.txt";
        PrintWriter out = new PrintWriter(new FileWriter(pathOutput));
        HashMap<String, Integer> wordsMap = new LinkedHashMap<>();
        List<String> allLines = Files.readAllLines(pathRead);

        allLines.forEach(e->{ String[] wordsArr = e.split(" ");
            for (String word: wordsArr) {
                if (!wordsMap.containsKey(word)){
                    wordsMap.put(word,1);
                }else{
                    wordsMap.replace(word, wordsMap.get(word)+1);
                }
            }
        });

        wordsMap.entrySet()
                .stream()
                .sorted((a, b) -> Integer.compare(b.getValue(), a.getValue()))
                .forEach(entry -> {
                    out.println(String.format("%s - %d", entry.getKey(), entry.getValue()));
                });







    }
}
