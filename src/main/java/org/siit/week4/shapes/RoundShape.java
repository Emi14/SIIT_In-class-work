package org.siit.week4.shapes;

public interface RoundShape extends Shape {
    default boolean hasCorners() {
        return false;
    }
}
