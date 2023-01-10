import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WhatsMsgSender {

	public static void main(String[] args) throws InterruptedException {
		String persona = "";	
		String mensaje = "";
		int veces = 0;
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		
		// colocar chromerdriver.exe en el cwd
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://web.whatsapp.com/");
		
		System.out.println("Debes leer el qr en tu aplicacion (30 segundos)");
		
		try {
			// El nombre que almacenes en "persona" debe ser identico a como esta guardado el contacto en wp
			driver.findElement(By.xpath("//span[@title='" + persona + "']")).click();	
			
		} catch (NoSuchElementException e) {
			// si no encuentra ningun contacto termina la ejecucion
			System.out.println("No se encontro a: " + persona);
			
			driver.quit();
			return;
		}
	
		for (int i = 0; i < veces; i++) {
			driver.switchTo().activeElement().sendKeys(mensaje + Keys.ENTER);
		}
		
		driver.quit();
	}
}
