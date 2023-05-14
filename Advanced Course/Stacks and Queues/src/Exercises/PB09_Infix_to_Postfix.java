package Exercises;

import javax.swing.text.Utilities;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;


public class PB09_Infix_to_Postfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputStr = scanner.nextLine();
        String[] inputArr = inputStr.split(" ");
        String outputStr = "";
        ArrayDeque<String> operatorsStack = new ArrayDeque<>();
        ArrayDeque<String> outputQueue = new ArrayDeque<>();

        for (String element : inputArr) {
            if (element.charAt(0) == '+'
                    || element.charAt(0) == '-'
                    || element.charAt(0) == '/'
                    || element.charAt(0) == '*') {
                operatorsStack.push(String.valueOf(element));
            } else if(element.charAt(0) == '('||element.charAt(0) == ')') {

            }else{
                outputQueue.offer(String.valueOf(element));
            }
        }
        while (!outputQueue.isEmpty()){
            System.out.print(outputQueue.poll()+" ");
        }

        while (!operatorsStack.isEmpty()){
            System.out.print(operatorsStack.pop() +" ");
        }

    }
}
//Input: 3 + 4
//Push 3 to the output queue (whenever a number is read it is pushed to the output)
//Push + (or its ID) onto the operator stack
//Push 4 to the output queue
//After reading the expression, pop the operators off the stack and add them to the output.
//In this case there is only one, "+".
//Output: 3 4 +




