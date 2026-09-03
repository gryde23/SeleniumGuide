package com.gryde.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertPage extends BasePage{

    private final String url = "https://the-internet.herokuapp.com/javascript_alerts";

    private final By alertButton = By.xpath("//button[contains(text(), 'Alert')]");
    private final By confirmButton = By.xpath("//button[contains(text(), 'Confirm')]");
    private final By promptButton = By.xpath("//button[contains(text(), 'Prompt')]");
    private final By resultMessage = By.id("result");

    public AlertPage(WebDriver driver) {
        super(driver);
    }

    public AlertPage open() {
        driver.get(url);
        return this;
    }

    public AlertPage openAlert() {
        click(alertButton);
        return this;
    }

    public AlertPage openConfirm() {
        click(confirmButton);
        return this;
    }

    public AlertPage openPrompt() {
        click(promptButton);
        return this;
    }

    public String getAlertText() {
        return driver.switchTo().alert().getText();
    }

    public AlertPage acceptAlert() {
        waitForAlert().accept();
        return this;
    }

    public AlertPage dismissAlert() {
        waitForAlert().dismiss();
        return this;
    }

    private Alert waitForAlert() {
        wait.until(ExpectedConditions.alertIsPresent());
        return driver.switchTo().alert();
    }

    public AlertPage enterPromptText(String text) {
        waitForAlert();
        driver.switchTo().alert().sendKeys(text);
        return acceptAlert();
    }

    public String getResult() {
        return waitForVisible(resultMessage).getText();
    }
}
