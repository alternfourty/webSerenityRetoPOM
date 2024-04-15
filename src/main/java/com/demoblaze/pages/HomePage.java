package com.demoblaze.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HomePage extends PageObject {
    private final By btnSignIn = By.xpath("//*[@id='signin2']");

    public By getBtnSignIn() {
        return btnSignIn;
    }
}
