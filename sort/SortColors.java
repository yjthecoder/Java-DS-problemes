package jiuzhang.java.elementary.sort;

public class SortColors {
    public void sortColors(int[] colors) {
        
        int pl = 0;
        int pr = colors.length - 1;
        int i = pr;
        
        
        while (i >= pl) {    
            if (colors[i] == 0) {
                swap(colors, pl, i);
                pl++;
            } else if(colors[i] == 2) {
                swap(colors, pr, i);
                pr--;
                i--;  //the scan direction matters, right side are all evaluated, bug point!
            } else {
                i--;
            }
        }
    }
    
    public void swap(int A[], int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
    
    //1. The brutal force sort always work
    //2. note that it matters where to start the scanning, elements left/right to the current already being take care of
    //2.a because of this property, the way to deal with right side and left side usually not symmetric
    
}
