package org.siit.week5;


import org.siit.week5.person.Hired;
import org.siit.week5.person.Person;
import org.siit.week5.person.Student;
import org.siit.week5.person.Unemployed;
import org.siit.week5.person.comparator.PersonComparatorByName;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] array = new String[10];
        String[][] matrix = new String[10][10];
        String[][][] matrix2 = new String[10][10][10];
        String[][][][] matrix4 = new String[10][10][10][10];

        List<List<String>> matrixList = new ArrayList<>();
//        String s = matrixList.get(2).get(3);

        array[2] = "ceva";
//        System.out.println(array[20]);

        Integer int1 = 128;
        Integer int2 = 128;
        System.out.println(int1 == int2);

//        personArrayExample();
        personArrayListExample();
//        personSetExample();
//        personMapExample();

        queueExample();

//        treeSetPersonExample();
    }

    private static void treeSetPersonExample() {
//        Set<Person> treeSet = new TreeSet<>();
//        treeSet.add(new Student("Horia", "H"));
//        treeSet.add(new Unemployed("Sebastian", "Polgar", "SP"));
//        treeSet.add(new Student("Luca", "L"));
//        treeSet.add(new Hired("Ion", "Popescu", "IP", 2500));
//        for (Person person : treeSet)
//        {
//            System.out.println(person.getName());
//        }

        Set<Person> treeSet = new TreeSet<>(new PersonComparatorByName());
        treeSet.add(new Student("Horia", "H"));
        treeSet.add(new Unemployed("Sebastian", "Polgar", "SP"));
        treeSet.add(new Student("Luca", "L"));
        treeSet.add(new Hired("Ion", "Popescu", "IP", 2500));
        for (Person person : treeSet) {
            System.out.println(person.getName());
        }
    }

    private static void queueExample() {
        Queue<Person> personQueue = new PriorityQueue<>(new PersonComparatorByName());
        personQueue.add(new Hired("Ion", "Popescu", "IP", 2500));
        personQueue.add(new Unemployed("Sebastian", "Polgar", "SP"));
        personQueue.add(new Student("Horia", "H"));
        personQueue.add(new Student("Luca", "L"));
        while (!personQueue.isEmpty()) {
            System.out.println(personQueue.poll());
        }
    }

    private static void personMapExample() {
        List<Person> arrayList = new ArrayList<>();
        arrayList.add(new Student("Horia", "H"));
        arrayList.add(new Hired("Ion", "Popescu", "IP", 2500));
        arrayList.add(new Unemployed("Sebastian", "Polgar", "SP"));
        arrayList.add(new Student("Luca", "L"));

        Map<String, Person> personsByNickname = new HashMap<>();
        for (Person person : arrayList) {
            personsByNickname.put(person.getNickName(), person);
        }
        System.out.println(personsByNickname.get("SP"));
    }

    private static void personSetExample() {
        Set<Person> personSet = new HashSet<>();
        personSet.add(new Student("Horia"));
        personSet.add(new Hired("Ion", "Popescu", 2500));
        personSet.add(new Unemployed("Sebastian", "Polgar"));
        personSet.add(new Student("Luca"));
        personSet.add(new Student("Luca"));
        personSet.add(new Student("Luca"));
        for (Person person : personSet) {
            System.out.println(person.getName());
        }
    }

    private static void personArrayListExample() {
//        List<Person> arrayList = new ArrayList<>();
        List<Person> arrayList = new LinkedList<>();
        arrayList.add(new Student("Horia"));
        arrayList.add(new Hired("Ion", "Popescu", 2500));
        arrayList.add(new Unemployed("Sebastian", "Polgar"));
        arrayList.add(new Student("Luca"));
        System.out.println(arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println(arrayList.get(i).getName());
        }
        System.out.println("____________________________");
        arrayList.sort(new PersonComparatorByName());
        for (Person person : arrayList) {
            System.out.println(person.getName());
        }
    }

    private static void personArrayExample() {
        Person[] people = new Person[25];
        people[0] = new Student("Horia");
        people[1] = new Hired("Ion", "Popescu", 2500);
        people[2] = new Unemployed("Sebastian", "Polgar");
        people[3] = new Student("Luca");

        for (int i = 0; i < people.length; i++) {
            Person currentPerson = people[i];
            if (currentPerson == null) {
                continue;
            }
            System.out.println(currentPerson.getName());
        }

        for (Person person : people) {
            if (person == null) {
                continue;
            }
            System.out.println(person.getName());
        }
    }
}
