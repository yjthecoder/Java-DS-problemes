package jiuzhang.java.elementary;

//Identical Binary Tree
public class IdenticalBinaryTree {
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // write your code here
        if (a == null) {
            return b == null;
        }
        
        if (b == null) {
            return a == null;
        }
        
        //write the regular cases first and consider the exit of recursion both logically
        // and gramatically  , then write them
        return a.val == b.val && isIdentical(a.left, b.left) 
                        &&  isIdentical(a.right, b.right);
    }
}
