package org.siit.week7;

import org.siit.week5.person.Person;
import org.siit.week5.person.Student;
import org.siit.week5.person.comparator.PersonComparatorByName;
import org.siit.week5.person.comparator.PersonComparatorByNickname;
import org.siit.week7.exception.ValidationException;

import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args) {
//        treeSetPersonExample();
//
//        try {
//            System.out.println("Begin try");
//            validatePositiveInteger(12);
//            validatePositiveInteger(-1);
//            System.out.println("End try");
//        }
//        catch (ValidationException e)
//        {
//            e.printStackTrace();
//            System.out.println("Validation exception occurred: " + e.getMessage());
//        }
//        catch (Exception e)
//        {
//            System.out.println("This exception occurred: " + e.getMessage());
//        }
//        finally {
//            System.out.println("This is our finally block");
//        }
//        validatePositiveInteger(-1);
//        System.out.println("Main end.");

//        int x = 12;
//        int y = 0;
//        System.out.println(x/y);

//        try {
//
//        } finally {
//
//        }
//        readAndWriteWithFinally();
//        readAndWriteWithTryWithResources();

        Logger logger = Logger.getLogger(Main.class.getName());
        validate(logger);
    }

    private static void treeSetPersonExample() {

//        Set<Person> treeSet = new TreeSet<>(new PersonComparatorByNameAndNickname());
        PersonComparatorByName personComparatorByName = new PersonComparatorByName();
        PersonComparatorByNickname personComparatorByNickname = new PersonComparatorByNickname();

        Set<Person> treeSet = new TreeSet<>(personComparatorByNickname
                .thenComparing(personComparatorByName)
                .reversed());

        treeSet.add(new Student("Horia", "C"));
        treeSet.add(new Student("Horia", "Z"));
        treeSet.add(new Student("Horia", "A"));
        treeSet.add(new Student("Horia", "B"));
        treeSet.add(new Student("Ana", "C"));
        for (Person person : treeSet) {
            System.out.println(person.getName() + " " + person.getNickName());
        }
    }

    private static void validatePositiveInteger(int x) throws ValidationException {
        if (x < 0) {
//            throw new IllegalArgumentException("Parameter should be positive. Received parameter is: " + x);
            throw new ValidationException("Parameter should be positive. Received parameter is: " + x);
        }

    }

    private static void readAndWriteWithFinally() {
        Scanner scanner = null;
        PrintWriter printer = null;

        try {
            scanner = new Scanner(System.in);
            printer = new PrintWriter(System.out);

            String string = scanner.next();
            int intValue = Integer.parseInt(string);
            printer.println(intValue);
            printer.flush();
        } finally {
            if (scanner != null) {
                System.out.println("Closing scanner");
                scanner.close();
            }
            if (printer != null) {
                System.out.println("Closing printer");
                printer.close();
            }
        }
    }

    private static void readAndWriteWithTryWithResources() {
        try (Scanner scanner = new Scanner(System.in);
             PrintWriter printer = new PrintWriter(System.out)) {

            String string = scanner.next();
            int intValue = Integer.parseInt(string);
            printer.println(intValue);
            printer.flush();
        }
    }

    private static void validate(Logger logger)
    {
        logger.log(Level.FINE, "Just a fine level");
        try {
            logger.log(Level.INFO, "Try start");
            validatePositiveInteger(-1);
            logger.log(Level.INFO, "Try end");
        }
        catch (ValidationException e)
        {
            logger.log(Level.SEVERE, "Exception occurred: " + e.getMessage());
        }
    }
}