package producerConsumer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class BlockMeQueue<T>{
    private Queue<T> queue;
    private int max=16;
    private ReentrantLock lock;
    private Condition notEmpty,notFull;

    public BlockMeQueue(int size){
        queue= new LinkedList<>();
        max=size;
        lock= new ReentrantLock(true);
        notEmpty= lock.newCondition();
        notFull= lock.newCondition();
    }

    public void put(T t) throws InterruptedException {
        lock.lock();
        try {
            if(queue.size() == max){
                notFull.await();
            }
            queue.add(t);
            notEmpty.signalAll();
        }finally {
            lock.unlock();
        }

    }

    public T take() throws InterruptedException {
        lock.lock();
        try {
            if(queue.size() == 0){
                notEmpty.await();
            }
            T item= queue.remove();
            notFull.signalAll();
            return item;
        }finally {
            lock.unlock();
        }
    }
}
