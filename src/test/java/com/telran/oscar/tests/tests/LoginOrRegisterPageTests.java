package com.telran.oscar.tests.tests;

import com.telran.oscar.tests.pages.HomePage;
import com.telran.oscar.tests.pages.LoginOrRegisterPage;
import com.telran.oscar.tests.pages.data.ConfirmationData;
import com.telran.oscar.tests.pages.data.UserData;
import com.telran.oscar.tests.pages.data.WarningData;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginOrRegisterPageTests extends BaseTest {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).clickOnLoginOrRegisterLink();

    }

    @Test
    public void registerPositiveTest() {
        new LoginOrRegisterPage(driver).register("lu4@gmail.com", "Lu1234567!", "Lu1234567!");
        new HomePage(driver).verifyTextThanksForRegistering("Thanks for registering!");
    }

    @Test
    public void loginPositiveTest() {
        new LoginOrRegisterPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD);
        new HomePage(driver).verifyTextWelcomeBack(ConfirmationData.CONFIRMATION_OF_LOGIN);

    }

    @Test
    public void loginNegativeWithInvalidPasswordTest() {
        new LoginOrRegisterPage(driver).loginWithInvalidPassword(UserData.USER_EMAIL, UserData.USER_INVALID_PASSWORD);
        Assert.assertTrue(new LoginOrRegisterPage(driver).getWarningResult().contains(WarningData.WARNING_MESSAGE));
    }

    @AfterMethod(enabled = false)
    public void logOut() {
        new HomePage(driver).logOut();
    }
}
