import java.io.IOException;

public class CloseChromeDriver {
	
	public static void main(String[] args) throws IOException {
		Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
	}
}
