package jiuzhang.java.elementary;

public class Calculator {
    /*
     * @param a: An integer
     * @param operator: A character, +, -, *, /.
     * @param b: An integer
     * @return: The result
     */
    public int calculate(int a, char operator, int b) {
        // write your code here
        switch (operator) {
            case '+': return (a + b);
            case '-': return (a - b);
            case '*': return (a * b);
            case '/': return (a / b);
            default: return 0; 
        }
    }
    
    // https://www.tutorialspoint.com/java/switch_statement_in_java.htm
}

// 1. switch 后面() 内必须是integer，或者是char，byte，short（integer convertable）， string or enum
// 2. case value: 
// 3. 可以有break，跳出switch block， 没有就会执行match case 及其以下的block， 而不会比较expression的值，
// 4. value 本身必须是const 或者 literal， 而且要和 expression 的结果一个type
// 5. default 非必须， 有就必须在最后，而且不需要break， 所有上面case 没包括的，交由default block 处理