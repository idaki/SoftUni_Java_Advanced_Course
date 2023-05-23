package LAB;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class PB03_Copy_Bytes {
    public static void main(String[] args) throws IOException {
        String inputPath = "C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String outputPath ="C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\03.CopyBytesOutput.txt";
        FileInputStream inputStream = new FileInputStream(inputPath);
        FileOutputStream outputStream = new FileOutputStream(outputPath);

        int oneByte= inputStream.read();

        while (oneByte>=0){
            if ((oneByte==10)|| oneByte==32){
                outputStream.write(oneByte);
            }else{
                String digit = String.valueOf(oneByte);
                for (char element: digit.toCharArray()) {
                    outputStream.write(element);
                }
            }
            oneByte = inputStream.read();
        }

        inputStream.close();
        outputStream.close();


    }
}
