package org.siit.week5.person;

import java.util.Objects;

public class Student implements Person {
    String name;
    String nickName;

    public Student(String name) {
        this.name = name;
    }

    public Student(String name, String nickName) {
        this.name = name;
        this.nickName = nickName;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getNickName() {
        return nickName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
