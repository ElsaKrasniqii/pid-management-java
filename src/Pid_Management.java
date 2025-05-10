import java.util.BitSet;
import java.util.Scanner;

public class Pid_Management{
    private static final int MIN_PID = 300;
    private static final int MAX_PID = 5000;
    private static BitSet pidMap;

    public static boolean isAllocated(int pid) {
        if (pid < MIN_PID || pid > MAX_PID) {
            throw new IllegalArgumentException("PID jashtë rangut të lejuar: " + pid);
        }
        return pidMap.get(pid - MIN_PID);
    }


}