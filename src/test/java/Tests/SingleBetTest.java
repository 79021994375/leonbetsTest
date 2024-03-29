package Tests;

import Common.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestListener;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

@Listeners()
public class SingleBetTest{
    BetDetails betDetails;

    @Test
    public void makeSingleBetTest() {
        WebDriver driver = new ChromeDriver();

        //Открыть главную страницу
        driver.get("https://leonbets.net/?lang=en-US");

        //Войти в систему тестовым пользователем
        Login login = new Login(driver);
        login.makeLogin("73008469", "1234567q");

        //Перейти в раздел "Ставки Live"
        driver.get("https://leonbets.net/bet-on-live-matches");

        //Выбрать любой коэффицент, далее ввести сумму 10 и сделать ставку
        Bets bets = new Bets(driver);
        bets.makeSingleBet();

        //Нажать на кнопку Подробности ставки
        BetSlip betSlip = new BetSlip(driver);
        betDetails = betSlip.openBetDetailsPage();

        //Убедиться что событие присуствует и проверить правильность статуса ставки
        assertTrue(betDetails.getBetCount() > 0, "События не найдено! Перепроверьте купон ставок.");
        assertTrue(betDetails.getBetStatus().equals("Bet waiting"), "Статус ставки не соответствует ожидаемому! Перепроверьте статус ставки");
    }
}
