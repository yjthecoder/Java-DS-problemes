package jiuzhang.java.elementary;

public class MaximumSwap {
    public int maximumSwap(int num) {
	    //return the original number if no swap needed
	    int result = num;
	    
        //convert num to an array
        int digitCount = 1;
        int divider = 1;
        while (num / (divider*10) != 0) {
            divider *= 10;
            digitCount++;
        }
        
        int[] numArray = new int[digitCount];
        for (int i = 0; i < digitCount; i++) {
            numArray[i] = num / divider;
            if (divider == 1) {
            	break;
            }
            num %= divider;
            divider /= 10;
        }
        
        for (int i = 0; i < digitCount-1; i++) {
            //find the maximum and its index
            int maxIndex = i;
            int max = numArray[i];
            for (int j = i; j < digitCount; j++) {
                if (numArray[j] >= max) {
                    maxIndex = j;
                    max = numArray[j];
                }
            }
            //now maxIndex points to RIGHT most max element
            
            //swap the max to the left as much as possible, with a digit smaller than it
            
            int destIndex = maxIndex;
            for (int k = maxIndex; k >= 0; k--) {
                if (numArray[k] < max) {
                    destIndex = k;
                }
            }
            
            if (destIndex != maxIndex) {
                //do the swap
                int temp = 0;
                temp = numArray[destIndex];
                numArray[destIndex] = max;
                numArray[maxIndex] = temp;
                
                //re-populate the result
                result = 0;
                for (int m = 0; m < numArray.length; m++) {
                    result += numArray[digitCount - 1 - m] * divider;
                    divider *= 10;
                }
                
                break; 
            }            
        }       
        
        return result;               
    }
	public static void main(String[] args) {
		System.out.println(new MaximumSwap().maximumSwap(9932));

	}

}
