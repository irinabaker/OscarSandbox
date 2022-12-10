package com.telran.oscarlatestVersion.tests;

import com.telran.oscar.data.UserData;
import com.telran.oscar.data.WarningData;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginOrRegisterPage;
import com.telran.oscar.utils.DataProviders;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginOrRegisterPageNegativeTests extends BaseTest {

    @BeforeMethod
    public void insurePrecondition() {
        new HomePage(driver).clickOnLoginOrRegisterLink();
    }

    @Test
    public void loginNegativeWithInvalidPasswordTest() {
        new LoginOrRegisterPage(driver).loginWithInvalidPassword(UserData.USER_EMAIL, UserData.USER_INVALID_PASSWORD);
        Assert.assertTrue(new LoginOrRegisterPage(driver).getWarningResult().contains(WarningData.WARNING_MESSAGE));
    }

    @Test
    public void registrationNegativeExistingUserTest() {
        new LoginOrRegisterPage(driver).register(UserData.USER_EMAIL, UserData.USER_PASSWORD, UserData.USER_REG_CONFIRM_PASSWORD);
        Assert.assertTrue((new LoginOrRegisterPage(driver).getWarningText().contains(WarningData.WARNING_EMAIL_MESSAGE)));

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negPasswordRegister")
    public void registerWithInvalidPasswordNegativeDataProviderTest(String email, String password, String confirmPassword) {
        new LoginOrRegisterPage(driver)
                .register(email, password, confirmPassword);
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "negEmailRegister")
    public void registerWithInvalidEmailNegativeDataProviderTest(String email, String password, String confirmPassword) {
        new LoginOrRegisterPage(driver)
                .register(email, password, confirmPassword);
    }
}