package readerWriter;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Writer implements Runnable{
    private Semaphore exclusiveLock;

    public Writer(Semaphore exclusiveLock) {
        this.exclusiveLock = exclusiveLock;
    }

    @Override
    public void run() {
        try {
            exclusiveLock.acquire();
        } catch (InterruptedException e) {
            System.out.println("Error while acquiring exclusive lock by writer thread");
            e.printStackTrace();
        }

        //Do Some Work
        System.out.println("Thread: "+ Thread.currentThread().getName()+ " is writing");
        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            System.out.println("Error while writer-sleeping");
            e.printStackTrace();
        }
        System.out.println("Thread: "+ Thread.currentThread().getName()+ " has FINISHED writing");

        exclusiveLock.release();
    }
}
