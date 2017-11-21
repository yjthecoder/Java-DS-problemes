package jiuzhang.java.elementary;
//nsert Node in a Binary Search Tre
public class InsertNodeInBST {
    private TreeNode oldRoot;
    private int depth = 1;
    public TreeNode insertNode1(TreeNode root, TreeNode node) {
        // write your code here
        if (node == null) {
            return root;
        }
        
        if (root == null) {
            return node;
        }
        
        if (depth == 1) {
            oldRoot = root;    
        }
        
        
        if (root.left == null) {
            if (node.val < root.val) {
                root.left = node;
                return oldRoot; 
            }
            
        }
        
        if (root.right == null) {
            if (node.val > root.val) {
                root.right = node;
                return oldRoot; 
            }
        }
        
        if (node.val < root.val) {
            depth++;
            return insertNode1(root.left, node);    
        } else {
            depth++;
            return insertNode1(root.right, node);
        }
        
    }
    
    public TreeNode insertNode2(TreeNode root, TreeNode node) {
        // the sequence you write code shows how you think
        if (node == null) {
            return root;
        }
        
        if (root == null) {
            return node;
        }
        
        //the recomposition of recursion
        // add the node at the root's appropriate subtree(either left or right) and return the original root
        if (node.val < root.val) {
            root.left = insertNode2(root.left, node);   // things on left of the = is added after the last line in the                                           // method
        } else {
            root.right = insertNode2(root.right, node); // what passed in, what returns
        }
        
        return root; // after insertion, return the original root
                     // this can be viewed as the top level method call, its easier to see
        
    }
    
    public TreeNode insertNode3(TreeNode root, TreeNode node) {
        if (node == null) {
            return root;
        }
        
        if (root == null) {
            return node;
        }
        
        TreeNode temp = root;
        TreeNode tempParent = root;
        boolean onLeft = true;
        
        while (temp!= null) {
            if (node.val < root.val) {
                onLeft = true;
                tempParent = temp;
                temp = temp.left;
            } else {
                onLeft = false;
                tempParent = temp;
                temp = temp.right;
            }
        }
        
        if (onLeft) {
            tempParent.left = node;
        } else {
            tempParent.right = node;
        }
        
        return root;
    }
    
    
}
