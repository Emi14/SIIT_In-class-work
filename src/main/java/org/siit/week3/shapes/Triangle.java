package org.siit.week3.shapes;

public class Triangle extends Shape {
    public Triangle() {
        super(3);
    }

    @Override
    public void draw() {
        System.out.println("Drawing triangle");
    }
}
