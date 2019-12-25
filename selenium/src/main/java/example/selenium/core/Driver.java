package example.selenium.core;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver {

	public static WebDriver driver;

	public Driver(){
		URL res = getClass().getClassLoader().getResource("geckodriver.exe");
		System.setProperty("webdriver.gecko.driver", res.getPath());
		driver = new FirefoxDriver();
		
		//Tıklamalar arasında delay koyarak element bulunamaması durumları engellemek için.
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}	
	
	public void getPage(String link){
		driver.get(link);
	}
	
	public WebElement findElementByXPath(String xpathExpression){
		By by = byXPath(xpathExpression);
		WebElement ele = driver.findElement(by);
		return ele;
	}
	
	public By byXPath(String xpathExpression){
		return By.xpath(xpathExpression);
	}
	
	public WebElement findElementByClass(String className){
		return driver.findElement(byClass(className));
	}
	
	public By byClass(String className){
		return By.className(className);
	}
	
	public WebElement findElementByID(String id){
		return driver.findElement(byID(id));
	}
	
	public By byID(String id){
		return By.id(id);
	}
	
	public void quit(){
		driver.quit();
	}
}
