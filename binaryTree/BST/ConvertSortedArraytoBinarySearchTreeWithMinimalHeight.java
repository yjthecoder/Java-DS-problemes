//177. Convert Sorted Array to Binary Search Tree With Minimal Height
package jiuzhang.java.elementary.binaryTree.BST;

import jiuzhang.java.elementary.binaryTree.TreeNode;

public class ConvertSortedArraytoBinarySearchTreeWithMinimalHeight {
    
    
    //wrong way (start)    
    public TreeNode sortedArrayToBST0(int[] A) {
        if (A == null || A.length < 1) {
            return null;
        }
        TreeNode root = new TreeNode(-1);
        
        helper(root, A, 0, A.length - 1);
        
        return root;
    }
    
    public void helper0(TreeNode root, int[] A,int ls, int rs) {  //here a new root ref is created, you
                                                                // cannot change the old object unless you call obj's method
        
        if (ls > rs) {
            return;
        }
        
        int mid = (ls + rs) / 2;
        
        root = new TreeNode(A[mid]);   // root here is different with root at line 14
        helper0(root.left, A, ls, mid - 1);
        helper0(root.right, A, mid + 1, rs);
    }
    
    //wrong way ends

    //to pass array between methods, it is always easier to always pass the original array and the indices keep changing.
    //make the array stay the same, but reflect the change in the indeices
    
    
    //right way
    public TreeNode sortedArrayToBST2(int[] A) {
        if (A == null || A.length < 1) {
            return null;
        }
        
        TreeNode root = new TreeNode(-1);
        root = helper2(root, A, 0, A.length - 1);
        
        //*Note: must be clear the def of recursion method, return the root of a BST with the middle element in A
        // being the root node. (Taking in the array, with original A and start end indeices inicating the interval)
        
        return root;
    }
    
    public TreeNode helper2(TreeNode root, int[] A,int ls, int rs) {
        
        if (ls > rs) {
            return null;
        }
        
        int mid = (ls + rs) / 2;
        
        root = new TreeNode(A[mid]);
        root.left = helper2(root.left, A, ls, mid - 1);
        root.right = helper2(root.right, A, mid + 1, rs);
        
        return root;
    }
    
    //Even better way, the key is to know exactly what you function does
    //In this case, the helper take in the original array and the indices that determine the subarray, and return the
    // root node of the BST for this sub array
    
    //*Note: why helper function, because to fully describe a sub array, it is not enough to using a single array
    // **the scale change at each level of recursion is reflected on the change in the arguments passed in each time
    // **we need enough arguments to describe that change
    
    public TreeNode sortedArrayToBST(int[] A) {
        if (A == null || A.length < 1) {
            return null;
        }
        
        TreeNode root = helper(A, 0, A.length - 1);
        
        return root;
    }
    
    public TreeNode helper(int[] A,int ls, int rs) {
        
        if (ls > rs) {
            return null;
        }
        
        int mid = (ls + rs) / 2;
        
        TreeNode root = new TreeNode(A[mid]);
        root.left = helper(A, ls, mid - 1);
        root.right = helper(A, mid + 1, rs);
        
        return root;
    }
    
}
