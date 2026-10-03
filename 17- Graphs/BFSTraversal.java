import java.util.*;

public class BFSTraversal {

    public static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        int n = adj.size();
        boolean[] visited = new boolean[n];
        ArrayList<Integer> ans = new ArrayList<>();

        Queue<Integer> q = new LinkedList<>();
        q.add(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            Integer node = q.poll();

            ans.add(node);

            for (Integer it : adj.get(node)) {
                if (visited[it] != true) {
                    visited[it] = true;
                    q.add(it);
                }
            }
        }

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

        ArrayList<Integer> ans = bfs(adj);

        System.out.println("BFS Traversal: " + ans);
    }
}