package jiuzhang.java.elementary.sort;
//143. Sort Colors II

//Given an array of n objects with k different colors (numbered from 1 to k), sort them so that objects of the same color are adjacent, with the colors in the order 1, 2, ... k.
//
//Notice
//
//You are not suppose to use the library's sort function for this problem.
//
//k <= n

public class SortColorsII {
    public void sortColors2(int[] colors, int k) {
        // write your code here
        if (colors == null || colors.length < k) {
            return;
        }
        
        
        sort(colors, 1, k, 0, colors.length - 1);
    }
    
    public void sort(int[] colors, int start, int end, int left, int right) {
        
        if (start >= end || left >= right) {
            return;
        }
        
        int pl = left;
        int pr = right;
        int i = pl;
        
        
        while (i <= pr) {    
            if (colors[i] == start) {
                swap(colors, pl, i);
                pl++;
                i++;
            } else if(colors[i] == end) {
                swap(colors, pr, i);
                pr--;
            } else {
                i++;
            }
        }
        
        sort(colors, start + 1, end - 1, pl, pr);
    }
    
    public void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

}
