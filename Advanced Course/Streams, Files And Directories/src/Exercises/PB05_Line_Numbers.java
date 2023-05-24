package Exercises;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class PB05_Line_Numbers {
    public static void main(String[] args) throws IOException {
        Path pathRead = Paths.get("C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams, Files And Directories\\Resources\\inputLineNumbers.txt");
        Path pathWrite = Paths.get("C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams, Files And Directories\\Resources\\output.txt");
        List<String> allLines = Files.readAllLines(pathRead);
       allLines.forEach(e-> {int lineNum= allLines.indexOf(e)+1;
           allLines.set(allLines.indexOf(e), lineNum+". "+e );
       });

        Files.write(pathWrite, allLines);
    }
}
