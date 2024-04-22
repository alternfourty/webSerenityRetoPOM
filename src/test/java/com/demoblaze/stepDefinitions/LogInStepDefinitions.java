package com.demoblaze.stepDefinitions;

import com.demoblaze.steps.HomeSteps;
import com.demoblaze.steps.LogInSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LogInStepDefinitions {

    @Steps
    LogInSteps logInSteps;

    @When("The user clicks on the login button and fills the user and the password")
    public void theUserClicksOnTheLoginButtonAndFillsTheUserAndThePassword() {
        logInSteps.clickOnLogIn();
        logInSteps.inputLoginUsername();
        logInSteps.inputLoginPassword();
        logInSteps.clickFormSignUpButton();
    }
    @Then("I should see the page welcome message with the username on the navigation menu")
    public void iShouldSeeThePageWelcomeMessageWithTheUsernameOnTheNavigationMenu() {
        logInSteps.verifyLoggedUser();
    }

}
