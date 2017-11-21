package jiuzhang.java.elementary;
// Binary Tree Leaf Sum
public class BinaryLeafSum {
    
    // fist approach
    private int sum = 0;
    public int leafSum1(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            sum += root.val;
            return sum;
        }
        
        leafSum1(root.left);  //the upper level does not do anything, just let lower level accumulate and return the r
        leafSum1(root.right); //  result
        return sum;
    }
    
    // second approach，standard recursion
    public int leafSum2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return root.val;
        }
        
        return leafSum2(root.left) + leafSum2(root.right);
    }
    

}
