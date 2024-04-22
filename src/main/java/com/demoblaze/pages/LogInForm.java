package com.demoblaze.pages;

import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

public class LogInForm extends PageObject {
    private final By txtLoginUsername = By.xpath("//input[@id='loginusername']");
    private final By txtLoginPassword = By.xpath("//input[@id='loginpassword']");
    private final By btnLogInForm = By.xpath("//button[contains(@onclick,'logIn()')]");

    public By getTxtLoginUsername() {
        return txtLoginUsername;
    }

    public By getTxtLoginPassword() {
        return txtLoginPassword;
    }

    public By getBtnLogInForm() {
        return btnLogInForm;
    }
}
