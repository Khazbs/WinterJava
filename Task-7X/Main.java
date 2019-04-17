import java.util.Arrays;
import java.util.List;

public class Main {
    public static String getBestWorker(List<String> logs) throws InterruptedException {
        CallLogProcessor[] logProcessors = new CallLogProcessor[logs.size()];
        for (int i = 0; i < logs.size(); ++i) {
            logProcessors[i] = new CallLogProcessor(logs.get(i));
            logProcessors[i].start();
        }
        for (CallLogProcessor logProcessor : logProcessors)
            logProcessor.join();
        return CallLogProcessor.getResult();
    }
    public static void main(String[] args) throws InterruptedException {
        String dir = "C:\\calls\\";
        List<String> logs = Arrays.asList(
                dir + "mon.log",
                dir + "tue.log",
                dir + "wed.log",
                dir + "thu.log",
                dir + "fri.log",
                dir + "sat.log",
                dir + "sun.log"
        );
        String bestWorker = getBestWorker(logs);
        if (bestWorker != null)
            System.out.println("Congratulations to our best worker of the week: \"" + bestWorker + "\"!");
        else
            System.out.println("No best worker this week, we need to do better next time!");
    }
}