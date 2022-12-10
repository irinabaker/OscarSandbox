package com.telran.oscar.tests;

import com.telran.oscar.data.ConfirmationData;
import com.telran.oscar.data.UserData;
import com.telran.oscar.pages.BasketPage;
import com.telran.oscar.pages.CheckoutPage;
import com.telran.oscar.pages.HomePage;
import com.telran.oscar.pages.LoginOrRegisterPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddBookTest extends BaseTest{

    @BeforeMethod
    public void ensurePrecondition() {
        new HomePage(driver).clickOnLoginOrRegisterLink();
        new LoginOrRegisterPage(driver).login(UserData.USER_EMAIL, UserData.USER_PASSWORD);
    }

    @Test
    public void addBookTest() {
        new HomePage(driver).clickOnAllProductsLink().clickOnAddToBasketButton();
        new BasketPage(driver).clickOnViewBasketButton();
        new CheckoutPage(driver).clickOnProceedToCheckout().enterRequiredAddressFields(UserData.FIRST_NAME, UserData.SECOND_NAME,
                UserData.ADDRESS, UserData.CITY, UserData.POST_CODE)
                .clickOnContinueButton()
                .clickOnPlaceOrderButton();
        new HomePage(driver).clickOnLogo();
        Assert.assertTrue(new HomePage(driver).getConfirmHomePageText().contains(ConfirmationData.CONFIRMATION_OF_HOMEPAGE));

    }

}