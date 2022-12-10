package com.telran.oscar.pages;

import com.telran.oscar.data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends BasePage{

    public ProfilePage(WebDriver driver) {
        super(driver);
    }
    @FindBy(css = ".nav-link.mt-2.mt-lg-0")
    WebElement accountLink;

    @FindBy(id = "delete_profile")
    WebElement deleteProfile;

    @FindBy(id = "id_password")
    WebElement passwordField;

    @FindBy(css = ".btn-danger")
    WebElement deleteButton;

    public ProfilePage deleteRegisterUser() {
        new ProfilePage(driver).clickOnAccountLink()
                .clickOnDeleteProfileButton()
                .fillInPasswordField()
                .clickOnDeleteButton();
        return this;
    }

    private HomePage clickOnDeleteButton() {
        click(deleteButton);
        return new HomePage(driver);
    }

    public ProfilePage fillInPasswordField() {
        type(passwordField, UserData.USER_REG_PASSWORD);
        return this;
    }



    public ProfilePage clickOnDeleteProfileButton() {
        click(deleteProfile);
        return this;
    }

    public ProfilePage clickOnAccountLink() {
        click(accountLink);
        return this;
    }

}



//Assert
//Your profile has now been deleted. Thanks for using the site.
//.alertinner.wicon