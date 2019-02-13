package hackerrank.java;

import java.util.ArrayList;
import java.util.List;

public class PrimeChecker {

    public static void main(String[] args) {
        final Prime prime = new Prime();
        prime.checkPrime(1, 2, 3, 4, 5);
    }

    static class Prime {

        void checkPrime(int... numbers) {
            final List<Integer> primes = new ArrayList<>();

            for (int number : numbers) {
                if (number == 1) {
                    continue;
                }
                boolean isPrime = true;

                for (int i = 2; i <= Math.sqrt(number); i++) {
                    if (number % i == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    primes.add(number);
                }
            }
            printPrimes(primes);
        }

        private void printPrimes(final List<Integer> primes) {
            primes.forEach(prime -> System.out.print(prime + " "));
            System.out.println();
        }
    }
}
