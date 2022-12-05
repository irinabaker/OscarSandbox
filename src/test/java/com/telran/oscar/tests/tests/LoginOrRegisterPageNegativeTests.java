package com.telran.oscar.tests.tests;

import com.telran.oscar.tests.pages.HomePage;
import com.telran.oscar.tests.pages.LoginOrRegisterPage;
import com.telran.oscar.tests.pages.data.UserData;
import com.telran.oscar.tests.pages.data.WarningData;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginOrRegisterPageNegativeTests extends BaseTest{

    @BeforeMethod
    public void insurePrecondition() {
        new HomePage(driver).clickOnLoginOrRegisterLink();
    }

    @Test
    public void loginNegativeWithInvalidPasswordTest() {
        new LoginOrRegisterPage(driver).loginWithInvalidPassword(UserData.USER_EMAIL, UserData.USER_INVALID_PASSWORD);
        Assert.assertTrue(new LoginOrRegisterPage(driver).getWarningResult().contains(WarningData.WARNING_MESSAGE));
    }
}
