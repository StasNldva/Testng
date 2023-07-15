package com.neledva;

import org.assertj.core.data.Offset;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    private final static double EPS = 1e-6;
    private final double start = 0.1;
    private final double end = 1.0;
    private final double delta = 0.001;
    Main main;
    @BeforeMethod
    public void setUp() {
        main = new Main();
    }

    @Test(dataProvider = "dataForSolveEquation", dataProviderClass = StaticDataProvider.class)
    public void testSolveEquation(double x, double expected){
        double actual = main.solveEquation(x);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForSteps", dataProviderClass = StaticDataProvider.class)
    public void testFindCountOfSteps(double xMin, double xMax, double deltaX, int expected){
        int actual = main.findCountOfSteps(xMin, xMax, deltaX);
        assertThat(actual).isEqualTo(expected);
    }

    @Test(dataProvider = "dataForFillArrX", dataProviderClass = StaticDataProvider.class)
    public void testFillArrX(int index, double expected){
        double[] x = main.fillArrX(start, end, delta);
        assertThat(x[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForFillArrY", dataProviderClass = StaticDataProvider.class)
    public void testFillArrY(int index, double expected){
        double[] x = main.fillArrX(start, end, delta);
        double[] y = main.fillArrY(x);
        assertThat(y[index]).isCloseTo(expected, Offset.offset(EPS));
    }
}