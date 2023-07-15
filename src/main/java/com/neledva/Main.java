package com.neledva;

import java.util.stream.DoubleStream;

public class Main {

    private final static double b = 1.5;
    private final static double EPS = 1e-6;

    public double solveEquation(double x) {
        double bx = x * b;
        if (bx <= 0.45 + EPS) {
            return bx - Math.tan(bx);
        } else {
            return bx + Math.log10(bx);
        }
    }

    public int findCountOfSteps(double xMin, double xMax, double deltaX) {
        return (int) (Math.round((xMax - xMin) / deltaX) + 1);
    }

    public double[] fillArrX(double start, double end, double delta) {
        double[] x = new double[findCountOfSteps(start, end, delta)];
        for (int i = 0; i < x.length; i++) {
            x[i] = start + delta * i;
        }
        return x;
    }

    public double[] fillArrY(double[] x) {
        return DoubleStream.of(x).map(this::solveEquation).toArray();
    }
}