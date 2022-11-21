package org.siit.week4.shapes;

public interface Shape {
    void draw();

    //    void draw(int size);
//
//    void draw(int size, int borderThickness);
//
//    void draw(Color borderColor);
//
//    boolean draw(long shapeSize, boolean dottedBorder);
//
//    boolean draw(boolean dottedBorder, long shapeSize);
//
    default boolean hasCorners() {
        throw new UnsupportedOperationException("Not implemented");
    }
}
