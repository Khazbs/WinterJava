import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        String filename;
        try {
            filename = args[0];
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No argument passed to the program");
            return;
        }
        String s;
        String[] ss;
        Map<String, Sum> operatorCallTimes = new HashMap<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            String login;
            int start, end;
            while ((s = fileReader.readLine()) != null) {
                ss = s.split(",");
                start = Integer.parseInt(ss[0]);
                end = Integer.parseInt(ss[1]);
                login = ss[2];
                if (operatorCallTimes.containsKey(login))
                    operatorCallTimes.get(login).add(end - start);
                else
                    operatorCallTimes.put(login, new Sum(end - start));
            }
        }
        int totalCallTime = 0;
        for (String login : operatorCallTimes.keySet())
            totalCallTime += operatorCallTimes.get(login).getSum();
        System.out.println(totalCallTime / operatorCallTimes.size());
    }
}
