public class DeleteBst {

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

    static class Solution {

        public TreeNode deleteNode(TreeNode root, int key) {
            if(root == null) return null;

            if(root.val == key) {
                return helper(root);
            }

            TreeNode temp = root;

            while(root != null) {
                if(root.val < key) {
                    if(root.right != null && root.right.val == key) {
                        root.right = helper(root.right);
                        break;
                    }
                    else {
                        root = root.right;
                    }
                }
                else {
                    if(root.left != null && root.left.val == key) {
                        root.left = helper(root.left);
                        break;
                    }
                    else {
                        root = root.left;
                    }
                }
            }

            return temp;
        }

        TreeNode helper(TreeNode root) {
            if(root.left == null) return root.right;

            if(root.right == null) return root.left;

            TreeNode rchild = root.right;

            TreeNode lRight = lastRight(root.left);
            lRight.right = rchild;

            return root.left;
        }

        TreeNode lastRight(TreeNode root) {
            if(root.right == null) return root;

            return lastRight(root.right);
        }
    }

    static void inorder(TreeNode root) {
        if(root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        TreeNode root = new TreeNode(8);

        root.left = new TreeNode(4);
        root.right = new TreeNode(12);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(6);

        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);

        System.out.print("Before deletion: ");
        inorder(root);

        int key = 8;

        Solution sol = new Solution();
        root = sol.deleteNode(root, key);

        System.out.print("\nAfter deleting " + key + ": ");
        inorder(root);
    }
}
