package com.test.bot.frontend.helpers;

import com.test.bot.frontend.utility.FileHelper;
import com.test.bot.frontend.utility.GenerateWord;
import com.test.bot.frontend.listener.Listener;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.io.IOException;
import java.util.concurrent.TimeUnit;


public class Hook extends Listener {

	private static final String URL_MOVISTAR_FIJA   = "http://tdp-web-venta-fija-qa.mybluemix.net/acciones";
	private static final String URL_MOVISTAR_FIJA_2 = "https://tdp-admin-venta-fija-qa.mybluemix.net";
    private static final String CHROME_DRIVER = "/src/main/resources/driver/chromedriver.exe";

    private static WebDriver driver;
	static GenerateWord generateWord = new GenerateWord();

	@Before
	public void Scenario(Scenario scenario){
		onTestStart(scenario.getName());
	}

	@Before
	public void setUpWeb() throws Throwable {
		System.setProperty("webdriver.chrome.driver", FileHelper.getProjectFolder() + CHROME_DRIVER);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		generateWord.startUpWord();
	}
	
	@After
	public void tearDown() throws IOException {
		driver.quit();
		onFinish();
		generateWord.endToWord();
	}
	
	public static WebDriver getDriver()
	{
		return driver;
	}

}
