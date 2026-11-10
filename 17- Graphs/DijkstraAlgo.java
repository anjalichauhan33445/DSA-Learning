import java.util.*;

class Pair {
    int dist;
    int node;

    Pair(int dist, int node) {
        this.dist = dist;
        this.node = node;
    }
}
public class DijkstraAlgo {
    static  ArrayList<Integer> dijkstra(ArrayList<ArrayList<ArrayList<Integer>>> adj,
                                       int src) {
        // code here
        int n = adj.size();
        int[] dist = new int[n];

        Arrays.fill(dist, (int)1e9);
        PriorityQueue<Pair> q = new PriorityQueue<Pair>((x,y)-> x.dist-y.dist);

        dist[src] = 0;
        q.add(new Pair(0,src));

        while(!q.isEmpty()){
            int distn = q.peek().dist;
            int node = q.peek().node;
            q.remove();

            for(ArrayList<Integer> it: adj.get(node)){
                int nd = it.get(0);
                int wt = it.get(1);

                if(dist[nd] > distn+wt){
                    dist[nd] = distn+wt;
                    q.add(new Pair(dist[nd],nd));
                }
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for (int x : dist) ans.add(x);

        return ans;
    }

    public static void main(String[] args) {

    int V = 5;

    ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();

    for(int i = 0; i < V; i++){
        adj.add(new ArrayList<>());
    }

    adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
    adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));

    adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));
    adj.get(1).add(new ArrayList<>(Arrays.asList(3, 7)));

    adj.get(2).add(new ArrayList<>(Arrays.asList(4, 3)));

    adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));

    int src = 0;

    ArrayList<Integer> ans = DijkstraAlgo.dijkstra(adj, src);

    System.out.println("Shortest distances from source " + src + ":");
    System.out.println(ans);
}
}
