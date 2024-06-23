package stepDefinitions.UI_StepDefs.HomePage;

import io.cucumber.java.en.*;
import pages.CommonPage;
import utility.ConfigurationReader;
import static stepDefinitions.Hooks.driver;

public class US_001_AccesingHomePage_stepDefs extends CommonPage {

    @Given("The user navigates to the home page")
    public void the_user_navigates_to_the_home_page() {
        driver.get(ConfigurationReader.getProperty("urlMain"));
    }

    @Then("The homepage should load successfully")
    public void the_homepage_should_load_successfully() {
        getHomePage().verifyHomePage();
    }
}
