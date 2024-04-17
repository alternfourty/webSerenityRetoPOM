package com.demoblaze.steps;

import com.demoblaze.pages.SignUpForm;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SignUpFormSteps {
    @Page
    SignUpForm signUpForm;

    @Step("Input UserName")
    public void inputUsername(){
        signUpForm.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signUpForm.getDriver().findElement(signUpForm.getTxtUsername()).sendKeys("thisNeL2781");
    }
    @Step("Input Password")
    public void inputPassword(){
        signUpForm.getDriver().findElement(signUpForm.getTxtPassword()).sendKeys("thisPass321#s3C");
    }
    @Step("Click Sign Up Button on form")
    public void clickFormSignUpButton(){
        signUpForm.getDriver().findElement(signUpForm.getBtnSignUpForm()).click();
    }
    @Step("Verify successful account creation")
    public void successfulAlert(){
        WebDriver driver = signUpForm.getDriver();
        Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(4));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String text = alert.getText();
        alert.accept();
        Assert.assertTrue(text.contains("Sign up successful."));
    }

}
