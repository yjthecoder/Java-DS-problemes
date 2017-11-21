package jiuzhang.java.elementary;
//479.

public class SecondMax {
    // Best practice
    // 注意理解本质， 打擂台法不经可以只找一个最值，可以拿出一个值打两个擂台啊
    // 拿出一个值打一个max擂台，
    // 这里的invariable 就是每次循环结束的时候 max 和 secondMax 总是在当前扫过的元素里的正确值
    public int secondMax(int[] nums) {
        int max = Math.max(nums[0], nums[1]);
        int secondMax = Math.min(nums[0], nums[1]);
        
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > max) {
                secondMax = max;
                max = nums[i];
            } else if (nums[i] > secondMax) {
                secondMax = nums[i];
            }
        }
        
        return secondMax;
    }
    
//    public int secondMax(int[] nums) {
//        int max = Math.max(nums[0], nums[1]);
//        int secondMax = Math.min(nums[0], nums[1]);
//        
//        for (int i = 2; i < nums.length; i++) {
//            if (nums[i] > max) {
//                secondMax = max;
//                // Note this, each step must be thought through
//                // take a number from rest of array and then put it in the right place
//                max = nums[i];
//                continue;       // This is redundant, continue skip rest of block, no point for end of line
//            }
//            if (nums[i] > secondMax) {
//                secondMax = nums[i];
//                continue;
//            }
//        }
//        
//        return secondMax;
//    }

// NOT a good approach, since two many edge cases
// Fist find the max, second exclude the max and find the max in the remaining
//public class SecondMax {
//    public int secondMax(int[] nums) {
//        // write your code here
//        int max = Integer.MIN_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > max) {
//                max = nums[i];
//            }
//        }
//        
//        //3rd try
//        int maxCount = 0;
//        for (int val : nums) {
//            if (val == max) {
//                maxCount++;
//                if (maxCount > 1) {
//                    return max;
//                }
//            }
//        }
//        
//        
//        int secondMax = Integer.MIN_VALUE;
//        for (int i = 0; i< nums.length; i++) {
//            if ((nums[i] != max) && (nums[i] > secondMax) ) {
//                secondMax = nums[i];
//            }
//        }
//        
//        // fist try not right, b/c did not consider if all element are same value
//        
//        return secondMax != Integer.MIN_VALUE ? secondMax : max;
//        
//        // second try wrong, 1,1,2,2    2 is second max, we DO NOT want second max value,
//        // but second max element's value (second max number)
//        
//    }
        

}
