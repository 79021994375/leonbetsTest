package Common;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login {

    WebDriver driver;

    public Login(WebDriver driver){
       this.driver = driver;
       this.driver.manage().window().maximize();
    }

    public void makeLogin(String login, String password) {
        driver.findElement(By.cssSelector("input#login")).clear();
        driver.findElement(By.cssSelector("input#login")).sendKeys(login);
        driver.findElement(By.cssSelector("input#password")).clear();
        driver.findElement(By.cssSelector("input#password")).sendKeys(password);
        driver.findElement(By.cssSelector("#enter")).submit();
    }
}

