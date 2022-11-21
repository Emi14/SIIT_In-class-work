package org.SII.week5.person.comparator;

import org.SII.week5.person.Person;

import java.util.Comparator;

public class PersonComparatorByNickname implements Comparator<Person> {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.getNickName().compareTo(o2.getNickName());
    }
}
