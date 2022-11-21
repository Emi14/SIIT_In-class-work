package org.siit.week3.pet;

public class Parrot extends Pet {
    int wingSpan;

    public Parrot(String name, int age, int wingSpan) {
        super(name, age);
        this.legs = 2;
        this.wingSpan = wingSpan;
    }

    @Override
    public void talk() {
        System.out.println(this.name + " says cra cra");
    }
}
