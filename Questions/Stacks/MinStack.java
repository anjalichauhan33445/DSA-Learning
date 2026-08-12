import java.util.Stack;

public class MinStack {

    long min = Integer.MIN_VALUE;
    Stack<Long> stk = new Stack<>();

    public MinStack() {
    }

    public void push(int value) {

        if (stk.isEmpty()) {
            stk.push((long) value);
            min = value;
        } 
        else {
            if (value >= min) {
                stk.push((long) value);
            } 
            else {
                stk.push(2L * value - min);
                min = value;
            }
        }
    }

    public void pop() {
        if (stk.isEmpty()) {
            return;
        }
        if (stk.peek() < min) {
            min = 2 * min - stk.peek();
        }

        stk.pop();
    }

    public int top() {

        if (stk.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        if (stk.peek() < min) {
            return (int) min;
        }

        return stk.peek().intValue();
    }

    public int getMin() {
        if (stk.isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return (int) min;
    }

    public static void main(String[] args) {

        MinStack ms = new MinStack();
        ms.push(5);
        
        System.out.println("Push 5  -> Min: " + ms.getMin());

        ms.push(3);
        System.out.println("Push 3  -> Min: " + ms.getMin());

        ms.push(7);
        System.out.println("Push 7  -> Min: " + ms.getMin());

        ms.push(2);
        System.out.println("Push 2  -> Min: " + ms.getMin());

        ms.push(1);
        System.out.println("Push 1  -> Min: " + ms.getMin());
        //pop

        System.out.println("\nTop: " + ms.top());
        ms.pop();
        System.out.println("After pop -> Top: " + ms.top());
        System.out.println("After pop -> Min: " + ms.getMin());

        ms.pop();
        System.out.println("\nAfter pop -> Top: " + ms.top());
        System.out.println("After pop -> Min: " + ms.getMin());

        ms.pop();
        System.out.println("\nAfter pop -> Top: " + ms.top());
        System.out.println("After pop -> Min: " + ms.getMin());
    }
}