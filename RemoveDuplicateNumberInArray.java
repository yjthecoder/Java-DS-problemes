package jiuzhang.java.elementary;

import java.util.Arrays;
//Remove Duplicate Numbers in Array 
public class RemoveDuplicateNumberInArray {
    public int deduplication(int[] nums) {
        // write your code here
        if (nums.length == 0) {
            return 0;
        }
        
        Arrays.sort(nums); //in place sort into ascending order
        // double pointer method
        int current = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[current]) {
                nums[++current] = nums[i];
            }
        }
        
        return current + 1;
    }

}
