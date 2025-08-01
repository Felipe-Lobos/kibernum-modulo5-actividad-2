package cl.kibernumacademy.bdd_practica_login.steps;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import cl.kibernumacademy.bdd_practica_login.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class InicioSesionSteps {

    private WebDriver driver;
    private LoginPage loginPage;

    @Before
    public void setUp(){
        ChromeOptions chromeOptions = new ChromeOptions();
        driver = new ChromeDriver(chromeOptions);
    }

    @Given("que el usuario visita la página de login")
    public void que_el_usuario_visita_la_pagina_de_login(){
        driver.get("https://bco-selenium.netlify.app/");
        loginPage = new LoginPage(driver);
    }

    @When("escribe su nombre {string} y su clave {string}")
    public void ingresa_usuario_y_clave(String usuario, String clave){
        loginPage.login(usuario, clave);
    }

    @Then("debería ver el mensaje {string}")
    public void deberia_ver_el_mensaje(String mensaje){
        String welcomeMessage = loginPage.getWelcomeMessage();
        assertTrue(welcomeMessage.contains(mensaje));
    }

    @After 
    public void tearDown(){
        if(driver != null){
            driver.quit(); 
        }
    }

}