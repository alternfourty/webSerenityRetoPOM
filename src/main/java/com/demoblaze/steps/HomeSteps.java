package com.demoblaze.steps;

import com.demoblaze.pages.HomePage;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;

import java.time.Duration;

public class HomeSteps {
    @Page
    HomePage homePage;

    @Step("Open the browser")
    public void openBrowser(){
        homePage.openUrl("https://demoblaze.com/");
    }
    @Step("Click on SignIn Button")
    public void clickOnSignIn(){
        homePage.getDriver().findElement(homePage.getBtnSignIn()).click();
    }

}
