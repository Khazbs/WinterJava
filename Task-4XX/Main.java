import java.io.*;
import java.util.ArrayList;
import java.util.List;

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
        List<Integer> ends = new ArrayList<>();
        int start, i, callCount, peakCount = 0;
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            while ((s = fileReader.readLine()) != null) {
                ss = s.split(",");
                start = Integer.parseInt(ss[0]);
                ends.add(Integer.parseInt(ss[1]));
                callCount = 0;
                for (i = 0; i < ends.size(); ++i) {
                    if (ends.get(i) > start)
                        ++callCount;
                    else
                        ends.remove(i);
                }
                if (callCount > peakCount)
                    peakCount = callCount;
            }
        }
        System.out.println(peakCount);
    }
}

