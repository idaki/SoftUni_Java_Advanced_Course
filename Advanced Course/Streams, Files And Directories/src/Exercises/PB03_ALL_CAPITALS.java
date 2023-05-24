package Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PB03_ALL_CAPITALS {
    public static void main(String[] args) throws IOException {


        Path pathRead = Paths.get("C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams, Files And Directories\\Resources\\input.txt");
        Path pathWrite = Paths.get("C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams, Files And Directories\\Resources\\output.txt");
        List<String> allLines = Files.readAllLines(pathRead);
        allLines = allLines.stream().map(String::toUpperCase).collect(Collectors.toList());
        Files.write(pathWrite, allLines);
    }
}