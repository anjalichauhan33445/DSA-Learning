import java.util.Queue;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.Collections;

public class ZigZag {

    static class TreeNode {
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

    public static java.util.List<java.util.List<Integer>> zigzagLevelOrder(TreeNode root) {

        java.util.List<java.util.List<Integer>> ans = new ArrayList<>();

        if (root == null) return ans;

        int flag = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {

            int size = q.size();
            java.util.List<Integer> row = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode temp = q.poll();
                row.add(temp.val);
                if (temp.left != null) {
                    q.add(temp.left);
                }
                if (temp.right != null) {
                    q.add(temp.right);
                }
            }
            if (flag == 1) {
                Collections.reverse(row);
                flag = 0;
            } else {
                flag = 1;
            }

            ans.add(row);
        }

        return ans;
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(9);
        root.right = new TreeNode(20);

        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        java.util.List<java.util.List<Integer>> ans = zigzagLevelOrder(root);

        System.out.println(ans);
    }
}