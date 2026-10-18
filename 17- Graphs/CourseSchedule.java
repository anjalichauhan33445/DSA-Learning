import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
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

        return ct == numCourses;
    }
}

public class CourseSchedule {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int numCourses = 4;

        int[][] prerequisites = {
            {1, 0},
            {2, 1},
            {3, 2}
        };

        boolean result = sol.canFinish(numCourses, prerequisites);

        System.out.println("Can finish all courses: " + result);
    }
}