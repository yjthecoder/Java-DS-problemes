//557. Count Characters

package jiuzhang.java.elementary;

import java.util.HashMap;
import java.util.Map;

public class CountCharacters {

    public Map<Character, Integer> countCharacters1(String str) {
        // write your code here
        if (str.equals(null)) {
            return null;
        }
        
        //*Note: there is NO empty char, only empty String
        
        Map<Character, Integer> resultMap = new HashMap<Character, Integer>();
        
        char currentChar = 'x';
        
        
        for (int i = 0; i < str.length(); i++) {
            
            if(i == 0) {
                currentChar = str.charAt(0);
            }
            if (currentChar != str.charAt(i)) {
                currentChar = str.charAt(i);    
            } else {
                continue;
            }
            
            int count = 0;
            
            for (char c : str.toCharArray() ) {
                if (c == currentChar) {
                    count++;
                }
            }
            
            resultMap.put(currentChar, count);
        }
        
        return resultMap;
    }

    //*Note: the key point is that put(key,value), will replace the old key-value association if the key is found in existing
    //pairs
    
    public Map<Character, Integer> countCharacters2(String str) {
        // write your code here
        
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        
        for (char c: str.toCharArray()) {
            if (!result.containsKey(c)) {
                result.put(c, 1);
            } else {
                result.put(c, result.get(c) + 1);
            }
        } 
        
        return result;
    }
    
    
    public Map<Character, Integer> countCharacters3(String str) {
        // write your code here
        
        Map<Character, Integer> result = new HashMap<Character, Integer>();
        
        for (char c: str.toCharArray()) {
            if (!result.containsKey(c)) {
                result.put(c, 0);
            }
            result.put(c, result.get(c) + 1);
        } 
        
        return result;
    }
    
    
    
    
}
