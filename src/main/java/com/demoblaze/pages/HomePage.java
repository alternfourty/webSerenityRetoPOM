package com.demoblaze.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    private final By btnSignIn = By.xpath("//*[@id='signin2']");
    private final By btnLogIn = By.xpath("//*[@id='login2']");
    private final By loggedUsername = By.xpath("//*[@id='nameofuser']");

    public By getBtnSignIn() {
        return btnSignIn;
    }

    public By getBtnLogIn() {
        return btnLogIn;
    }

    public By getLoggedUsername() {
        return loggedUsername;
    }
}
