package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static myprojects.automation.assignment2.utils.Properties.*;

public class LoginTest extends BaseScript {

    public static void main(String[] args) throws InterruptedException {

        // initializes webdriver and opens admin page
        WebDriver driver = getDriver();
        driver.get(getBaseAdminUrl());
        Thread.sleep(500);

        // fills email form
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys("webinar.test@gmail.com");

        // fills password form
        WebElement password = driver.findElement(By.id("passwd"));
        password.sendKeys("Xcg7299bnSmMuRLp9ITw");

        // log in by clicking button
        WebElement signIn = driver.findElement(By.name("submitLogin"));
        signIn.click();
        Thread.sleep(1000);

        // opens dropdown menu
        WebElement user = driver.findElement(By.id("employee_infos"));
        user.click();

        // log out by clicking button
        WebElement signOut = driver.findElement(By.id("header_logout"));
        signOut.click();
        Thread.sleep(500);

        // exit
        driver.quit();
    }
}
