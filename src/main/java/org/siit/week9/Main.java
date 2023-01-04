package org.siit.week9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toList;

public class Main
{
    public static void main(String[] args)
    {
        Veteran v1 = new Veteran("Vasile", 66);
        Veteran v2 = new Veteran("Ion", 99);

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

        List<Integer> names = veterans.stream()
                .filter(veteran -> veteran.getAge() < 80)
                .map(veteran -> veteran.getAge()*10)
                .sorted()
                .collect(toList());
    }
}
