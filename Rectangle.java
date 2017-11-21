package jiuzhang.java.elementary;
// Rectangle Area

public class Rectangle {
    
    /*
     * Define two public attributes width and height of type int.
     */
    // write your code here
    public int width;
    public int height;  // *Note: class field do not need to be initialized outside constructor

    /*
     * Define a constructor which expects two parameters width and height here.
     */
    // write your code here
    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }
    /*
     * Define a public method `getArea` which can calculate the area of the
     * rectangle and return.
     */
    // write your code here
    public int getArea() {
        return this.width * this.height;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
    }

}
