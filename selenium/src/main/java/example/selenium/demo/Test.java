package example.selenium.demo;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriverException;
import example.selenium.core.Driver;

public class Test {

	private static final String ENDPOINT = "http://www.github.com/erkan000";

	public static void main(String[] args) {
		Test t = new Test();
		t.openBrowserAndGotoWebSite();
	}

	private void openBrowserAndGotoWebSite(){
		Driver driver = null;
		try {
			driver = new Driver();
			driver.getPage(ENDPOINT);

			// Click Examples repo
			driver.findElementByXPath("/html/body/div[4]/main/div/div[4]/div[3]/div[1]/div/ol/li[2]/div/div/div/a/span").click();

			// Click quarkus folder
			driver.findElementByID("48c98d5007d903ea1469a2956d3b3536-793c2312eee21d5540fd1e948ba473522c1de80d").click();

			// Click src/main folder
			driver.findElementByID("ce60e70f9de430e6b7a551de3d651ed6-58dd08c06b9d191e6820e759b59c8cef5393810d").click();

			// Click java/example/quarkus folder
			driver.findElementByXPath("/html/body/div[4]/div/main/div[2]/div/div[3]/table/tbody[2]/tr[3]/td[2]/span/a/span").click();

			//			Wait sample code
			//			Wait wait = new WebDriverWait(Driver.driver, 5);
			//			wait.until(ExpectedConditions.visibilityOf(driver.findElementByXPath("//*[@id='j_id158744676_976402e:j_id158744676_97640d6']")));

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
	

	/**
	 * Hastane
	 * 
	 * 

	//Sağlık Tesisi Menüsü
	driver.findElementByXPath("/html/body/table/tbody/tr/td[1]/div[2]/form/div/ul/li[39]/a/span").click();
	//tesis kodu textBox'ı
	WebElement el = driver.findElementByID("form:j_id_12");
	el.sendKeys("11068891");
	//Ara butonu tıkla
	driver.findElementByID("form:btnSorgula").click();
	//İlk tesise tıkla				
	driver.findElementByXPath("/html/body/table/tbody/tr/td[2]/div/div[2]/form[2]/div[2]/div/span/div/div[2]/table/tbody/tr/td[1]").click();
	//İşlemler menüsüne tıkla
	driver.findElementByXPath("//*[@id=\"form:islemlerButton\"]").click();	
	//tesis yatak item'ına bas.
	driver.findElementByXPath("/html/body/div[7]/ul/li[18]/a/span").click();

	 * 
	 */
}

