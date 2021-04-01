package lockingTree1;

public class State {
    public boolean islocked;
    public int lockdescendent;

    public State(){
        this.islocked=false;
        this.lockdescendent=0;
    }
}
