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
            return -1; 
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
        Scanner scanner = new Scanner(System.in);
        allocateMap();  

        while (true) {
            System.out.println("\nZgjidhni një operacion:");
            System.out.println("1. Aloko një PID");
            System.out.println("2. Liro një PID");
            System.out.println("3. Kontrollo statusin e një PID");
            System.out.println("4. Dalja");
            System.out.print("Shkruaj opsionin (1-4): ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    int allocatedPid = allocatePid();
                    if (allocatedPid == -1) {
                        System.out.println("Gabim: Të gjithë PID-të janë të përdorur.");
                    } else {
                        System.out.println("PID i alokuar: " + allocatedPid);
                    }
                    break;

                case 2:
                    System.out.print("Shkruaj PID-në që dëshiron të lësh: ");
                    int pidToRelease = scanner.nextInt();
                    try {
                        releasePid(pidToRelease);
                        System.out.println("PID " + pidToRelease + " është liruar.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Gabim: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Shkruaj PID-në për të kontrolluar statusin: ");
                    int pidToCheck = scanner.nextInt();
                    if (isAllocated(pidToCheck)) {
                        System.out.println("PID " + pidToCheck + " është i alokuar.");
                    } else {
                        System.out.println("PID " + pidToCheck + " është i lirë.");
                    }
                    break;

                case 4:
                    System.out.println("Duke dalë nga aplikacioni...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opsion i pasaktë. Shkruaj një numër nga 1 në 4.");
            }
        }
    }


}
