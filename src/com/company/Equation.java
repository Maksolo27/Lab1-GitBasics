package com.company;

import java.util.ArrayList;
import java.util.List;

public class Equation {

    public static List<Double> equation(double a, double b, double c){
        List<Double> results = new ArrayList<>();
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            results.add(x1);
            results.add(x2);
            return results;
        }
        else if (discriminant == 0) {
            double x;
            x = -b / (2 * a);
            results.add(x);
            System.out.println("Уравнение имеет единственный корень: x = " + x);
            return results;
        }
        else {
            System.out.println("Уравнение не имеет действительных корней!");
            return results;
        }
    }
}
