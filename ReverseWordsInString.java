package jiuzhang.java.elementary;

public class ReverseWordsInString {
    public String reverseWords(String s) {
        //corner cases
        if (s == null || s.length() == 0) {
            return "";
        }
        //Not sure if I can use this method..
        String[] array = s.split(" ");
        //Note that: str.split() returns a "" as first element if str starts with the delimiter
        StringBuilder result = new StringBuilder();

        //scan from right and populate result
        for (int i = array.length - 1; i >= 0; --i) {
            if (!array[i].equals("")) {
                result.append(array[i]).append(" ");
            }
        }
        //remove the last space
        return result.length() == 0 ? "" : result.substring(0, result.length() - 1);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
