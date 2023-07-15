package com.neledva;

import org.testng.annotations.DataProvider;

public class StaticDataProvider {

    @DataProvider(name = "dataForSolveEquation")
    public static Object[][] createDataForSolveEquation(){
        return new Object[][]{
            {0.1, -0.00113521806},
            {0.3, -0.03305506561},
            {0.5, 0.62506126339},
            {1.0, 1.67609125906}
        };
    }

    @DataProvider(name = "dataForSteps")
    public static Object[][] createDataForSteps(){
        return new Object[][]{
                {0.1, 0.1, 0.001, 1},
                {0.1, 0.3, 0.001, 201},
                {0.1, 1.0, 0.001, 901},
        };
    }
}
