package com.consulting.qa.Project1;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class JUnitEx {

	@BeforeClass
	public void init() {
		//create a report or similar to be added to
		System.out.println("Before Class");
		
	}
	@Before
	public void setUp() {
		// initialise variables to test etc.
		System.out.println("Before");
	}

	@Test
	public void exampleTest() {
		// Whatever you want to test
		System.out.println("Test");
	}

	@After
	public void tearDown() {
		// could destroy any objects created in Before, send results of individual test
		// to report etc.
		System.out.println("After");
	}
	
	@AfterClass
	public void systemClose() {
		//finalises report and sends it for example, closes/destroys anything initialised in Before Class
		System.out.println("After Class");
	}

}
