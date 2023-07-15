package com.neledva;

import java.util.Arrays;
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

    double sumArr(double[] y) {
        /*double sum = 0;
        for (double v : y) {
            sum += v;
        }
        return sum;*/
        return Arrays.stream(y).sum();
    }

    double averageOfArr(double[] y) {
        return Arrays.stream(y).average().orElse(0);
        //return sumArr(y)/ y.length;
    }

    public int findIndexOfMax(double[] arr) {
        double max = arr[0];
        int maxIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }
        return maxIndex;
    }

    public int findIndexOfMin(double[] arr) {
        double min = arr[0];
        int minIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
                minIndex = i;
            }
        }
        return minIndex;
    }

    public void showMinIndex(double[] x, double[] y, int index) {
        System.out.println("x[" + index + "] " + x[index] + "y[" + index + "]" + y[index]);
    }

    public void showMaxIndex(double[] x, double[] y, int index) {
        System.out.println("x[" + index + "] " + x[index] + "y[" + index + "]" + y[index]);
    }
}