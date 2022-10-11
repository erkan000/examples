package example.selenium.demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;

import example.selenium.core.Driver;

public class Test2 {

	private static final String ENDPOINT = "https://www.ulovdomov.cz/vyhledavani/pronajem/Praha?radit_dle=nejnovejsi&bounds=50.177403%3B14.706795%3B49.941936%3B14.224453";

	public static void main(String[] args) {
		Test2 t = new Test2();
		t.openBrowserAndGotoWebSite();
	}

	private void openBrowserAndGotoWebSite(){
		Driver driver = null;
		try {
			driver = new Driver();
			driver.getPage(ENDPOINT);
			Driver.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

			List<WebElement> dizi = driver.findElementsByClass("css-1hfajy0");			
			
			for (WebElement ele : dizi) {
				System.out.println("Header : " + ele.findElement(By.className("css-1pf5oej")).getText());
				System.out.println("Price : " + ele.findElement(By.className("css-jmll66")).getText());
			}			

		} catch (NoSuchElementException e) {
			System.out.println("Element couldn found. Check xpath or id value");
		} catch (WebDriverException e) {
			System.out.println("Driver problem : " + e.getMessage());
		} catch (Exception e) {
			System.out.println("General Error : " + e.getMessage());
		}
		if(driver != null) {
			driver.quit();
		}
	}
	
}

