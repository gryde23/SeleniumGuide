package com.gryde.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class DynamicControlsPage extends BasePage{

    private final String url = "https://the-internet.herokuapp.com/dynamic_controls";

    private final By checkBox = By.cssSelector("#checkbox");
    private final By removeButton = By.xpath("//button[text()='Remove']");
    private final By addButton = By.xpath("//button[text()='Add']");
    private final By enableButton = By.xpath("//button[text()='Enable']");
    private final By disableButton = By.xpath("//button[text()='Disable']");
    private final By input = By.xpath("//input[@type='text']");

    public DynamicControlsPage(WebDriver driver) {
        super(driver);
    }

    public DynamicControlsPage open() {
        driver.get(url);
        return this;
    }

    public DynamicControlsPage removeCheckBox() {
        click(removeButton);
        return this;
    }

    public DynamicControlsPage addCheckBox() {
        click(addButton);
        return this;
    }

    public boolean isCheckBoxVisible() {
        return !driver.findElements(checkBox).isEmpty();
    }

    public DynamicControlsPage enableInput() {
        click(enableButton);
        return this;
    }

    public DynamicControlsPage disableInput() {
        click(disableButton);
        return this;
    }

    public DynamicControlsPage waitUntilCheckboxAdded() {
        waitForVisible(checkBox);
        return this;
    }

    public DynamicControlsPage waitUntilCheckboxRemoved() {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(checkBox));
        return this;
    }

    public DynamicControlsPage waitUntilInputEnabled() {
        waitForClickable(input);
        return this;
    }

    public boolean inputIsEnabled() {
        return driver.findElement(input).isEnabled();
    }
}
