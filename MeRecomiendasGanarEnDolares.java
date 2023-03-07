import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MeRecomiendasGanarEnDolares {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		String preguntaCorrecta = "me recomiendas ganar en dolares?";	
		System.out.println("Pregunta algo");
		while (true) {
			String preguntaUsuario = scanner.nextLine();
			
			if (!preguntaCorrecta.equalsIgnoreCase(preguntaUsuario)) {
				System.out.println("Debes hacer la pregunta correcta");
				continue;
			}
			
			scanner.close();
			break;
		}
		
		for (int i = 0; i < 1000; i++) {			
			System.out.print("ANALIZANDO");
			
			for (int j = 0; j < 1000; j++) { 
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com/");
		
		driver.findElement(By.cssSelector("[name='q']")).sendKeys("a cuanto esta el dolar" + Keys.ENTER);
		String result = driver.findElement(By.className("dDoNo")).getText();
		
		driver.quit();
		
		double pesos = Double.valueOf(result.split(" ")[0]);
		
		if (pesos >= 20) {
			System.out.println("SI");
		} else {
			System.out.println("NO");
		}
		
	}
}
