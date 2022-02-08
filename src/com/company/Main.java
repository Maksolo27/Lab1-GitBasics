package com.company;

import java.io.IOException;
import java.util.List;

import static com.company.Equation.equation;

public class Main {

    private static Mode mode;
    private static List<Double> results;

    public static void main(String[] args) throws IOException {
        if(args.length >= 1){
            mode = Mode.INTERACTIVE;
        }else {
            mode = Mode.NONINTERACTIVE;
        }
        switch (mode){
            case INTERACTIVE:
                results = Interactive.getDecision(args[0]);
                break;
            case NONINTERACTIVE:

        }
        System.out.println(results);
    }
}
