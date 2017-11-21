package jiuzhang.java.elementary;
//Invert Binary Tree
public class InvertBinaryTree {
    public void invertBinaryTree(TreeNode root) {
        // write your code here
        if (root == null) {  // notice the grammar small part
            return;
        }
        
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }

}
