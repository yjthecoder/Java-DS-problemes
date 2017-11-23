//463. Sort Integers
package jiuzhang.java.elementary;

public class SortIntegers {

    //bubble sort : bubble up the largest element to the right
    public void sortIntegers1(int[] A) {
        // write your code here
        for (int i = A.length - 1; i > 0 ; i--) {
            for (int j = 0; j < i; j++) {
                if (A[j] > A[j + 1]) {
                    int temp = A[j];
                    A[j] = A[j + 1];
                    A[j + 1] = temp;
                }
            }
        }
    }
     //selection sort : select the minimum element in the inner loop and put it
    //                  to the right
    public void sortIntegers2(int[] A) {
        // write your code here
        for (int i = 0; i < A.length - 1; i++) {
            
            int j = i;
            while (j < A.length) {
                if (A[j] < A[i]) {
                   int temp = A[j];
                   A[j] = A[i];
                   A[i] = temp;
                }
                j++;
            }
        }
    }

     //insertion sort: insert each in the unsorted part in the sorted part
    public void sortIntegers3(int[] A) {
        // write your code here
        for (int i = 1; i < A.length; i++) {
            
            int currentElement = A[i];
            int j = i;
            while (j > 0 && A[j - 1] > currentElement) {
                A[j] = A[j-1];
                j--;
            }
            A[j] = currentElement;
        }
    }
    
}
