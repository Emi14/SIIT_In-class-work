package org.siit.week5.person;

import java.util.Objects;

public class Unemployed implements Person {
    String firstName;
    String lastName;
    String nickName;

    public Unemployed(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Unemployed(String firstName, String lastName, String nickName) {
        this(firstName, lastName);
        this.nickName = nickName;
    }

    @Override
    public String getName() {
        return firstName + " " + lastName;
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unemployed that = (Unemployed) o;
        return Objects.equals(firstName, that.firstName) && Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName);
    }

    @Override
    public String toString() {
        return "Unemployed{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
