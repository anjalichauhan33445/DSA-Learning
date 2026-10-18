import java.util.*;

class Solution {

    void dfs(int node, int[] visited, ArrayList<ArrayList<Integer>> adj, Stack<Integer> stk) {
        visited[node] = 1;

        for (Integer it : adj.get(node)) {
            if (visited[it] == 0) {
                dfs(it, visited, adj, stk);
            }
        }

        stk.push(node);
    }

    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        int[] visited = new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            adj.get(edges[i][0]).add(edges[i][1]);
        }

        Stack<Integer> stk = new Stack<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                dfs(i, visited, adj, stk);
            }
        }

        while (!stk.isEmpty()) {
            ans.add(stk.pop());
        }

        return ans;
    }
}

public class TopologicalSortDFS {
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