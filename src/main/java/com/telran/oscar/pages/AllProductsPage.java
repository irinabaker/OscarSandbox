package com.telran.oscar.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllProductsPage extends BasePage{
    public AllProductsPage(WebDriver driver) {
        super(driver);

    }

    @FindBy(xpath = "//form[@action='/en-gb/basket/add/209/']")
    WebElement addToBasket;

    public AllProductsPage clickOnAddToBasketButton() {
        click(addToBasket);
        return this;
    }
}
