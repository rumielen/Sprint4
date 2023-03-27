package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.util.List;


public class MainPage {
    private final WebDriver driver;
    private final By UpOrderButton = (By.className("Button_Button__ra12g"));
    private final By middleOrderButton = (By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM']"));
    private final By importantQuestionsList = (By.xpath(".//div[@class='accordion__button']"));

    public boolean isAnswerTextCorrect;




    public MainPage(WebDriver driver) {
        this.driver = driver;

    }


    public OrderPage clickUpOrderButton() {
        driver.findElement(UpOrderButton).click();
        return new OrderPage(driver);
    }

    public OrderPage clickMiddleOrderButton() {
        //прокрутка
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(middleOrderButton));
        driver.findElement(middleOrderButton).click();
        return new OrderPage(driver);
    }


    public boolean clickImportantQuestion(String importantQuestionText, String answerText) {

        List<WebElement> questionsList = driver.findElements(importantQuestionsList);
        for (WebElement questionItem : questionsList) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", questionItem);
            if (questionItem.getText().contains(importantQuestionText)) {
                questionItem.click();
                System.out.println(questionItem.getText());
                By answerItem = RelativeLocator.with(By.tagName("p")).below(questionItem);

                System.out.println(driver.findElement(answerItem).getText());
                String answer = driver.findElement(answerItem).getText();
                if(answer.contains(answerText)) {
                    isAnswerTextCorrect = true;
                }
            }
        }
        return isAnswerTextCorrect;
    }

}
