package com.demoblaze.steps;

import com.demoblaze.pages.HomePage;
import com.demoblaze.pages.LogInForm;
import com.demoblaze.utils.ExcelRead;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Map;

public class LogInSteps {
    @Page
    HomePage homePage;
    @Page
    LogInForm logInForm;

    @Step("Click on LogIn Button")
    public void clickOnLogIn() {
        homePage.getDriver().findElement(homePage.getBtnLogIn()).click();
    }

    @Step("Input Login Username")
    public void inputLoginUsername() {
        ArrayList<Map<String, String>> excelData;
        try {
            excelData = ExcelRead.readExcel("src/test/resources/Data/dataFile.xlsx", "registry");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logInForm.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        logInForm.getDriver().findElement(logInForm.getTxtLoginUsername()).sendKeys(excelData.get(0).get("User"));
    }

    @Step("Input Login Password")
    public void inputLoginPassword() {
        ArrayList<Map<String, String>> excelData;
        try {
            excelData = ExcelRead.readExcel("src/test/resources/Data/dataFile.xlsx", "registry");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        logInForm.getDriver().findElement(logInForm.getTxtLoginPassword()).sendKeys(excelData.get(0).get("Password"));
    }

    @Step("Click LogIn Up Button on form")
    public void clickFormSignUpButton() {
        logInForm.getDriver().findElement(logInForm.getBtnLogInForm()).click();
    }

    @Step("Verify successful login")
    public void verifyLoggedUser() {
        ArrayList<Map<String, String>> excelData;

        try {
            excelData = ExcelRead.readExcel("src/test/resources/Data/dataFile.xlsx", "registry");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Wait<WebDriver> wait = new WebDriverWait(homePage.getDriver(), Duration.ofSeconds(1));
        Assert.assertTrue(wait.until(ExpectedConditions.textToBePresentInElement(homePage.getDriver().findElement(homePage.getLoggedUsername()), "Welcome " + excelData.get(0).get("User"))));
    }
}
