import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import pages.MainPage;


import static org.junit.Assert.assertTrue;


@RunWith(Parameterized.class)
public class OrderScooterTest {
    private final String clientName;
    private final String clientSurname;
    private final String clientAddress;
    private final String clientMetro;
    private final String clientPhone;
    private final String clientDelivery;
    private final String clientRentTime;
    private final String clientColor;
    private final String clientComment;
    private WebDriver driver;


    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    public OrderScooterTest (String clientName, String clientSurname, String clientAddress, String clientMetro,
                             String clientPhone, String clientDelivery, String clientRentTime, String clientColor,
                             String clientComment) {
        this.clientName = clientName;
        this.clientSurname = clientSurname;
        this.clientAddress = clientAddress;
        this.clientMetro = clientMetro;
        this.clientPhone = clientPhone;
        this.clientDelivery = clientDelivery;
        this.clientRentTime = clientRentTime;
        this.clientColor = clientColor;
        this.clientComment = clientComment;
    }

    @Parameterized.Parameters
    public static Object[][] getClientInformation() {
        return new Object[][] {
                { "Иван", "Иванов", "Ленина 168", "Черкизовская", "79001205522", "30.03.2023", "двое суток", "black", "Побыстрее"},
                { "Петр", "Сидоров", "Московская 12", "Сокольники", "79998881155", "31.03.2023", "сутки", "grey", "Привет"},
        };
    }



    @Test
    public void checkShowsWindow_orderSuccessDone_positiveCase_clickUpButton() {
        boolean isOrderSuccessDisplayed;
        isOrderSuccessDisplayed = new MainPage(driver)
                .clickUpOrderButton()
                .setName(clientName)
                .setSurname(clientSurname)
                .setAddress(clientAddress)
                .setMetro(clientMetro)
                .setPhone(clientPhone)
                .clickNextPageButtonOrderForm()
                .setDeliveryDate(clientDelivery)
                .setRentPeriod(clientRentTime)
                .setColorScooter(clientColor)
                .setComment(clientComment)
                .clickDoOrderButton()
                .orderSuccessDoneIsDisplayed();
        assertTrue(isOrderSuccessDisplayed);


    }

    @Test
    public void checkShowsWindow_orderSuccessDone_positiveCase_clickMiddleButton() {
        boolean isOrderSuccessDisplayed;
        isOrderSuccessDisplayed = new MainPage(driver)
                .clickMiddleOrderButton()
                .setName(clientName)
                .setSurname(clientSurname)
                .setAddress(clientAddress)
                .setMetro(clientMetro)
                .setPhone(clientPhone)
                .clickNextPageButtonOrderForm()
                .setDeliveryDate(clientDelivery)
                .setRentPeriod(clientRentTime)
                .setColorScooter(clientColor)
                .setComment(clientComment)
                .clickDoOrderButton()
                .orderSuccessDoneIsDisplayed();
        assertTrue(isOrderSuccessDisplayed);


    }

    @After
    public void tearDown () {
        driver.quit();
    }
}
