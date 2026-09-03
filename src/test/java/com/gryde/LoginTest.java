package com.gryde;

import com.gryde.pages.LoginPage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest extends BaseTest{

    @Test
    void successfulLogin() {
        String flashMessage = new LoginPage(driver)
                .open()
                .enterUsername("tomsmith")
                .enterPassword("SuperSecretPassword!")
                .loginSuccess()
                .getFlashMessage();

        assertTrue(
                flashMessage.contains("You logged into a secure area!")
        );
    }

    @ParameterizedTest
    @CsvSource({
            "tomsmith, wrong-password",
            "wrong-username, password",
            "1, 2"
    })
    void failedLoginShouldShowFlash(String username, String password) {
        String flashMessage = new LoginPage(driver)
                .open()
                .enterUsername(username)
                .enterPassword(password)
                .loginFailed()
                .getFlashMessage();

        assertTrue(flashMessage.contains("is invalid!"));
    }
}
