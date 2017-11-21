package jiuzhang.java.elementary;

public class StringToIntegerV2 {
    public int stringToInteger(String str) {
        //get the sign of the integer
        int sign = 1;
        int startIndex = 0;
        if (str.charAt(0) == '-') {
            sign  = -1;
            startIndex = 1;
        }
        
        int result = 0;
        int interval = 0 - '0'; //note the interval should always be dest - start
        int weight = 1; //note the mapping between weight and index
        
        for (int i = str.length() - 1; i >= startIndex; i--) {
            result += (str.charAt(i) + interval) * weight;
            weight *= 10;
        }
        
        return sign * result;
    }
}
