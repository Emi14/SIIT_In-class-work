package org.siit.week5.person;

import java.util.Objects;

public class Hired extends Unemployed {
    int salary;

    public Hired(String firstName, String lastName, int salary) {
        super(firstName, lastName);
        this.salary = salary;
    }

    public Hired(String firstName, String lastName, String nickName, int salary) {
        super(firstName, lastName, nickName);
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Hired hired = (Hired) o;
        return salary == hired.salary;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary);
    }
}
