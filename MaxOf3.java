package jiuzhang.java.elementary;
// 283
public class MaxOf3 {
    
    // 最简洁的方法， 分步法， 找三个最小值无非就是找两次两个的最小值
    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        // write your code here
        int max12 = num1 > num2 ? num1 : num2;
        int max123 = max12 > num3 ? max12 : num3;
        return max123;
    }
    // 最好想的方法，如果a不是最大，b不是最大，那么c必然是最大   ，补集思想减少依次判断 
//    public int maxOfThreeNumbers(int a, int b, int c) {
//        if (a >= b && a >= c) {
//            return a;
//        } else if (b >= a && b >= c) {
//            return b;
//        } else {
//            return c;
//        }
//    }
    
    
    // The worst approach, most subject to mistake
//    public int maxOfThreeNumbers(int num1, int num2, int num3) {
//        // write your code here
//        int max = num1;
//        if (num2 > max) {
//            if (num3 > num2) {
//                max =  num3;
//            } else {
//                return max;
//            }
//        } else if (num3 > max) {
//            max = num3;
//        } else {
//            return max;
//        }
//        return max;
//    }
    
}
