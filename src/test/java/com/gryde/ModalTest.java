package com.gryde;

import com.gryde.pages.ModalPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ModalTest extends BaseTest{

    @Test
    void openSmallModal() {
        String modalTitle = new ModalPage(driver)
                .open()
                .openSmallModal()
                .smallModal
                .getTitle();

        assertEquals(
                "Small Modal",
                modalTitle
        );
    }
}
