package com.gryde;

import com.gryde.pages.DynamicControlsPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class DynamicControlsTest extends BaseTest {

    @Test
    void enableInput() {
        DynamicControlsPage page = new DynamicControlsPage(driver)
                .open()
                .enableInput()
                .waitUntilInputEnabled();

        assertTrue(page.inputIsEnabled());
    }

    @Test
    void checkboxShouldBeInvisible() {
        boolean isVisible = new DynamicControlsPage(driver)
                .open()
                .removeCheckBox()
                .waitUntilCheckboxRemoved()
                .isCheckBoxVisible();

        assertFalse(isVisible);
    }

    @Test
    void removeAndAddCheckboxShouldBeVisible() {
        boolean isVisible = new DynamicControlsPage(driver)
                .open()
                .removeCheckBox()
                .addCheckBox()
                .waitUntilCheckboxAdded()
                .isCheckBoxVisible();

        assertTrue(isVisible);
    }
}
