package pages;


import org.openqa.selenium.support.PageFactory;
import utility.Driver;

public abstract class CommonPage {

    public CommonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    private HomePage anasayfaPage;

    public HomePage getAnasayfaPage() {
        if (homePage == null){
            homePage = new HomePage();

        }
        return homePage;
    }


}
