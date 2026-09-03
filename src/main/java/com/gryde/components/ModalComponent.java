package com.gryde.components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ModalComponent {

    private final WebElement root;

    public ModalComponent(WebElement root) {
        this.root = root;
    }

    public String getTitle() {
        return root.findElement(By.cssSelector(".modal-title.h4")).getText();
    }

    public WebElement getBody() {
        return root.findElement(By.className("modal-body"));
    }

    public void close() {
        root.findElement
                (By.xpath("//button[text()='Close']")).click();
    }
}
