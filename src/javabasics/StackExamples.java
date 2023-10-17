package javabasics;
import java.util.*;
public class StackExamples {

	public static void main(String[] args) {
		// creating an instance of Stack class
		Stack<Integer> stk = new Stack<>();
		// checking stack is empty or not
		boolean result = stk.empty();
		System.out.println("Is the stack empty? " + result);
		
		// pushing elements into stack
		stk.push(78);
		stk.push(113);
		stk.push(90);
		stk.push(120);
		// prints elements of the stack
		System.out.println("Elements in Stack: " + stk);
		stk.forEach(v -> System.out.println(v));
		stk.pop();
		System.out.println("Top of stack : "+ stk.peek());
		result = stk.empty();
		System.out.println("Is the stack empty? " + result);
		
		stk.stream().forEach(v -> System.out.println(v));
	}

}
