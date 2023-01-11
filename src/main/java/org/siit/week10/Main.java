package org.siit.week10;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
//        iterators();

        thread();
    }

    private static void iterators()
    {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(2, 3, 5, 6, 8));
        System.out.println(numbers);
        List<Integer> toRemove = new ArrayList<>();
        for (Integer number : numbers)
        {
            if (number % 2 == 1)
            {
                toRemove.add(number);
            }
        }
        numbers.removeAll(toRemove);

        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()) {
            Integer currentNumber = iterator.next();
            if (currentNumber % 2 == 1) {
                iterator.remove();
            }
        }
        System.out.println(numbers);
    }

    @SneakyThrows
    private static void thread()
    {
//        threadExample();
//        runnableExample();
//        anonymousRunnable();

        Runnable t1 = new CountingThread(2);
        Runnable t2 = new CountingThread(3);
        Thread thread1 = new Thread(t1);
        Thread thread2 = new Thread(t2);
        thread1.start();
        thread2.start();

        thread1.join();

        System.out.println("Threads started!");

    }

    private static void anonymousRunnable()
    {
        Runnable r4 = () -> {
            for (int i= 0; i < 100; i++) {
                try
                {
                    Thread.sleep(100);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                if (i%10 == 0) {
                    System.out.println(i);
                }
            }
        };
        new Thread(r4).start();
    }

    private static void runnableExample()
    {
        Runnable r1 = new CountingThread(2);
        Runnable r2 = new CountingThread(3);
        Runnable r3 = new CountingThread(5);
        Thread t11 = new Thread(r1);
        t11.setName("Step 2");
        Thread t22 = new Thread(r2);
        t22.setName("Step 3");
        Thread t33 = new Thread(r3);
        t33.setName("Step 5");
        t11.start();
        t22.start();
        t33.start();
    }

    private static void threadExample()
    {
        Thread t1 = new ManeleThread("Fara numar!");
        Thread t2 = new ManeleThread("De la nasu mare!");
        t1.start();
        t2.start();
    }


}
