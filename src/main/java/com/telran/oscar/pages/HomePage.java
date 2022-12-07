package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Collection;

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

    @FindBy(xpath = "//a[@href='/en-gb/catalogue/']")
    WebElement allProducts;
    public AllProductsPage clickOnAllProductsLink() {
        click(allProducts);
        return new AllProductsPage(driver);
    }


    @FindBy(xpath = "//*[@href='/en-gb/']")
    WebElement logo;

    public HomePage clickOnLogo() {
        click(logo);
        return this;
    }


    @FindBy(xpath = "//*[.='Welcome!']")
    WebElement oscarLogo;

    public String getConfirmHomePageText() {
        return oscarLogo.getText();

    }
}

//*[.='Welcome!']
// @FindBy(xpath = "//div[@class='sub-header']/h2[@xpath='1']")