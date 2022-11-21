package org.SII.week4.shapes;

public interface CorneredShape extends Shape {
    default boolean hasCorners() {
        System.out.println("CorneredShape has corners");
        return true;
    }
}
