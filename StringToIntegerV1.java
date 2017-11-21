package jiuzhang.java.elementary;

public class StringToIntegerV1 {
    public int stringToInteger(String str) {
        // get the distance between a integar and it char
        int interval = 0 - '0';
        int result = 0;
        
        int lowerBoundary = 0;
        if (str.charAt(0) == '-'){
            lowerBoundary = 1;
        }
        for (int i = str.length() - 1; i >= lowerBoundary; i--) {
            result += ((int) str.charAt(i) + interval) * getWeight(str.length() - 1 - i);
        }
        
        if (lowerBoundary == 0){
          return result;  
        } else {
          return -1 * result;
        }
    }
    
    public int getWeight(int n) {
        if (n == 0) {
            return 1;
        }
        
        return 10 * getWeight(n - 1);
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
