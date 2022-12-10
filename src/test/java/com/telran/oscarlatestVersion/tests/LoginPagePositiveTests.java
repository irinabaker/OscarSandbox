package com.telran.oscarlatestVersion.tests;

import com.telran.oscar.data.ConfirmationData;
import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginOrRegisterPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPagePositiveTests extends BaseTest {

    @BeforeMethod
    public void ensurePreconditions() {
        new HomePage(driver).clickOnLoginOrRegisterLink();

    }


    @Test
    public void loginPositiveTest() {
        new LoginOrRegisterPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD);
        new HomePage(driver).verifyTextWelcomeBack(ConfirmationData.CONFIRMATION_OF_LOGIN);

    }


    @AfterMethod
    public void logOut() {
        new HomePage(driver).logOut();
    }
}
