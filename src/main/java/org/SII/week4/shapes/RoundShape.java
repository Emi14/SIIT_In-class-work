package org.SII.week4.shapes;

public interface RoundShape extends Shape {
    default boolean hasCorners() {
        return false;
    }
}
