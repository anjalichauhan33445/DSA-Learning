import java.util.*;

class Solution {

    boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] pathVis) {
        visited[node] = 1;
        pathVis[node] = 1;

        for (Integer it : adj.get(node)) {
            if (visited[it] == 0) {
                if (dfs(it, adj, visited, pathVis)) return true;
            } else if (pathVis[it] == 1) {
                return true;
            }
        }

        pathVis[node] = 0;
        return false;
    }

    public boolean isCyclic(int V, int[][] edges) {
        int[] visited = new int[V];
        int[] pathVis = new int[V];

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
        }

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited, pathVis)) return true;
            }
        }

        return false;
    }
}

public class DirectedCycleDetection {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int V = 4;
        int[][] edges = {
            {0, 1},
            {1, 2},
            {2, 0},
            {2, 3}
        };

        boolean result = sol.isCyclic(V, edges);

        if (result) {
            System.out.println("Cycle detected");
        } else {
            System.out.println("No cycle detected");
        }
    }
}