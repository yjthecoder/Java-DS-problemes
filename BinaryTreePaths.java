package jiuzhang.java.elementary;
//Binary Tree Paths
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        if(root == null) {
            return new ArrayList<String>();
        }
        if (root.left == null && root.right == null) {
            
            ArrayList<String> aList = new ArrayList<String>();
            aList.add(String.valueOf(root.val));
            return aList ;
        }
        
        ArrayList<String> result = new ArrayList<String>(binaryTreePaths(root.left));
        result.addAll(binaryTreePaths(root.right));
        
        
        for (int i = 0; i < result.size(); i++) {
        	result.set(i, "" + root.val + "->" + result.get(i)); 
        }
        
        
        
        // cannot use this b/c path is a new ref to a new string(after operation), the original string is not changed
        // this is the immutable property of string in java
        // must use the object's own method to change itself
//        
//        for (String path: result) {
//        	StringBuilder sb = new StringBuilder(path);
//        	sb.insert(0, "->");
//        	sb.insert(0, root.val);
//            path = sb.toString();
//            System.out.println(path);
//        }
//        
//        System.out.println("result: " + result);
        
        return result;
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode aRoot = new TreeNode(1);
		aRoot.left = new TreeNode(2);
		aRoot.right = new TreeNode(3);
		aRoot.left.left = null;
		aRoot.left.right = new TreeNode(5);
				
		List<String> result = new BinaryTreePaths().binaryTreePaths(aRoot);
		

        
	}

}
