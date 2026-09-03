package com.gryde.pages;

import com.gryde.components.ModalComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ModalPage extends BasePage {

    private final String url = "https://demoqa.com/modal-dialogs";

    private final By smallModalButton = By.id("showSmallModal");
    private final By largeModalButton = By.id("showLargeModal");
    public ModalComponent smallModal;

    public ModalPage(WebDriver driver) {
        super(driver);
    }

    public ModalPage open() {
        driver.get(url);
        return this;
    }

    public ModalPage openSmallModal() {
        click(smallModalButton);
        smallModal = new ModalComponent(driver.findElement(By.cssSelector(".modal-dialog.modal-sm")));
        return this;
    }

    public boolean isModalVisible() {
        return smallModal != null;
    }

    public ModalPage closeSmallModal() {
        smallModal.close();
        return this;
    }
}
