import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GetChampTier {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Escribe el champ del que quieres saber el tier
		System.out.print("Champ: ");		
		String champ = scanner.nextLine();
	
		scanner.close();
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("start-maximized");
		
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
		driver.get("https://u.gg");
		
		driver.findElement(By.id("super-search-bar")).sendKeys(champ);
		driver.findElement(By.cssSelector(".react-autosuggest__suggestions-list")).click();
				
		// Obtiene el mode la URL
		String[] urlSegments = driver.getCurrentUrl().split("/");
		String currentMode = urlSegments[urlSegments.length - 1];
		
		String tier = driver.findElement(By.cssSelector("div.tier")).getText();
		
		// Imprime el modo y el tier
		System.out.println("Mode: " + currentMode);
		System.out.println("Tier: " + tier);
		
		driver.quit();
	}

}
