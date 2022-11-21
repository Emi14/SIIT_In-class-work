package org.SII.week5.person.comparator;


import org.SII.week5.person.Person;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person person, Person otherPerson) {
        return person.getName().compareTo(otherPerson.getName());
    }
}
