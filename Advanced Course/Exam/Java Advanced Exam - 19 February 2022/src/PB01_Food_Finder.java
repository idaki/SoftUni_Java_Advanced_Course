import java.util.*;

public class PB01_Food_Finder {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] vowelsArr = scanner.nextLine().replace(" ", "").toCharArray();
        char[] consonantArr = scanner.nextLine().replace(" ", "").toCharArray();
        ArrayDeque<Character> vowelsQueue = new ArrayDeque<>();
        ArrayDeque<Character> consonantStack = new ArrayDeque<>();

        Map<String, List<Character>> wordsMap = new LinkedHashMap<>();
        wordsMap.put("pear", new ArrayList<>());
        wordsMap.put("flour", new ArrayList<>());
        wordsMap.put("pork", new ArrayList<>());
        wordsMap.put("olive", new ArrayList<>());

        for (char element : vowelsArr) {
            vowelsQueue.offer(element);
        }
        for (char element : consonantArr) {
            consonantStack.push(element);
        }

        while (consonantStack.size() > 0) {
            char currentVowel = ' ';
            if (vowelsQueue.size() > 0) {
                currentVowel = vowelsQueue.peek();
            }
            char currentConsonant = consonantStack.peek();
            vowelsQueue.poll();
            consonantStack.pop();
            vowelsQueue.offer(currentVowel);

            for (Map.Entry<String, List<Character>> element : wordsMap.entrySet()) {
                String word = element.getKey();

                if (word.indexOf(currentConsonant) >= 0) {
                    element.getValue().add(currentConsonant);
                }
                if (word.indexOf(currentVowel) >= 0) {
                    element.getValue().add(currentVowel);
                }
            }
        }
        int count = 0;

        List<String> print = new ArrayList<>();

        for (Map.Entry<String, List<Character>> element : wordsMap.entrySet()) {
            String word = element.getKey();
            boolean isTrue = true;
            for (char current : word.toCharArray()) {
                if (!element.getValue().contains(current)) {
                    isTrue = false;
                }
            }
            if (isTrue) {
                count++;
                print.add(word);
            }
        }
        System.out.println("Words found: "+ count);
        print.forEach(System.out::println);
    }
}
