package lockingTree.threadSafe;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Node {
    private List<Node> child;
    private Semaphore exclusiveLockFlag, exclusiveLockCount;
    private ReentrantLock readCountLockFlag, readCountLockCount;
    private int readCountFlag, readCountCount;

    private boolean isLocked;
    private int lockdescendent;
    private Node parent;

    Node(){
        child= new ArrayList<>();
        exclusiveLockFlag= new Semaphore(1);
        exclusiveLockCount= new Semaphore(1);
        readCountLockFlag= new ReentrantLock(true);
        readCountLockCount= new ReentrantLock(true);
        readCountFlag=0;
        readCountCount=0;

        isLocked= false;
        lockdescendent=0;
        parent=null;
    }

    public boolean getIsLockedState() throws InterruptedException {
        readCountLockFlag.lock();
        readCountFlag++;
        if(readCountFlag==1) exclusiveLockFlag.acquire();
        readCountLockFlag.unlock();

        //read
        boolean result= isLocked;

        readCountLockFlag.lock();
        readCountCount--;
        if(readCountFlag==0) exclusiveLockFlag.release();
        readCountLockFlag.unlock();

        return result;
    }

    public boolean getLockDescendent(){
        ///TO-DO
        return false;
    }

    public void setLockDescendent(int change){
        //TO-DO
    }

    public void setIsLockedState(boolean currentState){
        try {
            exclusiveLockFlag.acquire();
            isLocked= currentState;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            exclusiveLockFlag.release();
        }
    }
}
