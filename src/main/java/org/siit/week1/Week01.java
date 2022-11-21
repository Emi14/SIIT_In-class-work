package org.siit.week1;

public class Week01 {

    public void ex1() {
        int int1 = 5;
        int int2 = 75;
        double d1 = 6.5;

        System.out.println(int1 + d1);

        char c1 = 'Z';
        String name = "Vadim";

        int int3 = int2 + c1;
        int int4 = int2 + int1;
        System.out.println("My name is " + name + " and my age is " + int2);
        System.out.println(int3);

        double d2 = 7.1;
        int int6 = 7;
        int int5 = 3;
        System.out.println(int6 / int5);
        System.out.println(int6 % int5);
        System.out.println(d2 / int5);
        System.out.println(d2 % int5);

        long l1 = 5;
        //misc code
        l1 = l1 + 3;
        l1 += 2;
        l1++;

        System.out.println(l1);
        System.out.println(l1++);
        System.out.println(++l1);
    }

    public void isNumberEven(int number) {
        System.out.println(">>> Is number even <<<");
        boolean isEven = number % 2 == 0;

        if (isEven) {
            System.out.println(number + " is even");
        } else {
            System.out.println(number + " is odd");
        }
    }

    public void ex3() {
        System.out.println(">>> EX 3 <<<");
        int number = 1;
        while (number <= 10) {
            System.out.println(number);
            number++;
        }
    }

    public void ex4() {
        System.out.println(">>> EX 4 <<<");
        int number = 1;
        do {
            System.out.println(number);
            number++;
        } while (number < 11);
    }

    public void ex5() {
        System.out.println(">>> EX 5 <<<");

        for (int i = 1; i < 11; i++) {
            System.out.println(i);
        }

        int sum = 0;
        for (int i = 1; ; i++) {
            sum += i;
            if (sum > 100) {
                System.out.println(sum);
                break;
            }
        }

        int[] numbers = {2, 3, 5, 8};
        int evenSum = 0;
        // suma numerelor pare din array
        for (int i = 0; i < numbers.length; i++) {
            int currentNumber = numbers[i];
            if (currentNumber % 2 == 1) {
                continue;
            }
            evenSum += currentNumber;
        }
        System.out.println("Sum is " + evenSum);

        //primul numar impar din lista
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 == 1) {
                System.out.println(numbers[i]);
                break;
            }
        }

//        for (int number : numbers)
//        {
//            System.out.println(number);
//        }
    }
}
