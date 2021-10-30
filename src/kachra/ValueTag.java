package kachra;

public class ValueTag {
    private static int count=1;
    private int cnt=0;
    public ValueTag(){
        count++;
        cnt=count;
    }

    public int getCount(){
        return cnt;
    }

    @Override
    public String toString() {
        return "ValueTag{" +
                "cnt=" + cnt +
                '}';
    }
}
