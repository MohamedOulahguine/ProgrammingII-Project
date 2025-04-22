package com.mycompany.linearequation;
import java.util.Scanner;

public class testCode {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter values for a, b, c, d, e, f:");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double d = input.nextDouble();
        double e = input.nextDouble();
        double f = input.nextDouble();

        LinearEquation equation = new LinearEquation(a, b, c, d, e, f);

        if (equation.isSolvable()) {
            System.out.println("x = " + equation.getX());
            System.out.println("y = " + equation.getY());
        } else {
            System.out.println("The equation has no solution.");
        }

        input.close();
    }
}

