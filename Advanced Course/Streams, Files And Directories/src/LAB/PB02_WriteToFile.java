package LAB;

import java.io.*;

public class PB02_WriteToFile {
    public static void main(String[] args) throws IOException {
        String pathRead = "C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        String pathWrite = "C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\02.WriteToFileOutput.txt";


        FileInputStream inputStream = new FileInputStream(pathRead);
        FileOutputStream outputStream = new FileOutputStream(pathWrite);
        char currentChar = ' ';
        currentChar = (char) inputStream.read();

           while (currentChar>=0){

               if (currentChar != '.' && currentChar != ',' && currentChar != '!' && currentChar != '?'){
                   outputStream.write(currentChar);
            }
               currentChar = (char) inputStream.read();
           }
           inputStream.close();
           outputStream.close();



    }
}
