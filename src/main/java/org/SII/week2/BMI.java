package org.SII.week2;

import java.util.Scanner;

/**
 * Scrie un program in java, care citeste de la tastatura inaltimea si masa (popular, greutatea) unei persoane
 * si calculeaza indicele de masa corporala.
 * <p>
 * Acest indice se calculeaza impartind masa, în kilograme, la patratul inaltimii, in metri (kg/m2).
 * <p>
 * Programul afiseaza aceasta valoare pe care a calculat-o.
 * <p>
 * Note:
 * <p>
 * exercitiul este asemanator celui cu transformarea temperaturii din grade Celsius in grade Fahrenheit
 * resurse:
 * https://www.reginamaria.ro/articole-medicale/indicele-de-masa-corporala-imc-sau-bmi
 * https://www.cdt-babes.ro/articole/indicele-de-masa-corporala-imc.php
 * Afisati un mesaj in functie de rezultat:
 * <p>
 * 18,49 sau mai putin	Subponderal
 * intre 18,50 si 24,99	Greutate normala
 * intre 25,00 si 29,99	Supraponderal
 * intre 30,00 si 34,99	Obezitate (gradul I)
 * intre 35,00 si 39,99	Obezitate (gradul II)
 * 40,00 sau mai mult	Obezitate morbida
 */
public class BMI {

    public double readDouble(String message) {
        Scanner reader = new Scanner(System.in);
        System.out.print(message);
        return reader.nextDouble();
    }

    public String calculateBmi() {
        double height = readDouble("Enter height: ");
        double mass = readDouble("Enter mass: ");

        double bmi = mass / Math.pow(height, 2);

        return getBmiAsString(bmi);
    }

    public String getBmiAsString(double bmi) {
        if (bmi <= 18.49) {
            return "Subponderal";
        } else if (bmi <= 24.99) {
            return "Greutate normala";
        } else if (bmi <= 29.99) {
            return "Supraponderal";
        } else if (bmi <= 34.99) {
            return "Obezitate (gradul I)";
        } else if (bmi <= 39.99) {
            return "Obezitate (gradul II)";
        }
        return "Obezitate morbida";
    }

}
