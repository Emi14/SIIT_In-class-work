package org.siit.week3.shapes;

public class Square extends Shape {
    public Square() {
        super(4);
    }

    @Override
    public void draw() {
        System.out.println("Drawing square");
    }
}
