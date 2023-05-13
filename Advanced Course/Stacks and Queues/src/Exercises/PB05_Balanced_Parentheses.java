package Exercises;


import java.util.ArrayDeque;
import java.util.Scanner;

public class PB05_Balanced_Parentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] inputArr = scanner.nextLine().toCharArray();
        ArrayDeque<Character> openingBrackets = new ArrayDeque<>();


        boolean isTrue = true;


        for (int i = 0; i < inputArr.length; i++) {
            char current = inputArr[i];
            if (current == '[' || current == '{' || current == '(') {
                openingBrackets.push(current);
            } else {
                if (openingBrackets.isEmpty()) {
                    isTrue = false;
                    break;
                }
                char opening = openingBrackets.pop();
                if (current == '}' && opening != '{') {
                    isTrue = false;
                    break;
                } else if (current == ']' && opening != '[') {
                    isTrue = false;
                    break;
                } else if (current == ')' && opening != '(') {
                    isTrue = false;
                    break;
                }

            }
        }

        if (isTrue) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }

    }
}
