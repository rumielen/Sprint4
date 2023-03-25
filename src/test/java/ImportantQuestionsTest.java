import extensions.WebDriverFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.MainPage;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pages.MainPage;

@RunWith(Parameterized.class)
public class ImportantQuestionsTest {
    private WebDriver driver;
    private final String importantQuestionText;


    @Before
    public void setup() {
        driver = WebDriverFactory.get();
    }

    public ImportantQuestionsTest(String importantQuestionText) {
        this.importantQuestionText = importantQuestionText;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionText() {
        return new Object[][] {
                {"Сколько это стоит? И как оплатить?"},
                {"Хочу сразу несколько самокатов! Так можно?"},
                {"Как рассчитывается время аренды?"},
                {"Можно ли заказать самокат прямо на сегодня?"},
                {"Можно ли продлить заказ или вернуть самокат раньше?"},
                {"Вы привозите зарядку вместе с самокатом?"},
                {"Можно ли отменить заказ?"},
                {"Я жизу за МКАДом, привезёте?"},
        };
    }

    @Test
    public void checkImportantQuestionsList_textAnswerIsDisplayedCorrectly_AfterClick () {
        MainPage page = new MainPage(driver);
        page.clickImportantQuestion(importantQuestionText);

    }

    @After
    public void tearDown () {
        driver.quit();
    }
}

