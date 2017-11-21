package jiuzhang.java.elementary;

public class PalindromeNumber {
    public boolean isPalindrome(int num) {
        // write your code here
        if (num < 0) {
            num *= -1;
        }
        
        String str = Integer.toString(num);
        
        int front = 0;
        int back = str.length()- 1;
            
        while (front < back) {
            if (str.charAt(front) == str.charAt(back)) {
                front++;
                back--;
            } else {
                return false;
            }
        }
        
        return true;
    }
}
