package org.SII.week4;


import org.SII.week4.course.Classroom;
import org.SII.week4.course.Course;
import org.SII.week4.shapes.Circle;
import org.SII.week4.shapes.Shape;
import org.SII.week4.shapes.Square;
import org.SII.week4.shapes.Triangle;
import org.SII.week4.student.Student;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Week04 {
    public static void main(String[] args) {
//        students();
//        shapes();
        hwDemo();
    }

    private static void hwDemo() {

    }

    private static void students() {
        Classroom class01 = new Classroom();
        Course javaCourse = new Course(25);
        javaCourse.setClassroom(class01);

        Student dorel = new Student("12345");
        dorel.enrollToCourse(javaCourse);

        System.out.println("");

        List<Course> coursesList = new LinkedList<>();
        coursesList.add(javaCourse);
        Student gigi = new Student("12354", coursesList);
    }


    private static void shapes() {
        Triangle tr = new Triangle();
        Triangle tr2 = new Triangle();
        Square sq = new Square();
        Circle c = new Circle();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(tr);
        shapes.add(sq);
        shapes.add(tr2);
        shapes.add(c);

        drawShapes(shapes);

        Square square = new Square();
        System.out.println(square.hasCorners());

        Square square2 = new Square();
        System.out.println(square2.hasCorners());

        Shape specialShape = new Shape() {
            @Override
            public void draw() {
                System.out.println("Drawing my special shape");
            }
        };
        specialShape.draw();

        System.out.println(Square.sides);
        System.out.println(Square.areSidesEqual());
        System.out.println(StringUtils.reverse("Andrei"));
    }

    private static void drawShapes(List<Shape> shapes) {
        for (Shape shape : shapes) {
            shape.draw();
        }
    }


}
