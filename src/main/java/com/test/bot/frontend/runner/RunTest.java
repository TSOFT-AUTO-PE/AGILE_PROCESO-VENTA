package com.test.bot.frontend.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.Test;


@CucumberOptions(
		features={"src//main//resources//features"},
		glue={"com.tsoft.bot.frontend.steps.movistar","com.tsoft.bot.frontend.helpers"},
		plugin = {"pretty", "html:target/cucumber"},
		tags = {"@MovistarFija"},
		strict =  true,
		monochrome = true
	)

@Test
public class RunTest extends AbstractTestNGCucumberTests{

}
