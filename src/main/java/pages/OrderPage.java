package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static io.ous.jtoml.impl.Token.TokenType.Key;
import static org.junit.Assert.*;


public class OrderPage {
    private final WebDriver driver;
    private final By nameField = (By.xpath(".//div/input[@placeholder='* Имя']"));
    private final By surnameField = (By.xpath(".//div/input[@placeholder='* Фамилия']"));
    private final By addressField = (By.xpath(".//div/input[@placeholder='* Адрес: куда привезти заказ']"));
    private final By metroField = (By.xpath(".//input[@placeholder='* Станция метро']"));
    private final By metroStationList = (By.xpath(".//div[@class='select-search__select']"));
    private final By phoneField = (By.xpath(".//div/input[@placeholder='* Телефон: на него позвонит курьер']"));
    private final By nextButton = (By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
    private final By scooterDeliveryDate = (By.xpath(".//input[@placeholder='* Когда привезти самокат']"));
    private final By calendarFieldChooseDate = (By.xpath(".//input[@class='react-datepicker__month']"));
    private final By fieldRentalPeriod = (By.xpath(".//div[@class='Dropdown-placeholder']"));
    private final By rentPeriodList = (By.xpath(".//div[@class='Dropdown-menu']"));
    private final By scooterBlackColor = (By.xpath(".//label[@for='black']"));
    private final By scooterGreyColor = (By.xpath(".//label[@for='grey']"));
    private final By commentCourier = (By.xpath(".//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']"));
    private final By doOrderButton = (By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
    private final By yesDoOrderButton = (By.xpath(".//button[text()='Да']"));
    private final By orderSuccessDone = (By.xpath(".//div[@class='Order_ModalHeader__3FDaJ']"));
    public OrderPage (WebDriver driver){
        this.driver = driver;
    }


    public OrderPage checkNameEnabled() {
        //проверка открытости поля
        assertTrue(driver.findElement(nameField).isEnabled());
        return this;

    }

    public OrderPage setName(String clientName) {
        driver.findElement(nameField).sendKeys(clientName);
        return this;
    }

    public OrderPage checkSurnameEnabled() {
        assertTrue(driver.findElement(surnameField).isEnabled());
        return this;
    }

    public OrderPage setSurname(String clientSurname) {
        // ввод нового значения
        driver.findElement(surnameField).sendKeys(clientSurname);
        return this;
    }

    public OrderPage checkAddressEnabled() {
        //проверка открытости поля
        assertTrue(driver.findElement(addressField).isEnabled());
        return this;
    }
    public OrderPage setAddress(String clientAddress) {
        // ввод нового значения
        driver.findElement(addressField).sendKeys(clientAddress);
        return this;
    }

    public OrderPage checkMetroEnabled() {
        assertTrue(driver.findElement(metroField).isEnabled());
        return this;
    }

    public OrderPage setMetro(String clientMetro) {

        driver.findElement(metroField).click();
        List<WebElement> elements = driver.findElements(metroStationList);
        for (WebElement element : elements) {
            if (element.getText().contains(clientMetro)) {
                element.click();
            }
        }
        return this;
    }


    public OrderPage checkPhoneEnabled() {
        //проверка открытости поля
        assertTrue(driver.findElement(phoneField).isEnabled());
        return this;
    }

    public OrderPage setPhone(String clientPhone) {
        // ввод нового значения
        driver.findElement(phoneField).sendKeys(clientPhone);
        return this;
    }


        public OrderPage setDeliveryDate(String clientDeliveryDate) {
            driver.findElement(scooterDeliveryDate).click();
            driver.findElement(scooterDeliveryDate).sendKeys(clientDeliveryDate);
            driver.findElement(By.className("App_App__15LM-")).click();

        return this;
    }



    public OrderPage setRentPeriod(String clientRentPeriod) {

        driver.findElement(fieldRentalPeriod).click();
        List<WebElement> elements = driver.findElements(rentPeriodList);
        for (WebElement element : elements) {
            if (element.getText().contains(clientRentPeriod)) {
                element.click();
            }

        }
        return this;
    }


    public OrderPage setColorScooter(String clientColor) {

        if (clientColor.equals("black")) {
            driver.findElement(scooterBlackColor).click();
        }
        if (clientColor.equals("grey")) {
            driver.findElement(scooterGreyColor).click();
        }
        return this;
    }

    public OrderPage checkCommentEnabled() {
        assertTrue(driver.findElement(commentCourier).isEnabled());
        return this;
    }

    public OrderPage setComment(String clientComment) {
        driver.findElement(commentCourier).sendKeys(clientComment);
        return this;
    }



    // метод для нажатия на кнопку Далее, Заказать
    public OrderPage clickNextPageButtonOrderForm() {
        driver.findElement(nextButton).click();
        return this;
    }

    public OrderPage clickDoOrderButton() {
        driver.findElement(doOrderButton).click();
        driver.findElement(yesDoOrderButton).click();
        return this;
    }


    public boolean orderSuccessDoneIsDisplayed() {
        boolean orderDoneSuccessWindowIsDisplayed = driver.findElement(orderSuccessDone).isDisplayed();
        return orderDoneSuccessWindowIsDisplayed;

    }
}
