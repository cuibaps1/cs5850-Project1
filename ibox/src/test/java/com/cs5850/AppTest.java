package com.cs5850;

import static org.junit.Assert.*;

import org.junit.Test;

import com.cs5850.App;

public class AppTest {

	App myApp = new App();
	
	@Test
	public void test() {
		assertEquals("sample", myApp.Sample());
		
	}

}
