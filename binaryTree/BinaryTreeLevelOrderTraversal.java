package jiuzhang.java.elementary.binaryTree;

import java.util.ArrayList;
import java.util.List;

//leetcode 102. Binary Tree Level Order Traversal

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        //corner case
        if (root == null) {
            return result;
        }
        List<TreeNode> queue = new ArrayList<>();
        
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int levelLength = queue.size();
            for (int i = 0; i < levelLength; i++) {
                TreeNode curNode = queue.get(0);
                queue.remove(0);
                level.add(curNode.val);

                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }            
            }          
            result.add(level);
        }
        return result;
    }
}
