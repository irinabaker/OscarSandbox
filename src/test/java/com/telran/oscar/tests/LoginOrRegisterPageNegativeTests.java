package com.telran.oscar.tests;

import com.telran.oscar.data.WarningData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginOrRegisterPage;
import com.telran.oscar.data.UserData;
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
