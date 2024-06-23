package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utility.Driver;

import java.util.List;
import java.util.Random;

import static stepDefinitions.Hooks.driver;

public class HomePage extends CommonPage {
    @FindBy (xpath = "//input[@placeholder='Firma']")
    public WebElement formFirma;
    @FindBy (xpath = "//input[@placeholder='Vorname']")
    public WebElement formVorname;
    @FindBy (xpath = "//input[@placeholder='Nachname']")
    public WebElement formNachname;
    @FindBy (xpath = "//input[@placeholder='E-Mail']")
    public WebElement formEMail;
    @FindBy (xpath = "//textarea[@name='input_5']")
    public WebElement formText;
    @FindBy (xpath = "    //label[@for='choice_5_6_1']")
    public WebElement checkBox1;
    @FindBy (xpath = "//label[@for='choice_5_13_1']")
    public WebElement checkBox2;
    @FindBy (xpath = "//iframe[@title='reCAPTCHA']")
    public WebElement iFrameReCAPTCHA;
    @FindBy (xpath = "//div[@class='recaptcha-checkbox-border']")
    public WebElement checkBoxReCAPTCHA;
    @FindBy (xpath = "//button[@id='gform_submit_button_5']")
    public WebElement absendenButton;
    @FindBy (xpath = "(//div[@class='container-fluid '])[1]")
    public WebElement navBar;

    public void verifyHomePage() {
        Assert.assertEquals("https://www.bequalified.de/", driver.getCurrentUrl());
    }

    public void verifyNavBarMenu(List<List<String>> titles) {
        String title;
        for (int i = 0; i < titles.size(); i++) {
            title = titles.get(i).get(0);
            System.out.println("title = " + title);
            WebElement element = Driver.getDriver().findElement(By.xpath("//a[@class='mega-menu-link'][text()='" + title + "']"));
            Assert.assertTrue(element.isDisplayed() && element.isEnabled());
        }
    }

    public void verifyForm() {
        WebElement form = Driver.getDriver().findElement(By.xpath("//ul[@id='gform_fields_5']"));
        Assert.assertTrue(form.isDisplayed());
    }
    public void simulateHumanTyping(WebElement webElement, String input) throws InterruptedException {

        Random r = new Random();

        for (int i = 0; i < input.length(); i++) {
            try {
                Thread.sleep((int) r.nextGaussian() * 20 + 100);
            } catch (InterruptedException e) {
            }
            String s = new StringBuilder().append(input.charAt(i)).toString();
            webElement.sendKeys(s);
        }
    }
}
