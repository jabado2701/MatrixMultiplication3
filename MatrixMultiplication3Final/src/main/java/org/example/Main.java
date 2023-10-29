package org.example;


import Testers.FormatTester;
import Testers.MultiplicationTester;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();

        //FormatTester tester = new FormatTester();
        //tester.formatTest();

        MultiplicationTester tester2 = new MultiplicationTester();
        tester2.multiplicationTest();

        long endTime = System.currentTimeMillis();
        long executionTime = endTime - startTime;

        System.out.println("El tiempo de ejecución del main es: " + executionTime + " milisegundos");

    }
}