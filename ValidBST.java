package jiuzhang.java.elementary;
//Validate Binary Search Tree

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

class ReturnType {
    public long max;
    public long min;
    public boolean isBST;
    public ReturnType(long _max, long _min, boolean _isBST){
        max = _max;
        min = _min;
        isBST = _isBST;
    }
}

public class ValidBST {
    /*
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        ReturnType result = helper(root);
        
        return result.isBST;
    }
    
    public ReturnType helper(TreeNode root) {
        
        if (root == null) {
            return new ReturnType(
                Long.MIN_VALUE,
                Long.MAX_VALUE,
                true
                );
        }
        
        ReturnType leftReturn = helper(root.left);
        ReturnType rightReturn  = helper(root.right);
        
        if (leftReturn.isBST && rightReturn.isBST) {
            return new ReturnType(
                Math.max(root.val, Math.max(leftReturn.max, rightReturn.max)),
                Math.min(root.val, Math.min(leftReturn.min, rightReturn.min)),
                root.val > leftReturn.max && root.val < rightReturn.min
                );
        } else {
            return new ReturnType(-1, -1, false);
        }
    }
    
}