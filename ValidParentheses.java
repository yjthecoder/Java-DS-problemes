package jiuzhang.java.elementary;
//Valid Parentheses
import java.util.Stack;
import java.util.HashMap;

public class ValidParentheses {
    public boolean isValidParentheses(String s){
        Stack<Character> st = new Stack<Character>();
        HashMap<Character, Character> mp = new HashMap<Character, Character>();
        mp.put(')','(');
        mp.put('}','{');
        mp.put(']','[');
        
        for (int i = 0; i < s.length(); i++) {
            if (mp.containsKey(s.charAt(i))) {
                if (st.empty()) {  //at each step must be very clear, use the animation thinking
                    return false;
                } else {
                    if (mp.get(s.charAt(i)).charValue() == st.peek().charValue()) {     // a Character C, C.charValue() return char
                        st.pop();
                    }
                    else return false;
                }
            } else {
                st.push(s.charAt(i));
            }
        }
        
        if (!st.empty()) {
            return false;
        } else {
            return true;
        }
    }
    
    // method two
    // know this new way to iterate
//    for (Character c : s.toCharArray()) {
//        
//    }
    public boolean isValidParentheses2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (Character c : s.toCharArray()) {
        if ("({[".contains(String.valueOf(c))) {    // String.valueOf(Obj) and   Character.valueOf(char) both return a
                                                    // single character string // s.contains(x) s is a string, x is a 1 char string as well 
                stack.push(c);                      // X.valueOf() always return the same type as X
            } else {
               if (!stack.isEmpty() && is_valid(stack.peek(), c)) {
                   stack.pop();
               } else {
                   return false;
               }
           }
       }
       return stack.isEmpty();
    }

    private boolean is_valid(char c1, char c2) {
        return (c1 == '(' && c2 == ')') || (c1 == '{' && c2 == '}')
            || (c1 == '[' && c2 == ']');
    }

}
