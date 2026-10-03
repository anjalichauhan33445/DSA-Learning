import java.util.*;

public class DFSTraversal {

    static void traverse(int node, ArrayList<ArrayList<Integer>> adj,
                         ArrayList<Integer> ans, boolean[] visited) {

        visited[node] = true;
        ans.add(node);

        for (Integer it : adj.get(node)) {
            if (!visited[it]) {
                traverse(it, adj, ans, visited);
            }
        }
    }

    public static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {

        int n = adj.size();
        ArrayList<Integer> ans = new ArrayList<>();
        boolean[] visited = new boolean[n];

        traverse(0, adj, ans, visited);

        return ans;
    }

    public static void main(String[] args) {

        int n = 5;

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(1);
        adj.get(0).add(2);

        adj.get(1).add(0);
        adj.get(1).add(3);

        adj.get(2).add(0);
        adj.get(2).add(4);

        adj.get(3).add(1);

        adj.get(4).add(2);

        ArrayList<Integer> ans = dfs(adj);

        System.out.println("DFS Traversal: " + ans);
    }
}
