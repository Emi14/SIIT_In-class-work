package org.siit.week6;

import org.siit.week6.generics.Box;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        method1(new ArrayList<Object>()); -> Compilation error as Object doesn't extend Number
        method1(new ArrayList<Number>());
        method1(new ArrayList<Integer>());
        method1(new ArrayList<Double>());
        method1(new ArrayList<Float>());

//        method2(new ArrayList<Double>()); -> Compilation error as Double is not a super class of Integer
        method2(new ArrayList<Integer>());
        method2(new ArrayList<Number>());
        method2(new ArrayList<Object>());

        Box<Integer> anIntegerBox = new Box<Integer>(new Integer(5));
        Integer anInstance = anIntegerBox.getAnInstance();

        Box<Double> aDoubleBox = new Box<Double>(new Double(21));
    }

    public static void method1(List<? extends Number> list) {
//        Integer integer = list.get(1); -> Compilation error as list can be declared as List<Double>
//        Double double = list.get(2); -> Compilation error as list can be declared as List<Integer>
        Number number = list.get(0); // you can only read a Number instance because any list received as parameter contains a Number or a subclass of it

// As parameter list is declared to contain subclasses of Number, you cannot add anything in it
//        list.add(new Integer(1)); -> Compilation error as list can be declared as List<Double>
//        list.add(new Double(1)); -> Compilation error as list can be declared as List<Integer>
//        list.add(new Number(1)); -> Compilation error as list can be declared as List<Integer>;
//                                    N.B. Number is an abstract class so a new instance cannot be created without implement the abstract methods
    }

    public static void method2(List<? super Integer> list) {
//        Integer integer = list.get(1); -> Compilation error as list can be declared as List<Number>
//        Number number = list.get(2); -> Compilation error as list can be declared as List<Object>
        Object object = list.get(0); // you can only read an Object as all entries from list parameter are guaranteed to be an instance of Object or a subclass of it

        list.add(new Integer(12));

//        list.add(new Object()); -> Compilation error as list can be declared as List<Number>
//        list.add(new Number()); -> Compilation error as list can be declared as List<Integer>
//                                    N.B. Number is an abstract class so a new instance cannot be created without implement the abstract methods
    }
}