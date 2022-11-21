package org.siit.week2;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Week02 week02 = new Week02();

        System.out.println("Sum is: " + week02.calculateSum(10));
        System.out.println("Factorial is: " + week02.factorial(5));
        System.out.println("Max digit is: " + week02.calculateMaxDigit(542780));
        System.out.println("The n-th element of Fibonacci series is: " + week02.fibonacci(5));

        Scanner reader = new Scanner(System.in);

        System.out.println("Enter a number: ");
        int number = reader.nextInt();

        System.out.println("Max digit is: " + week02.calculateMaxDigit(number));

        BMI bmi = new BMI();

        String result = bmi.calculateBmi();
        System.out.println(result);

        ImageProcessor imageProcessor = new ImageProcessor();
        imageProcessor.execute();
        imageProcessor.executeWithLibrary();
    }
}