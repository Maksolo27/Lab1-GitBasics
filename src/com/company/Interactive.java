package com.company;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import static com.company.Equation.equation;

public class Interactive {

    private static boolean isCorrect = false;

    public static List<Double> getDecision() throws IOException{
        Double a, b, c = null;
        Scanner scanner = new Scanner(System.in);
        System.out.print("a = ");
        a = inputArg();
        scanner = new Scanner(System.in);
        System.out.print("b = ");
        b = inputArg();
        scanner = new Scanner(System.in);
        System.out.print("c = ");
        c = inputArg();
        System.out.printf("Equation is: (%f)x^2 + (%f) x + (%f) = 0%n", a, b, c);
        return equation(a,b,c);
    }

    private static double inputArg() throws IOException {
        double arg = 0;
        Scanner scanner = new Scanner(System.in);
        while (!isCorrect) {
            String input = scanner.nextLine();
            Double temp = parseToDouble(input);
            if(isCorrect){
                arg = temp;
                isCorrect = false;
                return arg;
            } else {
                System.out.println("Error. Expected a valid real number, got " + input + " instead");
                System.out.println("Try again please");
            }
        }
        throw new IOException("Error. Expected a valid real number");
    }

    private static double parseToDouble(String line){
        double result = 0;
        try {
            result = Double.parseDouble(line);
            isCorrect = true;
        } catch (NumberFormatException e){
            isCorrect = false;
        }
        return result;
    }
}
