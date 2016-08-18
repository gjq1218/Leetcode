package DataStructure;
import java.util.Stack;

public class MinStack {
    
    Stack<Integer> stack;
    Stack<Integer> minstack;
    
    public MinStack() {
        stack = new Stack<Integer>();
        minstack = new Stack<Integer>();
    }

    public void push(int number) {
        stack.push(number);
        if(minstack.isEmpty() || number <= minstack.peek()){
            minstack.push(number);
        }

    }

    public int pop() {
        if(stack.peek() > minstack.peek()){
            return stack.pop();
        }else{
        	minstack.pop();
            return stack.pop();
           
        }
    }

    public int min() {
        return minstack.peek();
    }
    
    public static void main(String args[]){
    	MinStack test = new MinStack();
    	test.push(1);
    	System.out.println(test.pop());
    	test.push(2);
    	test.push(3);
    	System.out.println(test.min());
    	test.push(1);
    	System.out.println(test.min());
    }
}
