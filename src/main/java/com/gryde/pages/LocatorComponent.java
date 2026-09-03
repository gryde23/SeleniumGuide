package com.gryde.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public abstract class LocatorComponent {

    protected final WebDriver driver;
    protected final By rootLocator;

    protected LocatorComponent(
            WebDriver driver,
            By rootLocator
    ) {
        this.driver = driver;
        this.rootLocator = rootLocator;
    }

    protected WebElement root() {
        return driver.findElement(rootLocator);
    }
}
