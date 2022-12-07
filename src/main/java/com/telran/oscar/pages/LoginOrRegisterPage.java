package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginOrRegisterPage extends BasePage{
    
    public LoginOrRegisterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "id_registration-email")
    WebElement idRegistrationEmail;

    @FindBy(id = "id_registration-password1")
    WebElement idRegistrationPassword1;

    @FindBy(id = "id_registration-password2")
    WebElement idRegistrationPassword2;

    @FindBy(xpath = "//*[@value='Register']")
    WebElement registerButton;

    @FindBy(id = "id_login-username")
    WebElement loginUsername;

    @FindBy(id = "id_login-password")
    WebElement loginPassword;

    @FindBy(xpath = "//*[@value='Log In']")
    WebElement loginButton;

    @FindBy (xpath = "//div[@class='alert alert-danger'][2]")
    WebElement warningResult;

    public HomePage register(String emailAddress, String password, String confirmPassword) {
        type(idRegistrationEmail, emailAddress);
        type(idRegistrationPassword1, password);
        type(idRegistrationPassword2, confirmPassword);
        click(registerButton);
        return new HomePage(driver);
    }

    public HomePage login(String emailAddress, String password) {
        type(loginUsername, emailAddress);
        type(loginPassword, password);
        click(loginButton);
        return new HomePage(driver);
    }

    public LoginOrRegisterPage loginWithInvalidPassword(String emailAddress, String password) {
        type(loginUsername,emailAddress);
        type(loginPassword, password);
        click(loginButton);
        return this;
    }

    public String getWarningResult() {
        return warningResult.getText();
    }
}
