package jiuzhang.java.elementary;

import java.util.ArrayList;

public class FizzBuzz {
    public ArrayList<String> fizzBuzz(int n) {
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 1; i <= n; i++) {    //错点1：看清题目的循环范围
            if (i % 3 == 0){
                if (i % 5 == 0){
                    result.add("fizz buzz");
                } else {
                    result.add("fizz");
                }
                
            } else if (i % 5 == 0) {
                result.add("buzz");
            } else {
                result.add(Integer.toString(i));
            }
        }
        return result;
    }
}


//else if 理解成集合切块

//下面这种更明确，在一层上平铺总比创建分支的分支好，因为是对description的直接描述 
//for (int i = 1; i <= n; ++i) {
//    if (i % 3 == 0 && i % 5 == 0) {
//        results.add("fizz buzz");
//    } else if (i % 3 == 0) {
//        results.add("fizz");
//    } else if (i % 5 == 0) {
//        results.add("buzz");
//    } else  {
//        results.add(i + "");
//    }
//}