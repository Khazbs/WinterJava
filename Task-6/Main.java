import java.io.*;
import java.util.PriorityQueue;

public class Main {
    private static final int TOP_CALLS_SIZE = 3;
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
        PriorityQueue<Call> callsQueue = new PriorityQueue<>();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(filename))) {
            String operatorLogin;
            int startTime, endTime;
            while ((s = fileReader.readLine()) != null) {
                ss = s.split(",");
                startTime = Integer.parseInt(ss[0]);
                endTime = Integer.parseInt(ss[1]);
                operatorLogin = ss[2];
                callsQueue.offer(new Call(startTime, endTime, operatorLogin));
                if (callsQueue.size() > TOP_CALLS_SIZE)
                    callsQueue.poll();
            }
        }
        Call[] topCalls = new Call[3];
        callsQueue.toArray(topCalls);
        for (int i = 0; i < TOP_CALLS_SIZE; ++i)
            System.out.println(topCalls[(TOP_CALLS_SIZE - 1) - i]);
    }
}
