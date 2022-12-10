package com.telran.oscarlatestVersion.tests;

import com.telran.oscar.pages.HomePage;
import org.testng.annotations.Test;

public class HomePageTests extends BaseTest {

    @Test
    public void openHomePageTest() {
        new HomePage(driver).takeScreenshotWithScrollDown();
    }
}
