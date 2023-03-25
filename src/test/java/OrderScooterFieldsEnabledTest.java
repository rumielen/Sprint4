import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import org.openqa.selenium.WebDriver;
import pages.MainPage;




public class OrderScooterFieldsEnabledTest {

    private WebDriver driver;


    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }


    @Test
    public void checkOrderFormFields_AreEnabled_UpButton() {
        MainPage page = new MainPage(driver);
                page
                        .clickUpOrderButton()
                        .checkNameEnabled()
                        .checkSurnameEnabled()
                        .checkAddressEnabled()
                        .checkMetroEnabled()
                        .checkPhoneEnabled()
                        .checkCommentEnabled();
    }

    @Test
    public void checkOrderFormFields_AreEnabled_MiddleButton() {
        MainPage page = new MainPage(driver);
        page
                .clickMiddleOrderButton()
                .checkNameEnabled()
                .checkSurnameEnabled()
                .checkAddressEnabled()
                .checkMetroEnabled()
                .checkPhoneEnabled()
                .checkCommentEnabled();
    }


    @After
    public void tearDown () {
        driver.quit();
    }
}
