import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CallLogProcessor extends Thread {
    private static final Object lock = new Object();
    private static Map<String, Counter> operatorCallCounts = new HashMap<>();
    private static int maxCallCount = 0;
    private static String maxOperatorLogin = null;
    private String logFilePath;
    public static String getResult() {
        synchronized (lock) {
            return maxOperatorLogin;
        }
    }
    public CallLogProcessor(String logFilePath) {
        super();
        this.logFilePath = logFilePath;
    }
    public void run() {
        super.run();
        try (BufferedReader fileReader = new BufferedReader(new FileReader(this.logFilePath))) {
            String s, operatorLogin;
            int callCount;
            while ((s = fileReader.readLine()) != null) {
                operatorLogin = s.split(",")[2];
                synchronized (lock) {
                    if (operatorCallCounts.containsKey(operatorLogin))
                        callCount = operatorCallCounts.get(operatorLogin).increment();
                    else {
                        operatorCallCounts.put(operatorLogin, new Counter(1));
                        callCount = 1;
                    }
                    if (callCount > maxCallCount) {
                        maxCallCount = callCount;
                        maxOperatorLogin = operatorLogin;
                    }
                }
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
