package org.SII.week4.shapes;

public class Square implements CorneredShape {
    public static final int sides = 4;

    private int sideLength;

    public Square() {
    }

    public static boolean areSidesEqual() {
        return true;
    }

    @Override
    public void draw() {
        System.out.println("Drawing square");
    }

    @Override
    public boolean hasCorners() {
        return true;
    }

}
