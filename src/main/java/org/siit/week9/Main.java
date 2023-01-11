package org.siit.week9;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.math3.primes.Primes;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Comparator.comparingInt;

public class Main
{
    public static void main(String[] args)
    {
//        lambdaExpressions();
        streams();
    }

    private static void streams()
    {
        Optional<Veteran> v0 = getVeteran(45);


        Veteran v1 = new Veteran("Vasile", 66, 10);
        Veteran v2 = new Veteran("Ion", 99, 24);
        Veteran v3 = new Veteran.VeteranBuilder()
                .age(25)
                .name("Dorel")
                .build();
        List<Veteran> veterans = Arrays.asList(v1, v2, v3);

        if (v0.isPresent())
        {
            veterans.add(v0.get());
        } else {

        }

        List<Integer> names = veterans.stream()
                .filter(veteran -> veteran.getAge() < 80)
                .map(veteran -> veteran.getAge())
                .sorted()
                .collect(Collectors.toList());

        List<String> words = Arrays.asList("doc", "bob", "cal", "sas");
//        words.stream()
//                .filter(new Predicate<String>()
//                {
//                    @Override
//                    public boolean test(String s)
//                    {
//                        return isPalindrome(s);
//                    }
//                })
//                .forEach(new Consumer<String>()
//                {
//                    @Override
//                    public void accept(String s)
//                    {
//                        System.out.println(s + " is a palindrome");
//                    }
//                });
        words.stream()
            .filter(Main::isPalindromeCommons)
            .forEach(s -> System.out.println(s + " is a palindrome"));

        //numerele prime impare
//        IntStream.range(0, 101)
//                .filter(value -> isNumberPrime(value) && value%2 == 1)
//                .forEach(value -> System.out.println(value + " is prime"));

        List<Mercenary> mercs = veterans.stream()
                .filter(veteran -> veteran.getAge() < 90)
                .map(veteran -> new Mercenary(veteran.getName(), veteran.getAge(), veteran.getExperience() * 100))
                .sorted(Comparator.comparing(Mercenary::getName))
                .collect(Collectors.toList());
        System.out.println(mercs);

        Optional<Mercenary> merc = veterans.stream()
                .filter(veteran -> veteran.getAge() < 90)
                .sorted(Comparator.comparing(Veteran::getName))
                .map(veteran -> new Mercenary(veteran.getName(), veteran.getAge(), veteran.getExperience() * 100))
                .findAny();
        merc.ifPresent(mercenary -> System.out.println(mercenary.getName()));


        long count = veterans.stream()
                .filter(veteran -> veteran.getAge() < 90)
                .sorted(Comparator.comparing(Veteran::getName))
                .map(veteran -> new Mercenary(veteran.getName(), veteran.getAge(), veteran.getExperience() * 100))
                .count();

        Optional<Mercenary> max = veterans.stream()
                .filter(veteran -> veteran.getAge() < 90)
                .map(veteran -> new Mercenary(veteran.getName(), veteran.getAge(), veteran.getExperience() * 100))
                .max(comparingInt(Mercenary::getSalary));

        boolean anyMatch = veterans.stream()
                .filter(veteran -> veteran.getAge() < 90)
                .sorted(Comparator.comparing(Veteran::getName))
                .map(veteran -> new Mercenary(veteran.getName(), veteran.getAge(), veteran.getExperience() * 100))
                .anyMatch(mercenary -> mercenary.getName().startsWith("D"));

        Integer ageSum = veterans.stream()
                .distinct()
                .filter(veteran -> veteran.getAge() < 90)
                .map(Veteran::getAge)
                .reduce(0, (previousSum, age) -> previousSum + age);
        System.out.println(ageSum);

        Match m1 = new Match(v1, v2);
        Match m2 = new Match(v1, v3);
        Match m3 = new Match(v3, v2);
        List<Match> matches = Arrays.asList(m1, m2, m3);

        List<Veteran> collect = matches.stream()
                .flatMap(match -> match.getParticipants().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    private static boolean isNumberPrime(int value)
    {
        return Primes.isPrime(value);
    }

    private static boolean isPalindrome(String s)
    {
        for (int i = 0; i< s.length()/2; i++) {
            if (s.charAt(i) != s.charAt(s.length()-i-1)) {
                return false;
            }
        }
        return true;
    }

    private static boolean isPalindromeCommons(String s)
    {
        return StringUtils.reverse(s).equals(s);
    }

    private static void lambdaExpressions()
    {
        MyFunctionalInterface myFunctionalInterface = name -> "Hello " + name;

        System.out.println(myFunctionalInterface.sayHello("Andrei"));

        Veteran v1 = new Veteran("Vasile", 66, 10);
        Veteran v2 = new Veteran("Ion", 99, 24);

        Veteran v3 = new Veteran.VeteranBuilder()
                .age(25)
                .name("Dorel")
                .build();

        List<Veteran> veterans = Arrays.asList(v1, v2);

        veterans.sort((o1, o2) -> o1.getName().compareTo(o2.getName()));

        System.out.println(veterans);

        veterans.sort(comparingInt(Veteran::getAge));

        veterans.sort(comparingInt(Veteran::getAge).reversed()
                .thenComparing(Veteran::getName));

        System.out.println(veterans);

        for (Veteran v : veterans) {
            System.out.println(v.getName());
        }

        veterans.forEach(new Consumer<Veteran>()
        {
            @Override
            public void accept(Veteran veteran)
            {
                System.out.println("Veteran's age is " + veteran.getAge());
            }
        }.andThen(new Consumer<Veteran>()
        {
            @Override
            public void accept(Veteran veteran)
            {
                System.out.println("Veteran's name: " + veteran.getName());
            }
        }));

        veterans.forEach(((Consumer<Veteran>) veteran -> System.out.println("Veteran's age is " + veteran.getAge()))
                .andThen(veteran -> System.out.println("Veteran's name: " + veteran.getName())));

        veterans.forEach((vet -> System.out.println(vet)));

        veterans.forEach(vet -> System.out.println(vet));

        veterans.forEach(System.out::println);

        List<Veteran> clonedVeterans = new ArrayList<>();

        veterans.forEach(Veteran::new);
    }

    public static Optional<Veteran> getVeteran(int id) {
        System.out.println("Searching DB");

        return Optional.empty();
    }
}
