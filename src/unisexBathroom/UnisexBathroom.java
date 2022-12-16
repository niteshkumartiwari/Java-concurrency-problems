package unisexBathroom;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UnisexBathroom {
    private Lock lock = new ReentrantLock();
    private Condition womenWaitingQueue = lock.newCondition();
    private Condition menWaitingQueue = lock.newCondition();

    private int womenWaiting = 0;
    private int menWaiting = 0;
    private int womenUsing = 0;
    private int menUsing = 0;

    private final int BATHROOM_CAPACITY = 5;
    private int free_resource = BATHROOM_CAPACITY;

    void maleUseBathRoom(String idx) {
        try {
            lock.lock();

            if (free_resource > 0 && (menUsing > 0 || womenUsing == 0)) {
                /**
                 * Atleast one bathroom is free and men are using the bathrooms now
                 */
                menUsing++;
                free_resource--;
                System.out.println("Man using bathroom, idx: " + idx);
                Thread.sleep(500);
                menUsing--;
                free_resource++;
                System.out.println("Man leaving bathroom, idx: " + idx);

                /**
                 * Avoiding starvation
                 * (when a man leaves the bathroom, it has to check if there are any women waiting)
                 */
                if (womenWaiting > 0) {
                    womenWaitingQueue.signal();
                }
            } else {
                /**
                 * Men must wait because
                 * 1. Capacity is exhausted with all men using it.
                 * 2. Women are using the bathroom.
                 */
                menWaiting++;
                System.out.println("Man added in wait, idx: " + idx);
                while (womenUsing > 0) {
                    /**
                     * While loop check to avoid spurious await!
                     */
                    menWaitingQueue.await();
                }
                System.out.println("Man removed from wait, idx: " + idx);
                menWaiting--;

                maleUseBathRoom(idx);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    void femaleUseBathRoom(String idx) {
        try {
            lock.lock();

            if (free_resource > 0 && (womenUsing > 0 || menUsing == 0)) {
                womenUsing++;
                free_resource--;
                System.out.println("Woman using bathroom, idx: " + idx);
                Thread.sleep(500);
                womenUsing--;
                free_resource++;
                System.out.println("Woman leaving bathroom, idx: " + idx);

                if (menWaiting > 0) {
                    menWaitingQueue.signal();
                }
            } else {
                womenWaiting++;
                System.out.println("Woman added in wait, idx: " + idx);
                while (menUsing > 0) {
                    womenWaitingQueue.await();
                }
                System.out.println("Woman removed from wait, idx: " + idx);
                womenWaiting--;

                femaleUseBathRoom(idx);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
