package com.company;

import java.util.ArrayList;
import java.util.List;

public class Equation {

    private static Equation instance;

    public static synchronized Equation getInstance() {
        if (instance == null) {
            instance = new Equation();
        }
        return instance;
    }

    private Equation() {

    }

    public List<Double> equation(double a, double b, double c) {
        List<Double> results = new ArrayList<>();
        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double x1, x2;
            x1 = (-b - Math.sqrt(discriminant)) / (2 * a);
            x2 = (-b + Math.sqrt(discriminant)) / (2 * a);
            results.add(x1);
            results.add(x2);
            return results;
        } else if (discriminant == 0) {
            double x;
            x = -b / (2 * a);
            results.add(x);
            return results;
        } else {
            return results;
        }
    }
}
