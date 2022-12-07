package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BasketPage extends BasePage{
    
    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".btn-group")
    WebElement viewBasketHeader;
    public BasketPage clickOnViewBasketButton() {
        click(viewBasketHeader);
        return this;
    }
}
