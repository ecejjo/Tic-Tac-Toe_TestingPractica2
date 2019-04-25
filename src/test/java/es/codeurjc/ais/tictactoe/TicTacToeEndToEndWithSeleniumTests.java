package es.codeurjc.ais.tictactoe;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TicTacToeEndToEndWithSeleniumTests {

	/*
	Pruebas de sistema de la aplicación: Para verificar que la aplicación completa funciona
	correctamente se implementarán pruebas de sistema con Selenium. Para simular una partida
	el test iniciará dos navegadores web de forma simultánea e irá interactuando con ellos de
	forma alternativa. De esta forma, puede simular un partida por turnos. El juego está
	implementado de forma que al finalizar el mismo, el resultado aparece en un cuadro de
	diálogo (alert). El objetivo de los tests consiste en verificar que el mensaje del alert es el
	esperado cuando gana cada uno de los jugadores y cuando quedan empate.
	Para obtener el mensaje del alert se utiliza el código browser1.switchTo().alert().getText()
	 */
	
	private WebDriver driverPlayer1, driverPlayer2;
	
	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
		WebApp.start();
	 }
	
	@AfterClass
	public static void teardownClass() {
		WebApp.stop();
	}
	
	 @Before
	 public void setupTest() {
		 driverPlayer1 = new ChromeDriver();
		 driverPlayer2 = new ChromeDriver();
	 }
	 
	 @After
	 public void teardown() {
		 if (driverPlayer1 != null) {
			 driverPlayer1.quit();
		 }
		 
		 if (driverPlayer2 != null) {
			 driverPlayer2.quit();
		 }
	 }
	 
	 @Test
	 public void Player1WinsTest () throws InterruptedException {

		 driverPlayer1.get("http://localhost:8080/");
		 WebElement nickname = driverPlayer1.findElement(By.id("nickname"));
		 nickname.sendKeys("Player1");
		 WebElement playButton = driverPlayer1.findElement(By.id("startBtn"));
		 playButton.click();

		 driverPlayer2.get("http://localhost:8080/");
		 nickname = driverPlayer2.findElement(By.id("nickname"));
		 nickname.sendKeys("Player2");
		 playButton = driverPlayer2.findElement(By.id("startBtn"));
		 playButton.click();
		 
		 WebElement cell = driverPlayer1.findElement(By.id("cell-0"));
		 cell.click();
		 
		 cell = driverPlayer2.findElement(By.id("cell-1"));
		 cell.click();
		 
		 cell = driverPlayer1.findElement(By.id("cell-3"));
		 cell.click();
		 
		 cell = driverPlayer2.findElement(By.id("cell-4"));
		 cell.click();

		 cell = driverPlayer1.findElement(By.id("cell-6"));
		 cell.click();
		 
		 Thread.sleep(1000);  // Gives time to show the alert

		 String messagePlayer1 = driverPlayer1.switchTo().alert().getText();
		 String messagePlayer2 = driverPlayer2.switchTo().alert().getText();
		 
		 assertThat(messagePlayer1).isEqualTo("Player1 wins! Player2 looses.");
		 assertThat(messagePlayer2).isEqualTo("Player1 wins! Player2 looses.");
	 }
	 
	 @Test
	 public void Player1LoosesTest () throws InterruptedException {

		 driverPlayer1.get("http://localhost:8080/");
		 WebElement nickname = driverPlayer1.findElement(By.id("nickname"));
		 nickname.sendKeys("Player1");
		 WebElement playButton = driverPlayer1.findElement(By.id("startBtn"));
		 playButton.click();

		 driverPlayer2.get("http://localhost:8080/");
		 nickname = driverPlayer2.findElement(By.id("nickname"));
		 nickname.sendKeys("Player2");
		 playButton = driverPlayer2.findElement(By.id("startBtn"));
		 playButton.click();
		 
		 WebElement cell = driverPlayer1.findElement(By.id("cell-0"));
		 cell.click();
		 
		 cell = driverPlayer2.findElement(By.id("cell-1"));
		 cell.click();
		 
		 cell = driverPlayer1.findElement(By.id("cell-3"));
		 cell.click();
		 
		 cell = driverPlayer2.findElement(By.id("cell-4"));
		 cell.click();

		 cell = driverPlayer1.findElement(By.id("cell-8"));
		 cell.click();
		 
		 cell = driverPlayer2.findElement(By.id("cell-7"));
		 cell.click();
		 
		 Thread.sleep(1000);  // Gives time to show the alert

		 String messagePlayer1 = driverPlayer1.switchTo().alert().getText();
		 String messagePlayer2 = driverPlayer2.switchTo().alert().getText();
		 
		 assertThat(messagePlayer1).isEqualTo("Player2 wins! Player1 looses.");
		 assertThat(messagePlayer2).isEqualTo("Player2 wins! Player1 looses.");
	 }
	 
	 @Test
	 public void DrawTest () throws InterruptedException {

		 driverPlayer1.get("http://localhost:8080/");
		 WebElement nickname = driverPlayer1.findElement(By.id("nickname"));
		 nickname.sendKeys("Player1");
		 WebElement playButton = driverPlayer1.findElement(By.id("startBtn"));
		 playButton.click();

		 driverPlayer2.get("http://localhost:8080/");
		 nickname = driverPlayer2.findElement(By.id("nickname"));
		 nickname.sendKeys("Player2");
		 playButton = driverPlayer2.findElement(By.id("startBtn"));
		 playButton.click();
		 
		 WebElement cell = driverPlayer1.findElement(By.id("cell-0"));
		 cell.click();
		 
		 cell = driverPlayer2.findElement(By.id("cell-1"));
		 cell.click();
		 
		 cell = driverPlayer1.findElement(By.id("cell-3"));
		 cell.click();
		 
		 cell = driverPlayer2.findElement(By.id("cell-4"));
		 cell.click();

		 cell = driverPlayer1.findElement(By.id("cell-2"));
		 cell.click();
		 
		 cell = driverPlayer2.findElement(By.id("cell-8"));
		 cell.click();
		 
		 cell = driverPlayer1.findElement(By.id("cell-7"));
		 cell.click();
		 
		 cell = driverPlayer2.findElement(By.id("cell-6"));
		 cell.click();
		 
		 cell = driverPlayer1.findElement(By.id("cell-5"));
		 cell.click();
		 
		 Thread.sleep(1000);  // Gives time to show the alert

		 String messagePlayer1 = driverPlayer1.switchTo().alert().getText();
		 String messagePlayer2 = driverPlayer2.switchTo().alert().getText();
		 
		 assertThat(messagePlayer1).isEqualTo("Draw!");
		 assertThat(messagePlayer2).isEqualTo("Draw!");
	 }
}
