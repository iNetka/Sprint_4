package ru.practikum.scooter;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RentPage {
    private final WebDriver driver;

    private final By rentalDateField = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    private final By rentalTimeField = By.className("Dropdown-placeholder");
    private final By rentalTime = By.xpath(".//*[(@role ='option' and text()='пятеро суток')]");
    private final By checkBoxColourBlackPearl = By.xpath(".//input[@id='black']");
    private final By checkBoxColourGreyDespair = By.xpath(".//input[@id='grey']");
    private final By commentField = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    private final By orderButton = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Заказать')]");
    private final By orderButtonYes = By.xpath(".//button[(@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да')]");
    private final By nextButton = By.xpath(".//div[contains(@class, 'Order_NextButton')]/button");

    public RentPage(WebDriver driver) {
        this.driver = driver;
    }

    public RentPage fillRentInfo(String date, String color, String comment) {
        driver.findElement(rentalDateField).sendKeys(date, Keys.ENTER);

        driver.findElement(rentalTimeField).click();
        driver.findElement(rentalTime).click();

        if ("black".equals(color)) {
            driver.findElement(checkBoxColourBlackPearl).click();
        } else {
            driver.findElement(checkBoxColourGreyDespair).click();
        }

        driver.findElement(commentField).sendKeys(comment);
        return this;
    }

    public RentPage confirmOrder() {
        driver.findElement(orderButton).click();
        driver.findElement(orderButtonYes).click();
        return this;
    }

    public boolean checkOrderCreated() {
        return new WebDriverWait(driver, 5)
                .until(ExpectedConditions.textToBe(nextButton, "Посмотреть статус"));
    }
}