package lockingTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LockTree {
    private List<Integer> [] adj;
    private Map<Integer, State> map;
    private int[] parent;

    public LockTree(int N, int[][] adj){
        //Initialize adj. list
        this.adj= new ArrayList[N+1];
        for (int i = 0; i <= N; i++) {
            this.adj[i] = new ArrayList<Integer>();
        }

        //Initialize State Mapper
        this.map= new HashMap<>();
        for(int i=1;i<=N;i++)
            this.map.put(i,new State());

        //Initialize parent Array
        this.parent= new int[N+1];

        //creating tree
        for(int i=0;i<adj.length;i++){
            int u= adj[i][0]; int v= adj[i][1];
            this.adj[u].add(v);
            this.parent[v]=u;
        }
    }

    public boolean lock(int node){
        //check if already locked
        if(map.get(node).islocked) return true;

        //check if descendents are locked
        if(map.get(node).lockdescendent > 0) return false;

        //check if ancestors are locked
        for(int i=parent[node];i!=0;i=parent[i]){
            if(map.get(i).islocked) return false;
        }

        //lock node
        map.get(node).islocked=true;

        //propogate changes to the ancestors
        for(int i=parent[node];i!=0;i=parent[i]){
            map.get(i).lockdescendent++;
        }

        return true;
    }

    public void unlock(int node){
        if(!map.get(node).islocked) return;

        //change count of lock descendent nodes for ancestors
        for(int i=parent[node];i!=0;i=parent[i]){
            map.get(i).lockdescendent--;
        }
    }
}
