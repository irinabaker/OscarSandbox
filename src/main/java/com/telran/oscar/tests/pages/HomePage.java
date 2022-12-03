package com.telran.oscar.tests.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "login_link")
    WebElement LoginOrRegister;


    public LoginOrRegisterPage clickOnLoginOrRegisterLink() {
        click(LoginOrRegister);
        return new LoginOrRegisterPage(driver);
    }

    @FindBy(css = ".alertinner.wicon")
    WebElement confirmationOfRegistration;

    public HomePage verifyTextThanksForRegistering(String text) {
        if (confirmationOfRegistration.getText().equalsIgnoreCase(text)) {
            System.out.println("Correct: " + confirmationOfRegistration.getText());
        } else {
            System.out.println("Incorrect: " + confirmationOfRegistration.getText());
        }
        return this;
    }

    @FindBy(id = "logout_link")
    WebElement logoutLink;

    public HomePage logOut() {
    click(logoutLink);
        return this;
    }

    @FindBy(css = ".alertinner.wicon")
    WebElement getConfirmationOfLogin;

    public HomePage verifyTextWelcomeBack(String text) {
        getConfirmationOfLogin.getText().equalsIgnoreCase(text);
        System.out.println(getConfirmationOfLogin.getText());
        return this;
    }


}
