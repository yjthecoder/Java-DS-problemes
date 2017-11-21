package jiuzhang.java.elementary;

public class MaxDepthOfBinaryTree {
    /**
     * the tree maxleth is the maxlength of its child tree + 1
     */
    public int maxDepth(TreeNode root) {
        // write your code here
        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
