package jiuzhang.java.elementary;
//Binary Tree Path Sum
import java.util.ArrayList;
import java.util.List;

public class BinaryTreePathSum {

    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        
        if (root == null ) {
            return new ArrayList<>();
        }
        
        // if (target < root.val) {
        //     return new ArrayList<>();
        // }
        
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                ArrayList<Integer> aList = new ArrayList<>();
                aList.add(root.val);
                
                List<List<Integer>> halfResult = new ArrayList<>();
                halfResult.add(aList);
                return halfResult;
            } else {
                return new ArrayList<>();
            }
            
        }
        
        List<List<Integer>> result = new ArrayList<>(binaryTreePathSum(root.left, target - root.val));
        result.addAll(binaryTreePathSum(root.right, target - root.val));
        
        for (List<Integer> aList : result) {
            aList.add(0, root.val);
        }
        
        return result;
       
    }
    //    List<List<Integer>> list = new ArrayList<List<Integer>>();
//    or since Java 1.7
//
//    List<List<Integer>> list = new ArrayList<>();
    
    //what after new must be a class, cannot be an interface,
    // what inside <> must be a type or an Interface
    // you can cast a class to one of the interfaces it implements but
    // not the other way,
    
    // ArrayList<ArrayList<Integer>> cannot be converted to List<List<Integer>>
}
