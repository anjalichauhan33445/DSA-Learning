import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaxLevelSum {

    public static int maxLevelSum(TreeNode root) {
        int maxm = Integer.MIN_VALUE;
        int level = 1;
        int ans = 1;

        Queue<TreeNode> q = new LinkedList<>();

        if (root == null) return ans;

        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            int curr_sum = 0;

            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();

                curr_sum += temp.val;

                if (temp.left != null)
                    q.add(temp.left);

                if (temp.right != null)
                    q.add(temp.right);
            }

            if (curr_sum > maxm) {
                maxm = curr_sum;
                ans = level;
            }

            level++;
        }

        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(7);
        root.right = new TreeNode(0);

        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        int result = maxLevelSum(root);

        System.out.println("Level with maximum sum: " + result);
    }
}