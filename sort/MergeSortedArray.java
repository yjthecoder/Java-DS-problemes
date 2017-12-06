package jiuzhang.java.elementary.sort;

public class MergeSortedArray {
    //in place , this is actually the wrong way doing it, too complicated
    public void mergeSortedArray(int[] A, int m, int[] B, int n) {
        // write your code here
        int i = 0;
        for (int j = 0; j < n; j++) {
            
            while (i < m) {
                if (B[j] < A[i]) {
                    for (int k = m - 1 + i; k > (i - 1); k-- ) {
                        A[k + 1] = A[k];
                    }
                    A[i] = B[j];
                    i++;
                    break;
                }
                i++;
            }
            
            if (i == m) {
                while (j < n) {
                    A[i++] = B[j++];
                    System.out.println(i + " " + j);
                }
            }
        }
    }
    
    //use extra memory
    public void mergeSortedArray1(int[] A, int m, int[] B, int n) {
        // write your code here
        int ia = 0;
        int ib = 0;
        int it = 0;
        int[] temp = new int[m + n];
        
        while (ia < m && ib < n) {
            if (A[ia] <= B[ib]) {
                temp[it++] = A[ia++];
            } else {
                temp[it++] = B[ib++];
            }
        }
        
        while (ia < m) {
            temp[it++] = A[ia++];
        }
        
        while (ib < n) {
            temp[it++] = B[ib++];
        }
        
        for (int i = 0; i < m + n; i++) {
            A[i] = temp[i];
        }
    }
    
    //in place , starting from the end is a lot easier
    //because always put stuff on the right, thus do not have to worry about overwrites 
    public void mergeSortedArray2(int[] A, int m, int[] B, int n) {
        int i = m-1, j = n-1, index = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (A[i] > B[j]) {
                A[index--] = A[i--];
            } else {
                A[index--] = B[j--];
            }
        }
        while (i >= 0) {
            A[index--] = A[i--];
        }
        while (j >= 0) {
            A[index--] = B[j--];
        }
    }
    
    public static void main(String[] args) {
        new MergeSortedArray().mergeSortedArray(new int[]{1,3,4,6,-1,-1}, 4, new int[]{2,5}, 2);
    }
}
