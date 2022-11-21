package org.siit.week3.pet;

public class Cat extends Pet {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public void talk() {
        System.out.println(this.name + " says meow meow");
    }
}
