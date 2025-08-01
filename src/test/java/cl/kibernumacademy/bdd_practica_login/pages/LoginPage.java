package cl.kibernumacademy.bdd_practica_login.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;
    // Localizadores
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginMessage = By.id("login-message");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By welcomeMessage = (By.xpath("(//div[@class='container mt-5'])[1]"));

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public String getWelcomeMessage() {
        return driver.findElement(welcomeMessage).getText();
    }

    public String getLoginMessage() {
        WebElement message = driver.findElement(loginMessage);
        return message.getText();
    }

    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}
