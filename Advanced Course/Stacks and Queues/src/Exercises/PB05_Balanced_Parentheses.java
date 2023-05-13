package Exercises;


import java.util.ArrayDeque;
import java.util.Scanner;

public class PB05_Balanced_Parentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] inputArr = scanner.nextLine().toCharArray();
        ArrayDeque<Character> stack = new ArrayDeque<>();
        ArrayDeque<Character> queue = new ArrayDeque<>();

        boolean isTrue = true;


        for (int i = 0; i < inputArr.length ; i++) {
            char current = inputArr[i];
            if (current == '[' || current == '{' || current == '(') {
                stack.push(current);
            }else if((current == ']' || current == '}' || current == ')')) {
                queue.offer(current);
            }
        }
        if (stack.size() != queue.size()){
            System.out.println("NO");
            return;
        }

        while (!stack.isEmpty()){
        char currentStack= stack.pop();
        char currentQueue = queue.poll();
            if (currentStack == '{'){
                if (currentQueue != '}'){
                    isTrue = false;
                    break;
                }
            } else if (currentStack == '[') {
                if (currentQueue != ']'){
                    isTrue = false;
                    break;
                }
            } else if (currentStack == '(') {
                if (currentQueue != ')'){
                    isTrue = false;
                    break;
                }
            }
        }

        if (isTrue){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

    }
}
