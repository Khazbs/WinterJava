import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String filename;
        try {
            filename = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No argument passed to the program");
            return;
        }
        int c, wordCount = 0;
        boolean isInWord = false;
        try (Reader fileReader = new FileReader(filename)) {
            while ((c = fileReader.read()) != -1) {
                if (Character.isWhitespace(c))
                    isInWord = false;
                else {
                    if (!isInWord)
                        ++wordCount;
                    isInWord = true;
                }
            }
        }
        System.out.println(wordCount);
    }
}

