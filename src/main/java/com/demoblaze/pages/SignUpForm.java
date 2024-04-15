package com.demoblaze.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class SignUpForm extends PageObject {
    private final By txtUsername = By.xpath("//input[@id='sign-username']");
    private final By txtPassword = By.xpath("//input[@id='sign-password']");
    private final By btnSignUpForm = By.xpath("//button[contains(@onclick,'register()')]");
    public By getTxtUsername() {
        return txtUsername;
    }

    public By getTxtPassword() {
        return txtPassword;
    }

    public By getBtnSignUpForm() {
        return btnSignUpForm;
    }
}
