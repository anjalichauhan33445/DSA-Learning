import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

class Tuple{
    int first;
    int second;
    int third;

    Tuple(int first, int second, int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}

public class FindCheapestPrice {
    static int findCheapestPrice(int n, int[][] flights, int src, int dest, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i = 0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        int[] dist = new int[n];
        Queue<Tuple> q = new LinkedList<>();    
        for(int[] arr: flights){
            int u = arr[0];
            int v = arr[1];
            int wt = arr[2];

            adj.get(u).add(new Pair(v,wt));
        }
        Arrays.fill(dist, (int)1e9);
        dist[src] = 0;
        q.add(new Tuple(0,src,0));

        while(!q.isEmpty()){
            int stops = q.peek().first;
            int node = q.peek().second;
            int dst = q.peek().third;
            q.remove();
            if(stops>k) continue;

            for(Pair it: adj.get(node)){
                int adjNode = it.first;
                int adjWt = it.second;
                

                if(dst+adjWt<dist[adjNode] && stops<=k){
                    dist[adjNode] = dst+adjWt;
                    q.add(new Tuple(stops+1,adjNode,dist[adjNode]));
                }
            }
        }

        if(dist[dest]==(int)1e9) return -1;
        return dist[dest];
    }
    public static void main(String[] args) {
        int n = 4;
        int[][] flights = new int[][]{{0, 1, 100}, {1, 2, 100}, {2, 0, 100}, {1, 3, 600}, {2, 3, 200}};
        int src = 0;
        int dst = 3;
        int k = 1;
        System.out.println(findCheapestPrice(n, flights, src, dst, k));
    }
}
