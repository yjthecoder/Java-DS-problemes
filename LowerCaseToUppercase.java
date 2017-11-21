package jiuzhang.java.elementary;
// Lowercase to Uppercase II
public class LowerCaseToUppercase {
    public String lowercaseToUppercase2(String str) {
        // write your code here
        int distance = 'A' - 'a';
        StringBuilder chars = new StringBuilder(str);
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) {
                if ((int)str.charAt(i) >= 'a' && (int)str.charAt(i) <= 'z') {
                    chars.setCharAt(i, (char) ((int) str.charAt(i) + distance));
                }
            }
        }
        
        return chars.toString();
        
        
        //简洁方法， 用Character的static class
//        public String lowercaseToUppercase2(String str) {
//            // Write your code here
//            StringBuilder sb = new StringBuilder(str);
//            for (int index = 0; index < sb.length(); index++) {
//                char c = sb.charAt(index);
//                if (Character.isLowerCase(c)) {
//                    sb.setCharAt(index, Character.toUpperCase(c));
//                }
//            }
//            return sb.toString();
//        }
    }
    
    // *Note: Character 常用static method
    // Character.isDigit() ,  isLetter(), isLetterOrDigit(),
    //isWhitespace(), toUpperCase(), toLowerCase(), toString()--one char string
    
    
}
