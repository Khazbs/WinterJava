import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

public class WordFilter implements BlackListFilter {
    public void filterComments(List<String> comments, Set<String> blackList) {
        Pattern re = Pattern.compile("\\W" + String.join("|", blackList) + "\\W",
                                     Pattern.CASE_INSENSITIVE);
        String comment;
        for (Iterator<String> it = comments.iterator(); it.hasNext();) {
            comment = it.next();
            if (re.matcher(comment).find())
                it.remove();
        }
    }
}
