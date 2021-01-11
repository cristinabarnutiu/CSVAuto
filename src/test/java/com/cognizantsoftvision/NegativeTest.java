package com.cognizantsoftvision;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class NegativeTest {

    WebDriver driver;
    
    @Test(priority=2)
    public void searchSomethingThatDoesNotExist() throws InterruptedException {

        System.out.println("Starting test");

        //create driver
        System.setProperty("webdriver.chrome.driver","src/main/resources/drivers/chromedriver");
        WebDriver driver = new ChromeDriver();

        //maximize browser window
        driver.manage().window().maximize();

        //open test page
        String url = "https://www.cognizantsoftvision.com/";
        driver.get(url);
        System.out.println("Page is opened.");

        Thread.sleep(3000);

        System.out.println("Looking for Accep Cookies message");

        WebElement acceptCookiesButton = driver.findElement(By.id("hs-eu-confirmation-button"));
        System.out.println("Select \"Accept Cookies\"");

        acceptCookiesButton.click();

        //id hs-eu-confirmation-button
        //*[@id="nav-menu-item-19894"]/a

        Thread.sleep(3000);

        WebElement searchIcon = driver.findElement(By.xpath("/html/body/div/div/header/div/span/img"));
        System.out.println("Found Search icon");
        searchIcon.click();
        Thread.sleep(3000);

        WebElement searchField = driver.findElement(By.id("search"));
        System.out.println("Found Search field");
        searchField.sendKeys("somethingthatdoesnotexist");
        System.out.println("Type search term");
        searchField.sendKeys(Keys.ENTER);
        System.out.println("Press enter");
        Thread.sleep(4000);

        WebElement result = driver.findElement(By.cssSelector("div.no-results"));
        System.out.println(result.getText());
        Assert.assertTrue(result.getText().equalsIgnoreCase("No results found"));
        System.out.println("No results found is displayed");
        Thread.sleep(3000);

        //close browser
        driver.quit();

    }
}
