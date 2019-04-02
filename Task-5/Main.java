import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] commentsArray = {
                "Fuck you",
                "Impeccable",
                "This is a great article",
                "The article is a piece of shit",
                "You must be a bitch to write this",
                "Thank you so much for a wonderful read",
                "Check out my new video https://youtu.be/dQw4w9WgXcQ",
        };
        String[] swearWordsArray = {
                "fuck", "shit", "bitch",
        };
        List<String> comments = new LinkedList<>(Arrays.asList(commentsArray));
        Set<String> blackList = new HashSet<>(Arrays.asList(swearWordsArray));
        BlackListFilter filter = new WordFilter();
        filter.filterComments(comments, blackList);
        for (String comment : comments) {
            System.out.println(comment);
        }
    }
}
