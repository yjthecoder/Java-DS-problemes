package jiuzhang.java.elementary;
// Swap Two Integers in Array
public class SwapIntegers {
    public void swapIntegers(int[] A, int index1, int index2) {
        if (index1 == index2) {
            return; //*Note: 有时候从题意不容易找到corner case，直接看参数list反而好一些
        }
        // *Note: this method does not require extra space, but need two seperate memory to track change of value
        A[index1] += A[index2];
        A[index2] = A[index1] - A[index2];
        A[index1] -= A[index2];
        return;
        
//        // *Note: this way do not need corner check
//        int tmp = A[index1];
//        A[index1] = A[index2];
//        A[index2] = tmp;
    }
}
