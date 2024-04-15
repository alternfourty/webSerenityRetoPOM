package com.demoblaze.stepDefinitions;

import com.demoblaze.steps.HomeSteps;
import com.demoblaze.steps.SignUpFormSteps;
import io.cucumber.java.en.*;
import net.thucydides.core.annotations.Steps;

public class CreateAccountStepDefinitions {

    @Steps
    HomeSteps homeSteps;
    SignUpFormSteps signInSteps;

    @Given("User is able to access blaze webstore")
    public void userIsAbleToAccessBlazeWebstore() {
        homeSteps.openBrowser();

    }
    @Given("clicks on SignUp links")
    public void clicksOnSignUpLinks() {
        homeSteps.clickOnSignIn();
    }
    @When("The user fills the data for the new account")
    public void theUserFillsTheDataForTheNewAccount() {
        signInSteps.inputUsername();
        signInSteps.inputPassword();
        signInSteps.clickFormSignUpButton();
    }
    @Then("I should see a browser alert with a successful message")
    public void iShouldSeeABrowserAlertWithASuccessfulMessage() {

    }
}