package com.gryde.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class WindowsPage extends BasePage {

    private final String url = "https://the-internet.herokuapp.com/windows";

    private final By clickLink = By.linkText("Click Here");
    private String originalWindow;

    public WindowsPage(WebDriver driver) {
        super(driver);
    }

    public WindowsPage open() {
        driver.get(url);
        originalWindow = driver.getWindowHandle();
        return this;
    }

    public WindowsPage openNewWindow() {
        click(clickLink);
        return this;
    }

    public WindowsPage waitForNewWindow() {
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        return this;
    }

    public WindowsPage switchToNewWindow() {
        Set<String> windows = driver.getWindowHandles();
        for (String window: windows) {
            if (!window.equals(originalWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        return this;
    }

    public WindowsPage switchToOriginalWindow() {
        driver.switchTo().window(originalWindow);
        return this;
    }

    public String getWindowTitle() {
        return driver.getTitle();
    }
}
