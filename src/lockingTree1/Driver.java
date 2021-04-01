package lockingTree1;

public class Driver {
    public static void main(String[] args) {
        int[][] adj= {
                {1,2},
                {1,3},
                {1,4},
                {2,5},
                {2,6},
                {3,7},
                {3,8},
                {4,9},
                {4,10}
        };

        LockTree lockTree= new LockTree(11,adj);
        System.out.println(lockTree.lock(2));
        System.out.println(lockTree.lock(4));
        System.out.println(lockTree.lock(1));

    }
}
