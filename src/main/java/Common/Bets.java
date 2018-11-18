package Common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import static java.lang.Thread.sleep;

public class Bets {
    WebDriver driver;
    BetSlip betSlip;
    String betMessage;

    public Bets(WebDriver driver) {
        this.driver = driver;
        betSlip = new BetSlip(driver);
    }

    //Single bet
    public void makeSingleBet() {
        //Удалить данные
        betSlip.clearBetslip();
        //Выбрать любое событие и нвжвть на любой коэффициент из списка
        getRandomCoefficient().click();
        //Перейти в купон ставок и ввести 10
        betSlip.makeStake("10");
        //Нажать на кнопку Сделать ставку
        for (int i = 0; i < 10; i++) {
            //Проверить ставку на сообщение - Your bet has been placed Single
            betMessage = driver.findElement(By.cssSelector("div[class='bs-body']")).getText();
            if (betMessage.contains("Your bet has been placed Single")) {
                break;
            }
            //Проверить ставку на сообщение - There are unavailable events
            if (betMessage.contains("There are unavailable events or markets in the bet slip")) {
                betSlip.clearBetslip();
                getRandomCoefficient().click();
                betSlip.makeStake("10");
            }
            //В купоне ставок должна быть одна ставка
            if(driver.findElements(By.cssSelector("div.bs-items>div")).size() != 1){
                betSlip.clearBetslip();
                getRandomCoefficient().click();
                betSlip.makeStake("10");
            }

            //Нажать на кнопку сделать ставку
            betSlip.clickPlaceBetButton();

            //Подождать время приёма ставки
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //Express bet
    public void makeExpressBet() {
        //Удалить данные
        betSlip.clearBetslip();
        //Выбрать любое событие и нажать на любой коэффициент из списка
        getRandomCoefficient().click();
        //Выбрать любое событие и нажать на любой коэффициент из списка
        getRandomCoefficient().click();
        //Перейти в купон ставок и ввести 10
        betSlip.makeStake("10");
        //Нажать на кнопку Сделать ставку
        for (int i = 0; i < 10; i++) {
            //Проверить ставку на сообщение - Your bet has been placed Single
            betMessage = driver.findElement(By.cssSelector("div[class='bs-body']")).getText();
            //Проверить ставку на сообщение - Your bet has been placed Multiple(2)
            if (betMessage.contains("Your bet has been placed Multiple (2)")) {
                break;
            }
            //Проверить ставку на сообщение - A single event may appear on a multiple only once
            if (betMessage.contains("A single event may appear on a multiple only once.")) {
                betSlip.clearBetslip();
                getRandomCoefficient().click();
                getRandomCoefficient().click();
                betSlip.makeStake("10");
            }
            //Проверить ставку на сообщение - There are unavailable events
            if (betMessage.contains("There are unavailable events or markets in the bet slip")) {
                betSlip.clearBetslip();
                getRandomCoefficient().click();
                getRandomCoefficient().click();
                betSlip.makeStake("10");
            }
            //В купоне ставок должно быть две ставки
            if(driver.findElements(By.cssSelector("div.bs-items>div")).size() != 2){
                betSlip.clearBetslip();
                getRandomCoefficient().click();
                getRandomCoefficient().click();
                betSlip.makeStake("10");
            }

            //Нажать на кнопку сделать ставку
            betSlip.clickPlaceBetButton();

            //Подождать время приёма ставки
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //System bet
    public void makeSystemBet() {
        //Удалить данные
        betSlip.clearBetslip();
        //Выбрать любое событие и нажать на любой коэффициент из списка
        getRandomCoefficient().click();
        //Выбрать любое событие и нажать на любой коэффициент из списка
        getRandomCoefficient().click();
        //Выбрать любое событие и нажать на любой коэффициент из списка
        getRandomCoefficient().click();
        //Перейти в купон ставок и ввести 10
        betSlip.makeStake("10");
        //Нажать на кнопку Сделать ставку
        for (int i = 0; i < 10; i++) {
            //Проверить ставку на сообщение - Your bet has been placed Single
            betMessage = driver.findElement(By.cssSelector("div[class='bs-body']")).getText();
            //Проверить ставку на сообщение - Your bet has been placed Multiple(2/3)
            if (betMessage.contains("Your bet has been placed System (2/3)")) {
                break;
            }
            //Проверить ставку на сообщение - A single event may appear on a multiple only once
            if (betMessage.contains("A single event may appear on a multiple only once.")) {
                betSlip.clearBetslip();
                getRandomCoefficient().click();
                getRandomCoefficient().click();
                getRandomCoefficient().click();
                betSlip.makeStake("10");
            }
            //Проверить ставку на сообщение - There are unavailable events
            if (betMessage.contains("There are unavailable events or markets in the bet slip")) {
                betSlip.clearBetslip();
                getRandomCoefficient().click();
                getRandomCoefficient().click();
                getRandomCoefficient().click();
                betSlip.makeStake("10");
            }
            //В купоне ставок должно быть три ставки
            if(driver.findElements(By.cssSelector("div.bs-items>div")).size() != 3){
                betSlip.clearBetslip();
                getRandomCoefficient().click();
                getRandomCoefficient().click();
                getRandomCoefficient().click();
                betSlip.makeStake("10");
            }

            //Выбрать ставку - System 2/3
            new Select(driver.findElement(By.cssSelector("div[class='type-select ib']>select"))).selectByVisibleText("System (2/3)");

            //Нажать на кнопку сделать ставку
            betSlip.clickPlaceBetButton();

            //Подождать время приёма ставки
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public WebElement getRandomCoefficient() {
        List<WebElement> сoefficients = geCoefficients();
        int randomIndex = new Random().nextInt(сoefficients.size()-1);
        System.out.println("Event in array: " + randomIndex);
        String coefficient = сoefficients.get(randomIndex).getText();
        System.out.println("Event coefficient: " + coefficient);
        return сoefficients.get(randomIndex);
    }

    public List<WebElement> geCoefficients() {
        List<WebElement> liveCoefficientsFullList = new ArrayList<WebElement>();
        //Получить Live события по умолчанию
        if(driver.getCurrentUrl().contains("bet-on-live-matches")) {
            liveCoefficientsFullList = getLiveTable().findElements(By.cssSelector("span[class='stn-val']"));
        }
        //Получить Prematch события
        if(driver.getCurrentUrl().contains("bet24")) {
            liveCoefficientsFullList = getPrematchTable().findElements(By.cssSelector("span[class='stn-val']"));
        }
        List<WebElement> coefficients = new ArrayList<WebElement>();
        for (WebElement element : liveCoefficientsFullList) {
            if (element.getText().equals("-")) continue;
            if (element.getText().equals("")) continue;
            if (element.getText().contains("Extra bets")) continue;
            coefficients.add(element);
            //Выбрать 10 событии из списка
            if (coefficients.size() > 20){
                break;
            }
        }
        return coefficients;
    }

    public WebElement getLiveTable() {
        return driver.findElement(By.cssSelector("div[betline='inplay']"));
    }

    public WebElement getPrematchTable() {
        return driver.findElement(By.cssSelector("div[betline='prematch']"));
    }
 }