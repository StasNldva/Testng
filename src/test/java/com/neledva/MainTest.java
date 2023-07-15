package com.neledva;

import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.*;

public class MainTest {

    Main main;

    @BeforeMethod
    public void setUp() {
        main = new Main();
    }
}