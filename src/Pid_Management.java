import java.util.BitSet;
import java.util.Scanner;

public class Pid_Management{
    private static final int MIN_PID = 300;
    private static final int MAX_PID = 5000;
    private static BitSet pidMap;

    public static int allocateMap() {
        pidMap = new BitSet(MAX_PID - MIN_PID + 1);
        return pidMap != null ? 1 : -1;
    }


    public static int allocatePid() {
        int pidIndex = pidMap.nextClearBit(0);
        if (pidIndex >= (MAX_PID - MIN_PID + 1)) {
            return -1; // Të gjithë PID-të janë në përdorim
        }
        pidMap.set(pidIndex);
        return pidIndex + MIN_PID;
    }


    public static void releasePid(int pid) {
        if (pid < MIN_PID || pid > MAX_PID) {
            throw new IllegalArgumentException("PID jashtë rangut të lejuar: " + pid);
        }
        pidMap.clear(pid - MIN_PID);
    }
    
    public static boolean isAllocated(int pid) {
        if (pid < MIN_PID || pid > MAX_PID) {
            throw new IllegalArgumentException("PID jashtë rangut të lejuar: " + pid);
        }
        return pidMap.get(pid - MIN_PID);
    }
    public static void main(String[] args) {
        allocateMap();

        int pid1 = allocatePid();
        System.out.println("PID i alokuar: " + pid1);

        int pid2 = allocatePid();
        System.out.println("PID i dytë i alokuar: " + pid2);

        releasePid(pid1);
        System.out.println("PID i liruar: " + pid1);

        int pid3 = allocatePid(); 
        System.out.println("PID i tretë i alokuar: " + pid3);
    }

}