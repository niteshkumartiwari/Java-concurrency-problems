package readerWriter;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Reader implements Runnable{
    private int readerCount;
    private ReentrantLock readerCountLock;
    private Semaphore exclusiveLock;

    public Reader(ReentrantLock readerCountLock, Semaphore exclusiveLock) {
        this.readerCount=0;
        this.readerCountLock = readerCountLock;
        this.exclusiveLock = exclusiveLock;
    }

    @Override
    public void run() {
        readerCountLock.lock();
        readerCount++;
        if(readerCount == 1)// if first reader stop writing
        {
            try {
                exclusiveLock.acquire();
            } catch (InterruptedException e) {
                System.out.println("Error while acquiring exclusive lock by reader");
                e.printStackTrace();
            }
        }
        readerCountLock.unlock();

        //Do Some Work
        System.out.println("Thread: "+Thread.currentThread().getName()+" is reading");
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            System.out.println("Error while reader-sleeping");
            e.printStackTrace();
        }
        System.out.println("Thread: "+Thread.currentThread().getName()+" has FINISHED reading");

        readerCountLock.lock();
        readerCount--;
        if(readerCount == 0)//last reader then release write lock
            exclusiveLock.release();
        readerCountLock.unlock();

    }
}
