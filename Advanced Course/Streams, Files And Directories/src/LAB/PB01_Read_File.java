package LAB;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class PB01_Read_File {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String path = "C:\\Users\\idaki.VENLO\\Documents\\GitHub\\SoftUni_Java_Advanced_Course\\Advanced Course\\Streams Files And Directories\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";


        try (FileInputStream in = new FileInputStream(path)) {
            int oneByte = in.read();
            while (oneByte >= 0) {
                System.out.printf("%s ",
                        Integer.toBinaryString(oneByte));
                oneByte = in.read();

            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
