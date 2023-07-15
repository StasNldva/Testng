package com.neledva;

public class Main {

    private final static double b = 1.5;
    public double solveEquation(double x) {
        double bx = x * b;
        if (bx <= 0.45){
            return bx - Math.tan(bx);
        }else {
            return bx + Math.log10(bx);
        }
    }

    public int findCountOfSteps(double xMin, double xMax, double deltaX) {
        return (int) (Math.round((xMax-xMin)/deltaX) + 1);
    }
}