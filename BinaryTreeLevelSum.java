package jiuzhang.java.elementary;

public class BinaryTreeLevelSum {
    public int levelSum(TreeNode root, int level) {
        // write your code here
        if (root == null || level <= 0) {
            return 0;
        }
        if (level == 1) {
            return root.val;
        }
        
        return levelSum(root.left, level - 1) + levelSum(root.right, level - 1); 
    }
}
