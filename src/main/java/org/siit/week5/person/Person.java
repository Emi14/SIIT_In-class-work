package org.siit.week5.person;

public interface Person //extends Comparable<Person>
{
    String getName();

    String getNickName();

//    @Override
//    default int compareTo(Person otherPerson)
//    {
//        return this.getName().compareTo(otherPerson.getName());
//    }
}
