package jiuzhang.java.elementary.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//156. Merge Intervals
public class MergeIntervals {
    
    class Interval {
             int start, end;
             Interval(int start, int end) {
                 this.start = start;
                 this.end = end;
             }
    /////
    /////
    /////
    /////fist try
    
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        Collections.sort(intervals, (Interval i1, Interval i2)->i1.start - i2.start); //create an comparator on the fly
        
        List<Interval> result = new ArrayList<>();                                    //right hand must be Class
        
        for (int i = 0; i < intervals.size() - 1; i++) {         //must draw a diagram to analyze complex loop problem        }
                                                                //key words: synch, move, restart
            Interval first = intervals.get(i);
            int steps = 0;
            for (int j = i + 1; j < intervals.size(); j++) {
                Interval current = intervals.get(j);
                if (current.start <= intervals.get(i).end) {
                    intervals.get(i).end = Math.max(current.end, intervals.get(i).end);
                    steps++;
                } else {
                    i = j;
                    result.add(current);
                }
            }
            i += steps;
            result.add(0, first);       // add fist in the beginning
        }
        return result;
    }
    
    
    
    /////
    /////
    /////
    /////
    /////second try, getting better, 
    //Do you have to use 2 nest loops? If you can change the start point in the loop, the you can use only
    //one loop
    
    //
    public List<Interval> merge2(List<Interval> intervals) {
        // write your code here
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }
        
        Collections.sort(intervals, (Interval i1, Interval i2)->i1.start - i2.start); //note the lamda
        
        List<Interval> result = new ArrayList<>();
        Interval current = intervals.get(0);    //sorted array has its own characteristics: vision a increasing bar diagram
        result.add(current);                    // can help you get it
        for (int i = 1; i < intervals.size(); i++) {
            if ( intervals.get(i).start <= current.end) {
                current.end = Math.max(current.end, intervals.get(i).end);
            } else {
                result.add(intervals.get(i));
                current = intervals.get(i);    //dynamiclly change the compare standard 
            }
        }
        return result;
    }
    
    //Note that although I put object from this container to another container and another,
    //but they all the same object, if I modify in one container, when accessing using other container also can
    //see the change, because what in container are all refrences (visual it like octopus)
    
    //Sorted stuff usually easier to manipulate, always keep in mind, it is already in order
    
    }  
}
