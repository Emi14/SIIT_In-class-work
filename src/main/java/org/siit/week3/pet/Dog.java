package org.siit.week3.pet;

public class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public void talk() {
        System.out.println(this.name + " says ham ham");
    }
}
