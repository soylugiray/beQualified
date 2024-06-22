package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pages.CommonPage;
import utility.ConfigurationReader;
import utility.Driver;
import utility.ReusableMethods;

import java.time.Duration;

import static io.restassured.RestAssured.given;
import static utility.ReusableMethods.waitFor;

public class Hooks extends CommonPage{

    public static WebDriver driver;
    public static boolean isHeadless = false;
    public static String browserType = "chrome";

    public static boolean isFullScreen = true;
    public static int width;
    public static int height;

    public static CommonPage commonPage;
    public static Actions actions;

    public static Response response;
    public static String token;
    public static String PHPSESSID;


    @Before(value = "@headless", order = 0)
    public void setIsHeadless() {
        isHeadless = true;
    }

    @Before(value = "@firefox", order = 0)
    public void setIsFirefox() {
        browserType = "firefox";
    }


    @Before(value = "@iPhone12", order = 0)
    public void setiPhone12() {
        isFullScreen = false;
        width = 390;
        height = 844;
    }

    @Before(order = 1, value = "@UI")
    public void setup() {

        driver = Driver.getDriver();
        commonPage = new CommonPage() {
        };
        actions = new Actions(driver);
        driver.manage().deleteAllCookies();
       // driver.get(ConfigurationReader.getProperty("urlTest"));
    }

    @After(value = "@UI")
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "screenshots");
        }

    //      Driver.closeDriver();
//        LocalStorage localStorage = ((WebStorage) driver).getLocalStorage();
//        localStorage.clear();
//        driver.navigate().refresh();
    }


    @Before("@user1")
    public void denemeLogin() {
        System.out.println(
                "email : " + ConfigurationReader.getProperty("user1_email") +
                        " password : " + ConfigurationReader.getProperty("user1_password")
        );
    }

//    @Before(value = "@Login1")
//    public void login1() {
//        driver.get(URL_LINKS.LOGIN_URL.getLink());
//        getLoginPage().input_GirisYap.click();
//        getLoginPage().E_postaButton.click();
//        getLoginPage().E_PostaBox.sendKeys(USER1.getUsername());
//        getLoginPage().PasswordBox.sendKeys(USER1.getPassword());
//        getLoginPage().RobotDegilimBox.click();
//        ReusableMethods.waitForPageToLoad(5);
//        getLoginPage().KaydolunButton.click();
//
//    }
//    @Before (value = "@LoginViaEmail")
//    public void loginViaEmail(){
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
//        driver.get("https://stg.mobilyaplan.app/login");
//        wait.until(ExpectedConditions.visibilityOf(getLoginPage().emailAdressInbox));
//        getLoginPage().emailAdressInbox.sendKeys(ConfigurationReader.getProperty("loginV2_UserName"));
//        getLoginPage().passwordInbox.sendKeys(ConfigurationReader.getProperty("loginV2_UserPassword"));
//        waitFor(2);
//        getLoginPage().loginButtonViaEmail.click();
//        waitFor(2);
//
//     }

//    @Before(value = "@LoginStgV2")
//    public void loginStgV2() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        driver.get("https://stg.mobilyaplan.app/");
//        getLoginPage().getWebelmByName("Google ile giriş yap").click();
//        //getLoginPage().EpostaBox.sendKeys(USERCREDENTIAL.USER_EMNE.getUsername());
//        getLoginPage().EpostaBox.sendKeys(ConfigurationReader.getProperty("loginV2_UserName"));
//        getLoginPage().getWebelmByName("Next").click();
//        wait.until(ExpectedConditions.invisibilityOf(getLoginPage().EpostaBox));
//        //getLoginPage().inputPassword.sendKeys(USERCREDENTIAL.USER_EMNE.getPassword());
//        getLoginPage().inputPassword.sendKeys(ConfigurationReader.getProperty("loginV2_UserPassword"));
//        getLoginPage().getWebelmByName("Next").click();
//        ReusableMethods.waitFor(5);                //  NOT: BU BOLUMU OTOMASYONDA DA İLK GOOGLE HESABIYLA GIRISTE ISTEDI DAHA SONRA ISTEMEDI
////        TelephoneNumberBtn.sendKeys("05327153356");
////        ReusableMethods.waitFor(5);
////        TelephoneAfterSubmit.click();
////        ReusableMethods.waitFor(5);
////        GoogleIleGirisYapBtn.click();
////        ReusableMethods.waitFor(5);
////        TigersKesifPlusGoogle.click();
////        ReusableMethods.waitFor(10);
//        getProjeHomePage().NewProjeOlusturBtn.click();
//        ReusableMethods.waitFor(5);
//        getProjeHomePage().ProjeAdiBtn.sendKeys("KesifPlusMobilyaPlan");
//        ReusableMethods.waitFor(5);
//        getProjeHomePage().ProjeAdiOKBtn.click();
//        ReusableMethods.waitFor(5);
//        getProjeHomePage().KesifPlusMobilyaPlanSILBtn.click();
//        ReusableMethods.waitFor(5);
//        getProjeHomePage().KesifPlusMobilyaPlanSILBtnYES.click();
//        ReusableMethods.waitFor(5);
//        getProjeHomePage().ProjeyiAcBtn.click();
//        ReusableMethods.waitFor(5);
//
//    }
//    @Before(value = "@LoginStgV2")
//    public void loginStgV2() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(10));
//        driver.get("https://stg.mobilyaplan.app/");
//        getLoginPage().getWebelmByName("Google ile giriş yap").click();
//        //getLoginPage().EpostaBox.sendKeys(USERCREDENTIAL.USER_EMNE.getUsername());
//        getLoginPage().EpostaBox.sendKeys(ConfigurationReader.getProperty("loginV2_UserName"));
//        getLoginPage().getWebelmByName("Next").click();
//        wait.until(ExpectedConditions.invisibilityOf(getLoginPage().EpostaBox));
//        //getLoginPage().inputPassword.sendKeys(USERCREDENTIAL.USER_EMNE.getPassword());
//        getLoginPage().inputPassword.sendKeys(ConfigurationReader.getProperty("loginV2_UserPassword"));
//        getLoginPage().getWebelmByName("Next").click();
//        ReusableMethods.waitFor(3);
//        getProjeHomePage().NewProjeOlusturBtn.click();
//        ReusableMethods.waitFor(1);
//        getProjeHomePage().ProjeAdiBtn.sendKeys("KesifPlusMobilyaPlan");
//        ReusableMethods.waitFor(1);
//        getProjeHomePage().ProjeAdiOKBtn.click();
//        ReusableMethods.waitFor(1);
//       getProjeHomePage().KesifPlusMobilyaPlanSILBtn.click();
//       ReusableMethods.waitFor(1);
//       getProjeHomePage().KesifPlusMobilyaPlanSILBtnYES.click();
//       ReusableMethods.waitFor(1);
//        getProjeHomePage().ProjeyiAcBtn.click();
//        ReusableMethods.waitFor(6);
//
//
//    }
//    @Before(value = "@LoginV2")
//    public void loginV2() {
//        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
//        driver.get("https://stg.mobilyaplan.app/");
//        getLoginPage().getWebelmByName("Google ile giriş yap").click();
//
//        getLoginPage().EpostaBox.sendKeys(ConfigurationReader.getProperty("loginV2_UserName"));
//        getLoginPage().getWebelmByName("Next").click();
//        wait.until(ExpectedConditions.invisibilityOf(getLoginPage().EpostaBox));
//
//        getLoginPage().inputPassword.sendKeys(ConfigurationReader.getProperty("loginV2_UserPassword"));
//        getLoginPage().getWebelmByName("Next").click();
//        ReusableMethods.waitFor(1);
//
//        }

    @Before("@DB")
    public void setupDatabase() {
        utility.DB.DatabaseUtilities.createMYSQLConnection();
    }

    @After("@DB")
    public void closeDatabase() {
        utility.DB.DatabaseUtilities.closeConnection();

    }

//    public static String getToken(USERCREDENTIAL usercredential) {
//        response = given()
//                .contentType(ContentType.JSON)
//                .body("{\"email\": \"" + usercredential.getUsername() + "\",\"password\": \"" + usercredential.getPassword() + "\"}")
//                .when()
//                .post("https://****.app/webapi/login/sign-in");
//
//        JsonPath jsonPath = response.jsonPath();
//        token = jsonPath.getString("token");
//
//        return token;
//    }



//public String getToken(USERCREDENTIAL usercredential, URL_LINKS url_links) {
//    response = given()
//            .contentType(ContentType.JSON)
//            .body("{\"email\": \"" + usercredential.getUsername() + "\",\"password\": \"" + usercredential.getPassword() + "\"}")
//            .when()
//            .post(url_links.getLink());
//
//    JsonPath jsonPath = response.jsonPath();
//    token = jsonPath.getString("token");
//
//    return token;
//}


}
