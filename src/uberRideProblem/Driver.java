package uberRideProblem;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.BrokenBarrierException;

public class Driver {
    public static void main(String[] args) throws InterruptedException {
        UberSeatingProblem uberRide = new UberSeatingProblem();
        Set<Thread> allThreads = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(() -> {
                try {
                    uberRide.seatDemocrats();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            thread.setName("Democrat_" + (i + 1));
            allThreads.add(thread);
            Thread.sleep(50);
        }

        for (int i = 0; i < 14; i++) {
            Thread thread = new Thread(() -> {
                try {
                    uberRide.seatRepublicans();
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });

            thread.setName("Republican_" + (i + 1));
            allThreads.add(thread);
            Thread.sleep(50);
        }

        for (Thread t : allThreads) {
            t.start();
        }

        for (Thread t : allThreads) {
            t.join();
        }
    }
}
