package jiuzhang.java.elementary.sort;

public class QuickSort {
    
    public void sortIntegers2(int[] A) {                                //method name in template cannot be changed
                                                                        // the main depending on it
        // write your code here
        partition(A, 0, A.length - 1);
    }
    
    public void partition(int[] A, int start, int end) {                //DO NOT FORGET type declaration in argument list
        
        if (start >= end) {
            return;
        }
        
        int left = start;
        int right = end;
        int pivot = A[start + (int) (Math.random() * (end - start + 1))]; //pivot is the VALUE not index
                                                                          //b/c of swap, same index end up with different value
        
        while (left <= right) {
            while (left <= right && A[left] < pivot) {
                left++;
            }
            while (left <= right && A[right] > pivot) {
                right--;
            }
            
            //swap
            if (left <= right) {
                int temp = A[left];                                       //declare the temp, DO NOT FORGET type declaration
                A[left] = A[right];
                A[right] = temp;
                left++;
                right--;
            }
        }
        
        partition(A, start, right);
        partition(A, left, end);
    }
}
