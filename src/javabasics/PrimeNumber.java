package javabasics;

import java.util.ArrayList;

//Sieve of Eratosthenes
public class PrimeNumber {

	public static void main(String[] args) {
		// find all primes upto n
		int n = 50;

		primes(n);

	}

	private static void primes(int n) {
		// Create a boolean array "prime[0..n]" and
		// initialize all entries it as true. A value in
		// prime[i] will finally be false if i is Not a
		// prime, else true.
		boolean prime[] = new boolean[n + 1];
		for (int i = 0; i <= n; i++)
			prime[i] = true;

		for (int p = 2; p * p <= n; p++) {
			// If prime[p] is not changed, then it is a
			// prime
			if (prime[p] == true) {
				// Update all multiples of p greater than or
				// equal to the square of it numbers which
				// are multiple of p and are less than p^2
				// are already been marked.
				for (int i = p * p; i <= n; i += p)
					prime[i] = false;
			}
		}

		// Print all prime numbers
		for (int i = 2; i <= n; i++) {
			if (prime[i] == true)
				System.out.print(i + " ");
		}
	}

}
