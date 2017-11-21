package jiuzhang.java.elementary;

public class ValidPalindrome {

    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        boolean result = false;
        s = s.toLowerCase(); // case insensitive, so normalize like this
        int front = 0;
        int back = s.length() - 1;
        while (true) {

            // skip All non-alphanumeric characters, be careful, the unwanted char might come as
            // sequence
            while (true) {
                if (front < (s.length() - 1) && !Character.isLetterOrDigit(s.charAt(front))) {
                    front++;
                } else {
                    break;
                }
            }
            while (true) {
                if (back > 0 && !Character.isLetterOrDigit(s.charAt(back))) {
                    back--;
                } else {
                    break;
                }
            }
            
            //this if covers the case where empty string is passed,
            //or string without alphanumeric chars
            if (front >= back) {
                result = true;
                break;
            }
            
            // do check
            if (s.charAt(front) != s.charAt(back)) {
                result = false;
                break;
            }
            front++;
            back--;
        }

        return result;
    };
    
/*
 * This is the how I did it. Mind the pitfalls
 * 
 *     public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }

        boolean result = false;
        s = s.toLowerCase(); // case insensitive, so normalize like this
        int front = 0;
        int back = s.length() - 1;
        while (true) {
            //this if covers the case where empty string is passed,
            //or string without alphanumeric chars
            if (front >= back) {
                result = true;
                break;
            }
            
            // skip All non-alphanumeric characters, be careful, the unwanted char might come as
            // sequence
            if (!Character.isLetterOrDigit(s.charAt(front))) {
                front++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(back))) {
                back--;
                continue;
            }
            
            // do check
            if (s.charAt(front) != s.charAt(back)) {
                result = false;
                break;
            }
            front++;
            back--;
        }

        return result;
    }
 * 
 * 
 * */
    
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        ValidPalindrome validPalindrome = new ValidPalindrome();
        String str = "A man, a plan, a canal: Panama";
        boolean result = validPalindrome.isPalindrome(str);

        System.out.println(result);
    }

}
