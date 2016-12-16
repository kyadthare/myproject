package com.humanServices.automationUI.test;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ProviderSeacrhUITest {

	@Test
	public void testProViderName() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testCountyValue() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderType() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerType")).sendKeys("slot Contractor");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testAddressCity() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("city")).sendKeys("MOSS POINT");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testQualityRating() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Irma");
		driver.findElement(By.id("county")).sendKeys("BOLIVAR");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch1() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys(
				"1st Step Early Learning Center");
		driver.findElement(By.id("providerType")).sendKeys("Center");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch2() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("A Child's View");
		driver.findElement(By.id("city")).sendKeys("OLIVE BRANCH");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch3() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Alma Bernal");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch4() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch5() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch6() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch7() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch8() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");

		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("county")).sendKeys("DESOTO");

		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch9() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("qualityRating")).sendKeys("2");
		driver.findElement(By.id("city")).sendKeys("LAKE CORMORANT");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch10() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch11() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerType")).sendKeys("Group Home");
		driver.findElement(By.id("city")).sendKeys("ADAMS");
		driver.findElement(By.id("county")).sendKeys("NATCHEZ");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch12() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Angelica Garza");
		driver.findElement(By.id("city")).sendKeys("JACKSON");
		driver.findElement(By.id("county")).sendKeys("HINDS");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch13() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Angelia White");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("city")).sendKeys("HORN LAKE");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch14() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys(
				"A Step Above Preparatory Academy Inc.");
		driver.findElement(By.id("providerType")).sendKeys("Center");
		driver.findElement(By.id("county")).sendKeys("FORREST");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch15() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys(
				"Boone Elementary After School Program");
		driver.findElement(By.id("providerType")).sendKeys("Center");
		driver.findElement(By.id("qualityRating")).sendKeys("5");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch16() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch17() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch18() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys(
				"Best Lil Schoolhouse 2");
		driver.findElement(By.id("county")).sendKeys("WARREN");
		driver.findElement(By.id("providerType")).sendKeys(" Center");
		driver.findElement(By.id("qualityRating")).sendKeys("4");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch19() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch20() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch21() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Alejandra Flores");
		driver.findElement(By.id("city")).sendKeys("BROOKHAVEN");
		driver.findElement(By.id("county")).sendKeys("LINCOLN");
		driver.findElement(By.id("providerType")).sendKeys("Group Home");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch22() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("BISD Community Services - STARS Red Rock Elementary");
		driver.findElement(By.id("providerType")).sendKeys(
				"Slot Contractor");

		driver.findElement(By.id("city")).sendKeys("TUPELO");

		driver.findElement(By.id("county")).sendKeys("LEE");
		driver.findElement(By.id("qualityRating")).sendKeys("1");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch23() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

}
