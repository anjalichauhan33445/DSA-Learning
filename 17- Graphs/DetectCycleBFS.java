import java.util.*;

class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class DetectCycleBFS {

    boolean detect(int i, int[] visited, ArrayList<ArrayList<Integer>> adj){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, -1));
        visited[i] = 1;

        while(!q.isEmpty()){
            int node = q.peek().first;
            int parent = q.peek().second;
            q.remove();

            for(Integer it: adj.get(node)){
                if(visited[it] != 1){
                    visited[it] = 1;
                    q.add(new Pair(it, node));
                }
                else if(parent != it){
                    return true;
                }
            }
        }

        return false;
    }

    public boolean isCycle(int V, int[][] edges){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i = 0; i < V; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int[] visited = new int[V];

        for(int i = 0; i < V; i++){
            if(visited[i] != 1){
                if(detect(i, visited, adj)){
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args){
        DetectCycleBFS obj = new DetectCycleBFS();

        int V = 4;

        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0},
            {2, 3}
        };

        if(obj.isCycle(V, edges)){
            System.out.println("Cycle detected");
        }
        else{
            System.out.println("No cycle detected");
        }
    }
}