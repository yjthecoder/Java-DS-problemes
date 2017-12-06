package jiuzhang.java.elementary.sort;

public class MergeSort {

    
     
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //1st Way 
    
    class ReturnType {
        int[] left;
        int[] right;
        public ReturnType(int[] left, int[] right) {
            this.left = left;
            this.right = right;
        }
    }
    
    public int[] sortIntegers0(int[] A) {
        
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
        //*Note: follow the definition, slice(A) return two SORTED arrays to merge
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
    
    
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //2nd way
    //How to view the question as a divider and conquer manner
    //mergeSort() take in an Array and do it by mergeSort() its left and right part then merge the result
    
    //*Note: return value can be flexible, it can be an object so as to containing more than one value
    //       return void, but you can still put changes in the argument it was passed in.
    
    public void sortIntegers(int[] A) {
        // use a shared temp array, the extra memory is O(n) at least
        int[] temp = new int[A.length];
        mergeSort(A, 0, A.length - 1, temp);  //because we need to read from A, so we cannot modify it before finish
                                              //use another argument, temp, to keep the changed value temporarily
                                              // and copy temp back to the corresponding part of A
    }
    
    //is is always saves more memory to pass the indices that describe an array rather than the array itself
    private void mergeSort(int[] A, int start, int end, int[] temp) {
        if (start >= end) {
            return;          //out of boundary ends the recursion
        }
        
        int mid = (start + end) / 2; //if odd get exact mid, if even get left side right most index

        mergeSort(A, start, mid, temp);
        mergeSort(A, mid+1, end, temp);
        merge(A, start, mid, end, temp);
    }
    
    
    //*Note:how to choose parameters? must be enough to describe the subarray to merge
    // in this case need 
    private void merge(int[] A, int start, int mid, int end, int[] temp) {
        int left = start;  //start index of left part
        int right = mid+1; //start index of right part
        int index = start; //start index of resulting array
        
        // merge two sorted sub arrays in A to temp array
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
            }
        }
        
        //*Note: no logic needed here, b/c eventually you need to exhaust two array entirely
        //       so there is no need to check which condition cause the break of previous loop
        while (left <= mid) {
            temp[index++] = A[left++];
        }
        while (right <= end) {
            temp[index++] = A[right++];
        }
        
        // copy temp back to A
        for (index = start; index <= end; index++) {  // *Note: the index start from start, its copying partial to A
            A[index] = temp[index];
        }
    }
    
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //3rd Way, withouth passing temp, but create one every time calling merge()
    //this cause MLE (memory limit exceeded), because it create so many arrays as the recursion gets deeper
    
    
    public void sortIntegers1(int[] A) {
        // use a shared temp array, the extra memory is O(n) at least
        mergeSort(A, 0, A.length - 1);
    }
    
    private void mergeSort(int[] A, int start, int end) {
        if (start >= end) {
            return;
        }
        
        int left = start, right = end;
        int mid = (start + end) / 2;

        mergeSort(A, start, mid);
        mergeSort(A, mid+1, end);
        merge(A, start, mid, end);
    }
    
    private void merge(int[] A, int start, int mid, int end) {
        int left = start;
        int right = mid+1;
        int index = start;
        
        int[] temp = new int[A.length];
        
        // merge two sorted subarrays in A to temp array
        while (left <= mid && right <= end) {
            if (A[left] < A[right]) {
                temp[index++] = A[left++];
            } else {
                temp[index++] = A[right++];
            }
        }
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
    
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //////////////////////
    //4th way, if there is no requirement for space used, this is easier to understand
    public Integer[] sort(Integer[] targetArray){

        if(targetArray.length == 1){
            return targetArray;
        }
        
        int leftSize = targetArray.length/2;
        int rightSize = targetArray.length - (int) targetArray.length/2;

        Integer[] left= new Integer[leftSize];
        Integer[] right= new Integer[rightSize];

        for(int i=0; i<targetArray.length;i++){
            if(i<leftSize){
                left[i] = targetArray[i];
            }else{
                right[i-leftSize] = targetArray[i];
            }
        }
        
        return merge(sort(left), sort(right));  
    }
    
    
    public Integer[] merge (Integer[] left,Integer[] right){

        Integer[] mergedArray = new Integer[left.length+right.length];

        int lIndex=0, rIndex=0, mIndext=0;      
        while(true){

            if(left[lIndex]<right[rIndex]){
                mergedArray[mIndext] = left[lIndex];
                mIndext++;
                lIndex++;
            }else{
                mergedArray[mIndext] = right[rIndex];
                mIndext++;
                rIndex++;
            }

            //if left runs out first, append all remaining elements in the right
            if(lIndex == left.length){
                for(int i=rIndex; i<right.length;i++){
                    mergedArray[mIndext] = right[i];    //bug fixed here
                    mIndext++;
                }
                return mergedArray;
            }

            if(rIndex == right.length){
                for(int i=lIndex; i<left.length;i++){
                    mergedArray[mIndext] = left[i];     //bug fixed here!!
                    mIndext++;
                }
                return mergedArray;
            }
        }

    }
        
 
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        int[] result = new MergeSort().sortIntegers0(new int[]{9,3,2,5,6});
        for (int i: result){
            System.out.print(i);    
        }
        

    }

}
