//487. Name Deduplication
package jiuzhang.java.elementary.map;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NameDeduplication {
    public List<String> nameDeduplication(String[] names) {
        // write your code here
//        if (names == null) {
//            return null;
//        }
        //*Note:above is unnecessary, 
        //consider the edge case last(maybe), the general case with extreme boundary value some times can do the check
        //i.e. write the general case and then consider edge case of the problem, match the natural handling of 
        // the boundary value
        
        
        List<String> resultList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < names.length; i++) {
            String currentName = names[i].toLowerCase();
            if (map.containsKey(currentName)) {
                continue;
            } else {
                map.put(currentName, 1);
                resultList.add(currentName);
            }
        }
        
        return resultList;
    }
    
    public List<String> nameDeduplication1(String[] names) {
        // write your code here
//        if (names == null) {
//            return null;
//        }
        //*Note:above is unnecessary, 
        //consider the edge case last(maybe), the general case with extreme boundary value some times can do the check
        //i.e. write the general case and then consider edge case of the problem, match the natural handling of 
        // the boundary value
        
        
        List<String> resultList = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        
        for (int i = 0; i < names.length; i++) {
            String currentName = names[i].toLowerCase();
            if (!map.containsKey(currentName)) {          // .containsKey()  is same as .get(key) == null
                map.put(currentName, 1);
                resultList.add(currentName);
            }// there is an automatically continue at the end of loop body
        }
        
        
        return resultList;
    }
}
