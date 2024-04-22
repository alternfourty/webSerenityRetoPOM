package com.demoblaze.steps;

import com.demoblaze.pages.SignUpForm;
import com.demoblaze.utils.ExcelRead;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;


public class SignUpFormSteps {
    @Page
    SignUpForm signUpForm;

    @Step("Input UserName")
    public void inputUsername(){
        ArrayList<Map<String,String>> excelData;

        try {
            excelData = ExcelRead.readExcel("src/test/resources/Data/dataFile.xlsx","registry");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        signUpForm.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signUpForm.getDriver().findElement(signUpForm.getTxtUsername()).sendKeys(excelData.get(0).get("User"));
    }
    @Step("Input Password")
    public void inputPassword(){
        ArrayList<Map<String,String>> excelData;

        try {
            excelData = ExcelRead.readExcel("src/test/resources/Data/dataFile.xlsx","registry");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        signUpForm.getDriver().findElement(signUpForm.getTxtPassword()).sendKeys(excelData.get(0).get("Password"));
    }
    @Step("Click Sign Up Button on form")
    public void clickFormSignUpButton(){
        signUpForm.getDriver().findElement(signUpForm.getBtnSignUpForm()).click();
    }

    @Step("Verify successful account creation")
    public void successfulAlert(){
        Wait<WebDriver> wait = new WebDriverWait(signUpForm.getDriver(), Duration.ofSeconds(5));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());

        Assert.assertTrue(alert.getText().contains("Sign up successful."));
        alert.accept();
    }

}
