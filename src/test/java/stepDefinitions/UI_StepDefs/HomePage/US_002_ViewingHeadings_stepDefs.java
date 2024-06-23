package stepDefinitions.UI_StepDefs.HomePage;
import com.applitools.eyes.*;
import com.applitools.eyes.selenium.Eyes;

import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import pages.CommonPage;
import utility.UI.ImageComparison;
import static stepDefinitions.Hooks.driver;

import java.util.List;

public class US_002_ViewingHeadings_stepDefs extends CommonPage {

    Eyes eyes = new Eyes();

    @Then("The user should see the headings below at the top of the homepage")
    public void the_user_should_see_the_headings_below_at_the_top_of_the_homepage(io.cucumber.datatable.DataTable dataTable) {
        List<List<String>> menuItems = dataTable.asLists(String.class);
        getHomePage().verifyNavBarMenu(menuItems);
        eyes.setApiKey("sf86bEi4eQVXgb00yNPkw1036105LQOkf6z2nsQtKCa106Cx0110");
        eyes.open(driver, "beQualified","appearance-check2");

    }
    @Then("The general appearance of the page should be visually appealing without layout issues")
    public void the_general_appearance_of_the_page_should_be_visually_appealing_without_layout_issues() {
//        eyes.checkWindow("checkHomePage");
        eyes.checkElement(By.xpath("(//div[@class='container-fluid '])[1]"));
        eyes.close();

    }

}
