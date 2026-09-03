package com.gryde.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecurePage extends BasePage{

    private final By flashMessage = By.id("flash");
    private final By logoutButton = By.linkText("Logout");

    public SecurePage(WebDriver driver) {
        super(driver);
    }

    public String getFlashMessage() {
        return waitForVisible(flashMessage).getText();
    }

    public LoginPage logout() {
        click(logoutButton);
        return new LoginPage(driver);
    }
}
