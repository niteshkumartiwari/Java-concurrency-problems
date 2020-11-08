package readerWriter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Driver {
    public static void main(String[] args) {
        ReentrantLock readerCountLock= new ReentrantLock();
        Semaphore exclusiveLock= new Semaphore(1);

        Reader reader= new Reader(readerCountLock,exclusiveLock);
        Writer writer= new Writer(exclusiveLock);

        final int READER_COUNT= 30;
        final int WRITER_COUNT= 10;

        ExecutorService writerService = Executors.newFixedThreadPool(5);//5 concurrent writers
        ExecutorService readerService = Executors.newFixedThreadPool(10);//10 concurrent readers
        for(int i=0;i< READER_COUNT; i++){
            if(i<WRITER_COUNT){
                Thread tmp2= new Thread(writer);
                writerService.execute(tmp2);
            }
            Thread tmp1= new Thread(reader);
            readerService.execute(tmp1);
        }


    }
}
