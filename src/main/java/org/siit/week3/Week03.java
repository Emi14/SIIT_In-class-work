package org.siit.week3;

import org.siit.week3.pet.Cat;
import org.siit.week3.pet.Dog;
import org.siit.week3.pet.Parrot;
import org.siit.week3.pet.Pet;
import org.siit.week3.shapes.Shape;
import org.siit.week3.shapes.Square;
import org.siit.week3.shapes.Triangle;
import org.siit.week3.vehicle.VehicleComposition;
import org.siit.week3.vehicle.engine.DieselEngine;
import org.siit.week3.vehicle.engine.Engine;
import org.siit.week3.vehicle.engine.GasEngine;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Week03 {
    public static void main(String[] args) {
        shapes();
//        cars();
//        pets();
    }

    private static void shapes() {
        Triangle tr = new Triangle();
        Triangle tr2 = new Triangle();
        Square sq = new Square();
        List<Shape> shapes = new ArrayList<>();
        shapes.add(tr);
        shapes.add(sq);
        shapes.add(tr2);

        for (Shape shape : shapes) {
            shape.draw();
        }
    }

    private static void pets() {
        Pet pet = new Pet("Max", 5);
        pet.walk();
        pet.talk();

        Pet dogPet = new Dog("Colt alb", 23);
        Pet catPet = new Cat("Colt alb", 23);

        Dog dog = new Dog("Bobita", 7);
        dog.walk();
        dog.talk();
        Parrot parrot = new Parrot("Zuzu", 33, 10);
        parrot.walk();
        parrot.talk();
    }

    private static void cars() {
        VehicleComposition car0;
        car0 = new VehicleComposition(Color.red);
//        car0.start();
        car0.faster();
        car0.faster();
        car0.slower();
        Engine engine1 = new Engine("gas", 2000, 4);
        VehicleComposition car1 = new VehicleComposition(100, Color.black, engine1);
        car1.faster();
        System.out.println(car1.getColor());
        System.out.println("test");
        Engine engine2 = new Engine("gas", 2000, 4);
        VehicleComposition car2 = new VehicleComposition(50, Color.white, engine2);
        System.out.println(car2);

        DieselEngine dieselEngine = new DieselEngine(2000, 4);
        GasEngine gasEngine = new GasEngine(900, 3);

        VehicleComposition myVehicle = new VehicleComposition(100, Color.RED, dieselEngine);
        myVehicle.setEngine(gasEngine);


        int nr = 5;
        Integer nr2 = nr;
        int nr3 = nr2;

        int number = Integer.parseInt("5");
        double dnumber = Double.parseDouble("5.0d");
        System.out.println(dnumber);

//        for (int i = 0; i<10; i++) {
//            VehicleComposition vFor = new VehicleComposition(Color.CYAN);
//            System.out.println(vFor);
//        }
        System.out.println("test");
        System.out.println(checkPrime(73));

        Scanner sc = new Scanner(System.in);
    }

    private static boolean checkPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

}
