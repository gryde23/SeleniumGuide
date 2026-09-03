package com.gryde;

import com.gryde.pages.WindowsPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WindowsTest extends BaseTest {

    @Test
    void openOneMoreWindowAndCheck() {
        WindowsPage page = new WindowsPage(driver)
                .open()
                .openNewWindow()
                .waitForNewWindow()
                .switchToNewWindow();

        String newWindowTitle = page.getWindowTitle();

        assertEquals(
                "New Window",
                newWindowTitle
        );
    }

    @Test
    void openNewWindowAndClose() {
        String originalWindowTitle = new WindowsPage(driver)
                .open()
                .openNewWindow()
                .waitForNewWindow()
                .switchToNewWindow()
                .switchToOriginalWindow()
                .getWindowTitle();

        assertEquals(
                "The Internet",
                originalWindowTitle
        );
    }
}
