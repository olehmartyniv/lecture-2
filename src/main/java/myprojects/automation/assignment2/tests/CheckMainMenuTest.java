package myprojects.automation.assignment2.tests;

import myprojects.automation.assignment2.BaseScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static myprojects.automation.assignment2.utils.Properties.getBaseAdminUrl;

public class CheckMainMenuTest extends BaseScript{
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_RED = "\u001B[31m";

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

        // initializes array of title names
        String[] links = {"Dashboard", "Заказы", "Каталог", "Клиенты", "Служба поддержки", "Статистика", "Modules",
                        "Design", "Доставка", "Способ оплаты", "International", "Shop Parameters", "Конфигурация"};

        for (String link : links) {
            WebElement menu = driver.findElement(By.linkText(link));

            // waits while link is ready
            WebDriverWait wait = new WebDriverWait(driver, 5);
            wait.until(ExpectedConditions.elementToBeClickable(menu));

            // enter the section, save the page title an refresh the page
            menu.click();
            String title = driver.findElement(By.tagName("h2")).getText();
            driver.navigate().refresh();

            // prints title in green if the same section
            if (title.equals(driver.findElement(By.tagName("h2")).getText())) {
                System.out.println(ANSI_GREEN + driver.getTitle() + ANSI_RESET);
            } else {
                System.out.println(ANSI_RED + driver.getTitle() + ANSI_RESET);
            }
        }

        // exit
        driver.quit();
    }
}
