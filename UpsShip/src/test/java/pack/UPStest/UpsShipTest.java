package pack.UPStest;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pack.UPSActions.UpsShipAction;
import pack.UPSdriver.UPSdriver;

public class UpsShipTest extends UPSdriver {

	WebDriver driver = getChromeDriver();
	UpsShipAction loginActions = new UpsShipAction(this.driver);
	final String URL = "https://www.ups.com/ship/guided/origin?tx=1556007685144378&loc=en_US";

	@BeforeMethod
	public void beforeMethod() {
		driver.get(URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	@Test
	public void ShippingAccount() {
		loginActions.cook();

		loginActions.Origin("United States");
		loginActions.Name("Daniyal");
		loginActions.firstAddress("52 Flower Road");
		loginActions.zipcode("11581");
		loginActions.city("VALLEY STREAM");

		loginActions.state("New York");

		loginActions.email("butt.daniyalahmad1992@gmail.com");
		loginActions.phone("5167273017");
		loginActions.ext("111");

		loginActions.tick();
		loginActions.sbmt();
		String nextpage = loginActions.msg();

		boolean bool;

		if (nextpage.isEmpty()) {
			bool = false;
		} else {
			bool = true;
		}

		AssertJUnit.assertEquals(bool, true);

	}

//	@AfterMethod
//	public void afterTest() {
//
//		driver.close();
//
//	}

}
