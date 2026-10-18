import java.util.*;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < prerequisites.length; i++) {
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
            inDegree[prerequisites[i][0]]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!q.isEmpty()) {
            int node = q.poll();
            ans.add(node);

            for (Integer it : adj.get(node)) {
                inDegree[it]--;

                if (inDegree[it] == 0) {
                    q.add(it);
                }
            }
        }

        if (ans.size() == numCourses) {
            return ans.stream()
                      .mapToInt(Integer::intValue)
                      .toArray();
        }

        return new int[0];
    }
}

public class CourseScheduleII {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int numCourses = 4;

        int[][] prerequisites = {
            {1, 0},
            {2, 0},
            {3, 1},
            {3, 2}
        };

        int[] result = sol.findOrder(numCourses, prerequisites);

        System.out.println("Course Order: " + Arrays.toString(result));
    }
}