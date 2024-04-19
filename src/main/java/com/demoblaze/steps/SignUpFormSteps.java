package com.demoblaze.steps;

import com.demoblaze.pages.SignUpForm;
import com.demoblaze.utils.ExcelRead;
import io.cucumber.datatable.DataTable;
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
    public void inputUsername(DataTable dataTable){
        ArrayList<Map<String,String>> excelData;
        try {
            excelData = ExcelRead.readExcel("src/test/resources/Data/dataFile.xlsx","registry");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        signUpForm.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        signUpForm.getDriver().findElement(signUpForm.getTxtUsername()).sendKeys(dataTable.asLists().get(1).get(0));
    }
    @Step("Input Password")
    public void inputPassword(DataTable dataTable){
        signUpForm.getDriver().findElement(signUpForm.getTxtPassword()).sendKeys(dataTable.asLists().get(1).get(1));
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
