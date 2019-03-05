import java.util.Scanner;

class Main {
    public static char sw(char a, char b) {
        return a;
    }
    public static String flipVowels(String string) {
        char[] result = string.toCharArray();
        int vowels = 0;
        for (char letter : result)
            if ("aeiou".contains("" + letter))
                ++vowels;
        int v = 0, l = 0, r = result.length - 1;
        while (v < vowels / 2) {
            while (!"aeiou".contains("" + result[l]))
                ++l;
            while (!"aeiou".contains("" + result[r]))
                --r;
            result[l] = sw(result[r], result[r] = result[l]);
            ++v;
            ++l;
            --r;
        }
        return String.valueOf(result);
    }
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.println(flipVowels(in.next()));
        }
    }
}

