import java.util.*;

public class DetectCycleDFS {

    boolean dfs(int node, int parent, int[] visited,
                ArrayList<ArrayList<Integer>> adj) {

        visited[node] = 1;

        for (Integer it : adj.get(node)) {
            if (visited[it] == 0) {
                if (dfs(it, node, visited, adj)) {
                    return true;
                }
            }
            else if (it != parent) {
                return true;
            }
        }

        return false;
    }

    public boolean isCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] visited = new int[V];

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, -1, visited, adj)) {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        DetectCycleDFS obj = new DetectCycleDFS();
        int V = 4;

        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0},
            {2, 3}
        };

        boolean result = obj.isCycle(V, edges);

        if (result) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }
    }
}