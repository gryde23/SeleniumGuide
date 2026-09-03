package com.gryde.components;

import org.openqa.selenium.WebElement;

public class CheckboxComponent {

    private final WebElement root;

    public CheckboxComponent(WebElement root) {
        this.root = root;
    }

    public void check() {
        if (!root.isSelected()) {
            root.click();
        }
    }

    public void uncheck() {
        if (root.isSelected()) {
            root.click();
        }
    }
}
