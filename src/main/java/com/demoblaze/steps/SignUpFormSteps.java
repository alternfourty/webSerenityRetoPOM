package com.demoblaze.steps;

import com.demoblaze.pages.SignUpForm;
import net.thucydides.core.annotations.Step;
import org.fluentlenium.core.annotation.Page;


public class SignUpFormSteps {
    @Page
    SignUpForm signUp;
    @Step("Input UserName")
    public void inputUsername(){
        signUp.getDriver().findElement(signUp.getTxtUsername()).sendKeys("thisUser47");
    }
    @Step("Input Password")
    public void inputPassword(){
        signUp.getDriver().findElement(signUp.getTxtPassword()).sendKeys("thisPass321#s3C");
    }
    @Step("Click Sign Up Button on form")
    public void clickFormSignUpButton(){
        signUp.getDriver().findElement(signUp.getBtnSignUpForm()).click();
    }

}
