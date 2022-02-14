package com.company;

import java.io.IOException;
import java.util.List;


public class Main {

    private static Mode mode;
    private static List<Double> results;

    public static void main(String[] args) throws IOException {
        if(args.length >= 1){
            mode = Mode.NONINTERACTIVE;
        }else {
            mode = Mode.INTERACTIVE;
        }
        switch (mode){
            case INTERACTIVE:
                results = Interactive.getDecision();
                break;
            case NONINTERACTIVE:
                results = NonInteractive.getDecision(args[0]);
                break;

        }
        System.out.println(results);
    }
}
