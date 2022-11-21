package org.siit.week2;

/**
 * Class used to store methods containing various recursive calls
 */
public class Week02 {

    /**
     * Calculates the sum of the numbers that greater than zero that are lower than the given parameter
     *
     * @param n - Numbers should be lower than this parameter
     * @return - The sum as int
     */
    public int calculateSum(int n) {
        if (n == 0) {
            return 0;
        } else {
//            System.out.println(n);
            return n + calculateSum(n - 1);
        }
    }

    /**
     * Calculates the n!
     *
     * @param n
     * @return - The factorial value as int
     */
    public int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }

    /**
     * Calculates the maximum digit of the given number
     *
     * @param x - A number
     * @return - The maximum digit as int
     */
    public int calculateMaxDigit(int x) {
        if (x == 0) {
            return 0;
        }
        int a = x % 10;
        int b = calculateMaxDigit(x / 10);
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     * Ex. 0 1 1 2 3 5 8 13 21 ...
     * fibonacci(0) = 0
     * fibonacci(1) = 1
     * ----------------
     * fibonacci(6) = 8
     *
     * @param n - The position of the desired element
     * @return - The n-th element of the Fibonacci series
     */
    public int fibonacci(int n) {
        System.out.println(n);
        if (n == 0 || n == 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

}
