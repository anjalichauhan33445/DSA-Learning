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

public class PathSum2 {

    static void dfs(TreeNode root, int t, List<Integer> curr, List<List<Integer>> ans) {
        if (root == null)
            return;

        curr.add(root.val);
        t -= root.val;

        if (root.left == null && root.right == null) {
            if (t == 0)
                ans.add(new ArrayList<>(curr));

            curr.remove(curr.size() - 1);
            return;
        }

        dfs(root.left, t, curr, ans);
        dfs(root.right, t, curr, ans);

        curr.remove(curr.size() - 1);
    }

    public static List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        dfs(root, targetSum, new ArrayList<>(), ans);
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        System.out.println(pathSum(root, 22));
    }
}