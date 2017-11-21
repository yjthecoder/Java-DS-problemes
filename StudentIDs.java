package jiuzhang.java.elementary;

//455
class Student {
    public int id;
    
    public Student(int id) {
        this.id = id;
    }
}

public class StudentIDs {
    /**
     * Declare a public attribute `students` which is an array of `Student`
     * instances
     */
    // write your code here.
    public Student[] students; // students is null
    /**
     * Declare a constructor with a parameter n which is the total number of
     * students in the *class*. The constructor should create n Student
     * instances and initialized with student id from 0 ~ n-1
     */
    // write your code here
    public StudentIDs(int n) {
        
        //constructor's job is to initialize uninitilized fields of the class
        students  = new Student[n]; //every Student obj is null, but students is NOT null it is object of nulls
                                    //but an object contain n null objects
        for (int i = 0; i < n; i++) {
            students[i] = new Student(i); //Note: there is no . on the null obj, so not exception thrown
        }
    }
}
