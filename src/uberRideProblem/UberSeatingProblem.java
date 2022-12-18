package uberRideProblem;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UberSeatingProblem {
    private final Lock lock = new ReentrantLock();
    private final Semaphore democratsWaiting = new Semaphore(0);
    private final Semaphore republicansWaiting = new Semaphore(0);
    private final CyclicBarrier barrier = new CyclicBarrier(4);

    private int democrats = 0, republicans = 0;

    void seatDemocrats() throws InterruptedException, BrokenBarrierException {
        /**
         * One thread as a leader to tell driver to drive
         */
        boolean rideLeader = false;
        lock.lock();

        democrats++;

        if (democrats == 4) {
            /**
             * Seat all democrats in the car
             */
            democratsWaiting.release(3); // 3 because this current is already free
            democrats -= 4;
            rideLeader = true;
        } else if (democrats == 2 && republicans >= 2) {
            democratsWaiting.release(1);
            democrats -= 2;
            republicansWaiting.release(2);
            republicans -= 2;
            rideLeader = true;
        } else {
            /**
             * Releasing the lock before going to sleep
             */
            lock.unlock();
            democratsWaiting.acquire();
        }

        seated();
        barrier.await();

        if (rideLeader == true) {
            drive();
            lock.unlock();
        }
    }

    void seatRepublicans() throws InterruptedException, BrokenBarrierException {
        boolean rideLeader = false;
        lock.lock();

        republicans++;

        if (republicans == 4) {
            republicansWaiting.release(3);
            republicans -= 4;
            rideLeader = true;
        } else if (republicans == 2 && democrats >= 2) {
            republicansWaiting.release(1);
            republicans -= 2;
            democratsWaiting.release(2);
            democrats -= 2;
            rideLeader = true;
        } else {
            lock.unlock();
            republicansWaiting.acquire();
        }

        seated();
        barrier.await();

        if (rideLeader) {
            drive();
            lock.unlock();
        }
    }

    void seated() {
        System.out.println(Thread.currentThread().getName() + " seated");
    }

    void drive() {
        System.out.println("Uber ride started with leader : " + Thread.currentThread().getName());
    }


}
