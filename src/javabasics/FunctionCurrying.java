package javabasics;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionCurrying {

	public static void main(String[] args) {
		//using java.util.function.BiFunction
		BiFunction<String, String, String> concatWithBiFunction = (a,b) -> a+b;
		
		//Currying is converting a function with multiple arguments into multiple functions with a single argument.
		Function<String, Function<String, String>> concatCurried = a -> b -> a + b;

		System.out.println("concatWithBiFunction: " + concatWithBiFunction.apply("A", "B"));
		System.out.println("concatCurried: " + concatCurried.apply("A").apply("B"));
	}
}
