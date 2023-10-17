package javabasics.dynamic;

public class Fibonacci {

	public static void main(String[] args) {
		Long startTimeNano = System.nanoTime();
		Long endTimeNano;
		System.out.println("45th Fibonacci number : "+fibonacci(45)); //4732933200 ns
		//System.out.println("45th Fibonacci number : "+fibonacciDP(45, new int [45+1])); //4696629100 ns
		endTimeNano = System.nanoTime();
		System.out.println("Time taken (ns): "+(endTimeNano-startTimeNano));
		
	}
	
	private static int fibonacci(int n) {
		if(n == 0 | n == 1)
			return n;
		else
			return fibonacci(n-1)+fibonacci(n-2);
	}
	
	//fibonacci with dynamic programming 
	private static int fibonacciDP(int n, int[] mem) {
		if(n == 0 | n == 1)
			return n;
		
		if(mem[n] == 0) {
			mem[n] = fibonacci(n-1)+fibonacci(n-2);
		}
		
		return mem[n];
	}

}
