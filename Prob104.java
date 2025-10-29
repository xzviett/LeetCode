public class Prob104 {
    
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }


    public static int maxDepth(TreeNode root) {
        return getHeight(root, 0);
    }

    private static int getHeight(TreeNode root, int height) {
        if (root == null) return 0;

        if (root.left == null && root.right == null) {
            return height;
        }

        if (root.left != null) {
            return getHeight(root.left, height + 1);
        }
        return getHeight(root.right, height + 1);
    }
}
