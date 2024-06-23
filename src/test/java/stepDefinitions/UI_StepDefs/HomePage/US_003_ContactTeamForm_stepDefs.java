package stepDefinitions.UI_StepDefs.HomePage;
import com.github.javafaker.Faker;
import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.CommonPage;
import utility.UI.Utilities;

import static stepDefinitions.Hooks.driver;

public class US_003_ContactTeamForm_stepDefs extends CommonPage {

    Faker formFirma= new Faker();
    Faker formVorname= new Faker();
    Faker formNachname= new Faker();
    Faker fakeEmail= new Faker();
    Faker formText= new Faker();

    @Given("Check if the form is visible")
    public void check_if_the_form_is_visible() {
        getHomePage().verifyForm();
    }
    @Then("Fill in and submit the form")
    public void fill_in_and_submit_the_form() throws InterruptedException {
        getHomePage().simulateHumanTyping(getHomePage().formFirma, formFirma.company().name());
        getHomePage().simulateHumanTyping(getHomePage().formVorname, formVorname.name().firstName());
        getHomePage().simulateHumanTyping(getHomePage().formNachname, formNachname.name().lastName());
        getHomePage().simulateHumanTyping(getHomePage().formEMail, fakeEmail.internet().emailAddress());
        getHomePage().simulateHumanTyping(getHomePage().formText, formText.lorem().paragraph(5));
        getHomePage().checkBox1.click();
        Utilities.waitFor(2);
        getHomePage().checkBox2.click();
        Utilities.waitFor(3);
        driver.switchTo().frame(getHomePage().iFrameReCAPTCHA);
        getHomePage().checkBoxReCAPTCHA.click();
        driver.switchTo().parentFrame();
        getHomePage().absendenButton.click();
    }
    @Then("Verify that the form is submitted")
    public void verify_that_the_form_is_submitted() {
        String expectedURL = "https://www.bequalified.de/#gf_5";
        Assert.assertEquals(expectedURL, driver.getCurrentUrl());
    }
}