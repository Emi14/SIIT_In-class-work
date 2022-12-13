package org.siit.week8;

import org.siit.week8.annotations.MyCustomAnnotation;
import org.siit.week8.enums.Employee;
import org.siit.week8.enums.Gender;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {

        Employee firstEmployee = new Employee("Gigel", "Doe", Gender.MALE);
        Employee secondEmployee = new Employee("Dorel", "Doe", Gender.fromNumber(0));

        System.out.println(secondEmployee);
        findAnnotation(firstEmployee);
    }

    private static void findAnnotation(Employee employee) {
        Class<? extends Employee> employeeClass = employee.getClass();

        for (Field field : employeeClass.getDeclaredFields()) {
            System.out.println(field);

            if (field.isAnnotationPresent(MyCustomAnnotation.class)) {
                System.out.println(field.getAnnotation(MyCustomAnnotation.class).message());
            }
        }

        for (Method method : employeeClass.getDeclaredMethods()) {
            System.out.println(method.getName());

            if (method.isAnnotationPresent(MyCustomAnnotation.class)) {
                System.out.println(method.getAnnotation(MyCustomAnnotation.class).message());
            }
        }

    }
}