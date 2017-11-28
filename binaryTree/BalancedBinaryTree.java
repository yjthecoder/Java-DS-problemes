//93. Balanced Binary Tree
package jiuzhang.java.elementary.binaryTree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }
        
        return isBalanced(root.left) && isBalanced(root.right) &&
               Math.abs(heightOf(root.left) - heightOf(root.right)) < 2;
    }
    
    public int heightOf(TreeNode root) {
        
        if (root == null) {
            return 0;
        }
        
        return Math.max(heightOf(root.left), heightOf(root.right)) + 1;
    }
}
