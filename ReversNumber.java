package jiuzhang.java.elementary;
// 37.
public class ReversNumber {
    public int reverseInteger(int number) {
        // write your code here
        int result = 0;
        int divider = 1;
        
        //get the initial value of integer
        while (number / (divider * 10) != 0) {
            divider *= 10;
        }
        
        int multiplier = 1;
        
        while (divider != 0) {
            result += number / divider * multiplier;
            number %= divider;
            divider /= 10;
            multiplier *= 10;
        }
        
        
        return result;
    }

    /*
     * 
     *     public int reverseInteger(int number) {
     *         return number % 10 * 100 + number / 10 % 10 * 10 + number / 100;
     *     }
     * */
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(new ReversNumber().reverseInteger(123));

    }

}
