package com.neledva;

import org.assertj.core.data.Offset;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MainTest {

    private final static double EPS = 1e-6;
    private double[] x;
    private double[] y;
    Main main;
    @BeforeMethod
    public void setUp() {
        main = new Main();
        double start = 0.1;
        double end = 1.0;
        double delta = 0.001;
        x = main.fillArrX(start, end, delta);
        y = main.fillArrY(x);
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
        assertThat(x[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataForFillArrY", dataProviderClass = StaticDataProvider.class)
    public void testFillArrY(int index, double expected){
        assertThat(y[index]).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test
    public void testSumArr() {
        double actual = 657.0096568937329;
        double expected = main.sumArr(y);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test
    public void testAverageOfArr() {
        double actual = 0.7292005070962629;
        double expected = main.averageOfArr(y);
        assertThat(actual).isCloseTo(expected, Offset.offset(EPS));
    }

    @Test(dataProvider = "dataMinIndex", dataProviderClass = StaticDataProvider.class)
    public void testFindMinNum(int expectedIndex){
        int actualIndex = main.findIndexOfMin(y);
        assertThat(actualIndex).isEqualTo(expectedIndex);
    }

    @Test
    public void testFindMaxNum(){
        int expectedIndex = 900;
        int actualIndex = main.findIndexOfMax(y);
        assertThat(actualIndex).isEqualTo(expectedIndex);
    }
}