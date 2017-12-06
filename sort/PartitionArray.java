package jiuzhang.java.elementary.sort;

public class PartitionArray {
    //method 1
    public int partitionArray1(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int left = 0, right = nums.length - 1;
        while (left < right) {

            while (left < right && nums[left] < k) {
                left++;
            }

            while (left < right && nums[right] >= k) {
                right--;
            }

            if (left < right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right--;
            }
        }
        return nums[left] < k ? left + 1: left;
    }
    
    //*Note: all element must be partitioned
    
    public int partitionArray2(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int left = 0, right = nums.length - 1;
        while (left <= right) {                         //all element must be checked

            while (left <= right && nums[left] < k) {     //must check legitimacy before using 
                                                          //legitimacy checking always goes first
                left++;
            }

            while (left <= right && nums[right] >= k) {
                right--;
            }

            if (left <= right) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                
                left++;
                right--;
            }
        }
        return left;   //at this point, left/right is pointing to the last one being partiioned
    }

}
