package com.gryde.pages;

import org.openqa.selenium.WebElement;

public abstract class BaseComponent {

    protected final WebElement root;

    protected BaseComponent(WebElement root) {
        this.root = root;
    }
}
