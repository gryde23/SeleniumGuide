package com.gryde;

import com.gryde.pages.AlertPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AlertsTest extends BaseTest {

    @Test
    void clickForAlert() {
        String alertMessage = new AlertPage(driver)
                .open()
                .openAlert()
                .getAlertText();

        assertEquals(
                "I am a JS Alert",
                alertMessage
        );
    }

    @Test
    void dismissConfirmAlert() {

        String result = new AlertPage(driver)
                .open()
                .openConfirm()
                .dismissAlert()
                .getResult();

        assertEquals(
                "You clicked: Cancel",
                result
        );
    }

    @Test
    void sendKeysToAlert() {

        String result = new AlertPage(driver)
                .open()
                .openPrompt()
                .enterPromptText("Aboba")
                .getResult();


        assertEquals(
                "You entered: Aboba",
                result
        );
    }
}
