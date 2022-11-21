package org.siit.week3.pet;

public class Pet {
    String name;
    int legs = 4;
    int age;

    public Pet(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void talk() {
        System.out.println(this.name + " says blah blah");
    }

    public void walk() {
        System.out.println(this.name + " is taking a walk");
    }
}
