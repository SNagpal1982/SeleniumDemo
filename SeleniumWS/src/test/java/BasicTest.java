import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BasicTest {
	
	public static void main(String[] args) 
	{
		System.out.println("ProjectPath : " + System.getProperty("user.dir"));
		
		  System.setProperty("webdriver.gecko.driver", ".//drivers//geckodriver.exe"); 
		  WebDriver driver = new FirefoxDriver(); 
		  
		  driver.get("https://mvnrepository.com/");
		 		
	}

}
