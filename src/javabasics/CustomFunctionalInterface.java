package javabasics;

import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * 
 * @author urmis The Function interface takes a single input and produces an
 *         output, whereas the BiFunction interface takes two inputs and
 *         produces an output. if we need a function that takes three inputs, we
 *         must construct our own customized function.
 */
public class CustomFunctionalInterface {
	@FunctionalInterface
	public interface TriFunction<A, B, C, O> {
		O apply(A a, B b, C c);

		default <R> TriFunction<A, B, C, O> andThen(TriFunction<A, B, C, O> after) {
			return (A a, B b, C c) -> after.apply(a, b, c);
		}

	}

	public static void main(String[] args) {
		// Provided from java.util.function
		BiFunction<Integer, Integer, Integer> addTwo = (a, b) -> a + b;

		int result = addTwo.apply(1, 2);
		System.out.println(result);

		// customized
		TriFunction<Integer, Integer, Integer, Integer> addThree = (a, b, c) -> a + b + c;
		result = addThree.apply(1, 2, 3);
		System.out.println(result);
	}
}
