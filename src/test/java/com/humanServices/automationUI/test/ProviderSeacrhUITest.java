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
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch1() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch2() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch3() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
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
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch9() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
		driver.findElement(By.id("city")).sendKeys("WALLS");
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
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch12() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch13() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch14() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch15() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
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
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
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
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("city")).sendKeys("WALLS");
		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");
		driver.findElement(By.id("submitButton")).click();
		driver.close();

	}

	@Test
	public void testProviderSearch22() throws Exception {

		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("http://localhost:8090/ProviderManagement/#/");
		driver.findElement(By.id("providerName")).sendKeys("Abigail Burross");
		driver.findElement(By.id("providerType")).sendKeys(
				"Non-Relative Out-Of-Home");

		driver.findElement(By.id("city")).sendKeys("WALLS");

		driver.findElement(By.id("county")).sendKeys("DESOTO");
		driver.findElement(By.id("qualityRating")).sendKeys("0");
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
