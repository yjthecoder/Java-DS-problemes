//56. Two Sum
package jiuzhang.java.elementary.map;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    //Brutal Force
    public int[] twoSum1(int[] numbers, int target) {
        //Brutal Force
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        
        int[] result = new int[2];
        
        for (int i = 0; i < numbers.length - 1; i++) {
            for ( int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i + 1;
                    result[1] = j + 1;
                    return result;
                }
            }
        }
        
        return result;
    }
    
    //use map   //*Note: if result f(a) exists in the array later, than a must exist before
    public int[] twoSum2(int[] numbers, int target) {
        // write your code here
        if (numbers == null || numbers.length < 2) {
            return null;
        }
        
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                result[0] = map.get(numbers[i]) + 1;
                result[1] = i + 1;
            }
            //Map<Integer, Integer> map = new HashMap<>();
            map.put(target - numbers[i], i);
        }
        
        return result;
    }
    
    
    //use another way to initialize an array
    public int[] twoSum3(int[] numbers, int target) {
        // write your code here
//        if (numbers == null || numbers.length < 2) {
//            return null;
//        }
        //above unnecessary, use the loop entry condition to do the edge check 
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(numbers[i])) {
                int[] result = {map.get(numbers[i]) + 1, i + 1};
                return result;
            }
            //Map<Integer, Integer> map = new HashMap<>();
            map.put(target - numbers[i], i);
        }
        
        int[] result = {};
        return result;
    }
    
}


