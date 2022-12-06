package org.siit.week7.comparator;


import org.siit.week5.person.Person;

import java.util.Comparator;

public class PersonComparatorByNameAndNickname implements Comparator<Person> {
    @Override
    public int compare(Person person, Person otherPerson) {
        int result = person.getName().compareTo(otherPerson.getName());
        if(result != 0 ){
            return result;
        }
        return person.getNickName().compareTo(otherPerson.getNickName());
    }
}
