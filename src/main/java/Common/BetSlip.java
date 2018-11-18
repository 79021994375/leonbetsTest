package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static java.lang.Thread.sleep;

public class BetSlip {

    WebDriver driver;

    public BetSlip(WebDriver driver) {
        this.driver = driver;
    }

    public BetDetails openBetDetailsPage() {
        betDetailsButton().click();

        try {
            sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return new BetDetails(driver);
    }

    public WebElement betDetailsButton() {
        return driver.findElement(By.cssSelector("input[value='Bet details']"));
    }

    public void clearBetslip() {
        if(driver.findElements(By.cssSelector("div[class='dellall ib']")).size() > 0) {
            driver.findElement(By.cssSelector("div[class='dellall ib']")).click();
        }
    }

    public void makeStake(String minStake) {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("input[name='stakeInput']")).clear();
        driver.findElement(By.cssSelector("input[name='stakeInput']")).sendKeys(minStake);
    }

    public void clickPlaceBetButton() {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.cssSelector("input[value='Place bet']")).click();
    }
}