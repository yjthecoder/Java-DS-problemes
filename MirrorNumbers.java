//644. Mirror Numbers
package jiuzhang.java.elementary;

import java.util.HashMap;
import java.util.Map;

public class MirrorNumbers {
    public boolean isStrobogrammatic(String num) {
        // write your code here
        Map<Character, Character> mirrorDecider = new HashMap<>();
        mirrorDecider.put('1', '1');
        mirrorDecider.put('6', '9');
        mirrorDecider.put('9', '6');
        mirrorDecider.put('8', '8');
        mirrorDecider.put('0', '0');
        
        for (int i = 0; i < num.length(); i++) {
            if (i <= num.length() - 1 - i) {       //与其判断true增加逻辑分支，不如判断否来截胡
                if (mirrorDecider.containsKey(num.charAt(i))) {
                    if (mirrorDecider.get(num.charAt(i))  == num.charAt(num.length() - 1 - i)) {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    public boolean isStrobogrammatic_improved(String num) {

        Map<Character, Character> mirrorDecider = new HashMap<>();
        mirrorDecider.put('1', '1');
        mirrorDecider.put('6', '9');
        mirrorDecider.put('9', '6');
        mirrorDecider.put('8', '8');
        mirrorDecider.put('0', '0');
        
       int left = 0;
       int right = num.length() - 1;
       
       while (left <= right) { //与其用for还要考虑次数和上限，不如用while来简化思维
           if (!mirrorDecider.containsKey(num.toCharArray()[left])) { //与其判断true增加逻辑分支，不如判断否来截胡
               return false;
           }
           
           if (mirrorDecider.get(num.toCharArray()[left]) != num.toCharArray()[right]) {
               return false;
           } else {  // this else can be ommited, because otherwise the following code cannever be reached
               right--;
               left++;
           }
       }
       
       return true;
    }
    

}
