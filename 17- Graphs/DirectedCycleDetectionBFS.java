import java.util.*;

class Solution {

    public boolean isCyclic(int V, int[][] edges) {
        int[] inDegree = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            inDegree[edges[i][1]]++;
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        int ct = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            ct++;

            for (Integer it : adj.get(node)) {
                inDegree[it]--;

                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return ct != V;
    }
}

public class DirectedCycleDetectionBFS {
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