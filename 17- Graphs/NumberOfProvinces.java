import java.util.*;

public class NumberOfProvinces {

    static void dfs(int node, ArrayList<ArrayList<Integer>> adj, boolean[] vis) {
        vis[node] = true;

        for (Integer it : adj.get(node)) {
            if (!vis[it]) {
                dfs(it, adj, vis);
            }
        }
    }

    public static int findCircleNum(int[][] isConnected) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < isConnected.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {

                if (isConnected[i][j] == 1 && i != j) {
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }

        boolean[] vis = new boolean[adj.size()];
        int ct = 0;

        for (int i = 0; i < isConnected.length; i++) {

            if (!vis[i]) {
                ct++;
                dfs(i, adj, vis);
            }
        }

        return ct;
    }

    public static void main(String[] args) {

        int[][] isConnected = {
            {1, 1, 0},
            {1, 1, 0},
            {0, 0, 1}
        };

        int ans = findCircleNum(isConnected);

        System.out.println("Number of Provinces: " + ans);
    }
}