import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;


public class Test {
    class Node{
        private List<Node> child;
        private Node parent;
        private boolean locked;
        private int lockedChildNode;

        Node(){
            //Initialize child
            this.child= new ArrayList<>();
            this.parent= null;
            this.locked = false;
            this.lockedChildNode=0;
        }

        public void addChild(Node child){
            this.child.add(child);
        }

        public List<Node> getChildren(){
            return this.child;
        }

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public boolean isLocked() {
            return locked;
        }

        public void setLocked(boolean locked) {
            this.locked = locked;
        }

        public int getLockedChildNode() {
            return lockedChildNode;
        }

        public void setLockedChildNode(int lockedChildNode) {
            this.lockedChildNode = lockedChildNode;
        }
    }

    ReentrantLock mutex(Node node){
        return new ReentrantLock();
    }

    public boolean lock(Node node){
        if(node.isLocked()) return true;

        //if some child is already locked
        if(node.getLockedChildNode() > 0) return false;

        //acquire lock for current node
        mutex(node).lock();
        //traverse upwards to check if any ancestors are locked
        for(Node curr= node.getParent();curr!=null; curr= node.getParent()){
            if(curr == null) break;
            if(curr.isLocked()) return false;

            mutex(curr).lock();//take lock for ancestors
        }
        //release lock from current node
        mutex(node).unlock();

        node.setLocked(true);//lock the node

        //traverse the ancestors to update the locked child counter
        for(Node curr= node.getParent();curr!=null; curr= node.getParent()){
            if(curr == null) break;
            int val= curr.getLockedChildNode();
            curr.setLockedChildNode(val+1);

            mutex(curr).unlock();//release lock for ancestors
        }

        return true;
    }

    public boolean unlock(Node node){
        if(!node.isLocked()) return true;

        node.setLocked(false);//unlock the node
        //traverse the ancestors to update the locked child counter
        for(Node curr= node.getParent();curr!=null; curr= node.getParent()){
            if(curr == null) break;
            int val= curr.getLockedChildNode();
            curr.setLockedChildNode(val-1);
        }

        return true;
    }
}


