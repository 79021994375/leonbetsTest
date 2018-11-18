package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BetDetails {
    WebDriver driver;

    public BetDetails(WebDriver driver) {
        this.driver = driver;
    }

    public int getBetCount() {
        int eventCount = driver.findElements(By.cssSelector("div.evt-row+div")).size();

        return eventCount;
    }

    public String getBetStatus() {
        String eventTable = driver.findElement(By.cssSelector("div[class='field-value state waiting']")).getText();

        return eventTable;
    }
}