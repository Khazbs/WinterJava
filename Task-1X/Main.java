import java.util.ArrayDeque;
import java.util.Scanner;

class Main {
    public static String flipVowels(String string) {
        ArrayDeque<String> vowels = new ArrayDeque<String>();
        for (int i = 0; i < string.length(); ++i)
            if ("aeiou".contains("" + string.charAt(i)))
                vowels.push("" + string.charAt(i));
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < string.length(); ++i)
            if ("aeiou".contains("" + string.charAt(i)))
                result.append(vowels.pop());
            else
                result.append(string.charAt(i));
        return result.toString();
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println(flipVowels(in.next()));
        }
    }
}

