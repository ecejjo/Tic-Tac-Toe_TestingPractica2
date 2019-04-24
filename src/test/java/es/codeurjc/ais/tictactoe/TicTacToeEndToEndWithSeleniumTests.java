package es.codeurjc.ais.tictactoe;

import org.junit.After;
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
	
	protected WebDriver driverPlayer1, driverPlayer2;
	
	@BeforeClass
	public static void setupClass() {
		WebDriverManager.chromedriver().setup();
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
	 public void test () throws InterruptedException {

		 driverPlayer1.get("http://localhost:8080/");
		 Thread.sleep(3000);  // Let the user actually see something!

		 WebElement nicknamePlayer1 = driverPlayer1.findElement(By.id("nickname"));
		 nicknamePlayer1.sendKeys("Player1");
		 Thread.sleep(3000);  // Let the user actually see something!

		 WebElement playButtonPlayer1 = driverPlayer1.findElement(By.id("startBtn"));
		 playButtonPlayer1.click();
		 Thread.sleep(3000);  // Let the user actually see something!

		 driverPlayer2.get("http://localhost:8080/");
		 Thread.sleep(3000);  // Let the user actually see something!

		 WebElement nicknamePlayer2 = driverPlayer2.findElement(By.id("nickname"));
		 nicknamePlayer2.sendKeys("Player2");
		 Thread.sleep(3000);  // Let the user actually see something!

		 WebElement playButtonPlayer2 = driverPlayer2.findElement(By.id("startBtn"));
		 playButtonPlayer2.click();
		 Thread.sleep(3000);  // Let the user actually see something!

		 Thread.sleep(5000);  // Let the user actually see something!
	 }

}
