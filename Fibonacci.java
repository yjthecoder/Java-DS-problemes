//366. Fibonacci 
package jiuzhang.java.elementary;

public class Fibonacci {
    public int fibonacci(int n) {
        // write your code here
//        if (n == 1) {
//            return 0;
//        }
//        
//        if (n == 2) {
//            return 1;
//        }
//        
//      The above two lines are redundant  
        
        int prev = 1;
        int pprev = 0;
        
        for (int i = 0; i < n - 1; i++ ) { //*Note: this upperbound of n is set to cover the case where n=1
            int temp = prev;
            prev = pprev + prev;
            pprev = temp;
        }
        
        return pprev;
    }
}
