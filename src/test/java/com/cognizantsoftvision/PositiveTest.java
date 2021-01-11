package com.cognizantsoftvision;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PositiveTest {

    @Test(priority=1)
    public void searchAutomationPositionsTest() throws InterruptedException {

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

        WebElement joinOurTeamLink = driver.findElement(By.id("nav-menu-item-19894"));
        System.out.println("Found Join Out Team Link");
        joinOurTeamLink.click();
        Thread.sleep(3000);

        WebElement careersLink = driver.findElement(By.id("nav-menu-item-24464"));
        System.out.println("Found Careers Link");
        careersLink.click();
        Thread.sleep(3000);

        WebElement careersSearchForm = driver.findElement(By.id("careers-search-job"));
        Assert.assertNotNull(careersLink);
        Thread.sleep(3000);

        WebElement studio = driver.findElement(By.xpath("//*[@id=\"careers-search-job\"]/div/div[1]/div/select"));
        //WebElement studio = driver.findElement(By.xpath("//*[@id=\"careers-search-job\"]"));
        System.out.println("Found Found Select");
         Select selectStudio = new Select (studio);
        selectStudio.selectByValue("cluj-napoca");
        Thread.sleep(3000);

        WebElement guilds = driver.findElement(By.xpath("//*[@id=\"careers-search-job\"]/div/div[2]/div/select"));
        Select selectGuild = new Select (guilds);
        selectGuild.selectByValue("quality-engineering-guild");
        Thread.sleep(3000);

        WebElement searchByKeyword = driver.findElement(By.xpath("//*[@id=\"careers-search-job\"]/div/div[3]/div/input"));
        searchByKeyword.sendKeys("automation");
        Thread.sleep(3000);

        WebElement searchButton = driver.findElement(By.xpath("//*[@id=\"careers-search-job\"]/div/div[4]/button"));
        searchButton.click();
        System.out.println("Search button clicked");
        Thread.sleep(2000);

        WebElement ourOpeningsList = driver.findElement(By.xpath("/html/body/div/div/div/div/section[3]/div[1]/div/div[2]/div/div/h2"));
        Assert.assertTrue(ourOpeningsList.getText().contains("Openings"));

        Thread.sleep(3000);

        //close browser
        driver.quit();

    }
}


