import java.util.*;

class Solution {

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
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

        ArrayList<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.peek();
            ans.add(node);
            q.remove();

            for (Integer it : adj.get(node)) {
                inDegree[it]--;

                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        return ans;
    }
}

public class TopologicalSortBFS {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int V = 6;

        int[][] edges = {
            {5, 0},
            {5, 2},
            {4, 0},
            {4, 1},
            {2, 3},
            {3, 1}
        };

        ArrayList<Integer> result = sol.topoSort(V, edges);

        System.out.println("Topological Sort: " + result);
    }
}
