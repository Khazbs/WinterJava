import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<String> path = new Stack<>();
        sc.useDelimiter("/");
        String nextDir;
        while (sc.hasNext()) {
            nextDir = sc.next();
            if (nextDir.equals(".."))
                if (path.empty() || path.peek().equals(".."))
                    path.push("..");
                else
                    path.pop();
            else if (nextDir.equals("."));
            else
                path.push(nextDir);
        }
        String[] dirs = new String[path.size()];
        path.toArray(dirs);
        System.out.println(String.join("/", dirs));
    }
}
