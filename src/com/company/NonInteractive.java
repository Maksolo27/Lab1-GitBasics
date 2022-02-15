package com.company;

import java.io.*;
import java.util.List;
import java.util.concurrent.Callable;


public class NonInteractive implements Callable {

    private final String filePath;
    private static NonInteractive instance;
    private final Equation equation = Equation.getInstance();

    public static synchronized NonInteractive getInstance(String filePath) {
        if (instance == null) {
            instance = new NonInteractive(filePath);
        }
        return instance;
    }

    private NonInteractive(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public Object call() throws Exception {
        return getDecision();
    }

    private List<Double> getDecision() throws IOException {
        double a, b, c;
        String arguments = readFromInputStream(filePath);
        int indexOfFirstSpace = arguments.indexOf(" ");
        a = Double.parseDouble(arguments.substring(0, indexOfFirstSpace));
        int indexOfSecondSpace = arguments.lastIndexOf(" ");
        b = Double.parseDouble(arguments.substring(indexOfFirstSpace, indexOfSecondSpace));
        c = Double.parseDouble(arguments.substring(indexOfSecondSpace, arguments.indexOf("\n")));
        synchronized (equation) {
            return equation.equation(a, b, c);
        }
    }

    private String readFromInputStream(String filePath) throws IOException {
        File file = new File(filePath);
        InputStream inputStream = new FileInputStream(file);
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }


}
