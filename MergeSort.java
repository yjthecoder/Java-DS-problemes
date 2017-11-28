package jiuzhang.java.elementary;

public class MergeSort {

    //merge sort
    
    class ReturnType {
        int[] left;
        int[] right;
        public ReturnType(int[] left, int[] right) {
            this.left = left;
            this.right = right;
        }
    }
    
    public int[] sortIntegers(int[] A) {
        
        if (A == null || A.length == 1) {
            return A;
        }
        
        int[] A1 = slice(A).left;
        int[] A2 = slice(A).right;
        A = merge(A1, A2);
        
        return A;
    }
    
    public ReturnType slice(int[] array){
        
        if (array.length == 1) {
            
             return new ReturnType(new int[]{array[0]}, new int[0]);
        }
        
        int[] subArray = new int[array.length - 1];
        for (int i = 1; i< array.length; i++){
            subArray[i - 1] = array[i];
        }
        //*Note: follow the definition, slice(A) return two sorted arrays to merge
        //and merge(A,B) took two sorted arrays and merged into one big array
        return new ReturnType(new int[]{array[0]}, merge(slice(subArray).left, slice(subArray).right));
    }
    
    public int[] merge(int[] arrayA, int[] arrayB) {
        
        //*Note:
        int[] result = new int[arrayA.length + arrayB.length];
        
        int pa = 0;
        int pb = 0;
        int pr = 0;
        while (pa < arrayA.length && pb < arrayB.length) {
            if (arrayA[pa] <= arrayB[pb]) {
                result[pr++] = arrayA[pa++];
            } else {
                result[pr++] = arrayB[pb++];
            }
        }
        
        if (pa == arrayA.length) {
            while (pb < arrayB.length) {
                result[pr++] = arrayB[pb++];
            }
        } else {
            while (pa < arrayA.length) {
                result[pr++] = arrayA[pa++];
            }
        }
        
        return result;
    }
    
    
    //better one
    ///////
    ///////
    ///////
    ///////
    
    //*Note: return value can be flexible, it can be an object so as to containing more than one value
    //       return void, but you can still put changes in the argument it was passed in.
    public void sortIntegers2(int[] A) {
        // use a shared temp array, the extra memory is O(n) at least
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);
    }
    
    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;
        }
        
        int mid = (start + end) / 2; //if odd get exact mid, if even get left side right most index

        mergeSort(A, start, mid, temp);
        mergeSort(A, mid+1, end, temp);
        merge(A, start, mid, end, temp);
    }
    
    private void merge(int[] A, int start, int mid, int end, int[] temp) {
        int left = start;
        int right = mid+1;
        int index = start;
        
        // merge two sorted sub arrays in A to temp array
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
            }
        }
        
        //*Note: no logic needed here, b/c eventually you need to exhaust two array entirely
        while (left <= mid) {
            temp[index++] = A[left++];
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }
        
        // copy temp back to A
        for (index = start; index <= end; index++) {
            A[index] = temp[index];
        }
    }
    
    
    
    
    
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[] result = new MergeSort().sortIntegers(new int[]{9,3,2,5,6});
        for (int i: result){
            System.out.print(i);    
        }
        

    }

}
