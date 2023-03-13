import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookWordCounter {

    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5L));
        driver.manage().window().maximize();
        driver.get("https://www.gutenberg.org/");
        
        String book = "the art of war";
        
        driver.findElement(By.id("menu-book-search")).sendKeys(book);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        
        List<WebElement> booksList = driver.findElements(By.cssSelector("li.booklink span.title"));
        WebElement bookSelected = 
                booksList.stream().filter(bl -> bl.getText().equalsIgnoreCase(book)).findFirst().orElse(null);
        
        if (bookSelected == null) {
            System.out.println("No se encontro el libro: " + book);
            driver.quit();
            
            return;
        }
        
        bookSelected.click();
        
        driver.findElement(By.xpath("//a[contains(text(), 'Plain Text')]")).click();
        
        Scanner scan = new Scanner(new URL(driver.getCurrentUrl()).openStream());
        
        int wordCount = 0;
        while (scan.hasNext()) {
            wordCount++;
            scan.next();
        }

        scan.close();
        
        System.out.println("The book '" + book + "' has approximately " + wordCount + " words.");
        
        driver.quit();
    }

}
