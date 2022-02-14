package com.company;



import java.io.*;
import java.util.List;

import static com.company.Equation.equation;

public class NonInteractive {


    public static List<Double> getDecision(String filePath) throws IOException {
        double a,b,c;
        String arguments = readFromInputStream(filePath);
        int indexOfFirstSpace = arguments.indexOf(" ");
        a = Double.parseDouble(arguments.substring(0, indexOfFirstSpace));
        int indexOfSecondSpace = arguments.lastIndexOf(" ");
        b = Double.parseDouble(arguments.substring(indexOfFirstSpace, indexOfSecondSpace));
        c = Double.parseDouble(arguments.substring(indexOfSecondSpace, arguments.indexOf("\n")));
        return equation(a, b, c);
    }

    private static String readFromInputStream(String filePath) throws IOException {
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
