import java.util.*;

class Solution {

    boolean bfs(int i, int[][] graph, int[] colour) {
        Queue<Integer> q = new LinkedList<>();
        q.add(i);
        colour[i] = 0;

        while (!q.isEmpty()) {
            int node = q.poll();

            for (int it : graph[node]) {
                if (colour[it] == -1) {
                    colour[it] = 1 - colour[node];
                    q.add(it);
                } else if (colour[it] == colour[node]) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean isBipartite(int[][] graph) {
        int[] colour = new int[graph.length];
        Arrays.fill(colour, -1);

        for (int i = 0; i < graph.length; i++) {
            if (colour[i] == -1) {
                if (bfs(i, graph, colour) == false) {
                    return false;
                }
            }
        }

        return true;
    }
}

public class IsGraphBipartite {
    public static void main(String[] args) {

        int[][] graph = {
            {1, 2, 3},
            {0, 2},
            {0, 1, 3},
            {0, 2}
        };

        Solution sol = new Solution();

        System.out.println(sol.isBipartite(graph));
    }
}