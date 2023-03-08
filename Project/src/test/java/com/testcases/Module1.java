package com.testcases;

import org.testng.annotations.Test;

import com.coreengine.BaseClass;

public class Module1 extends BaseClass {

	@Test
	public void verifyTitle() {
		String title = getDriver().getTitle();
		System.out.println(title);

	}

	@Test
	public void verifyTitle1() {
		String title = getDriver().getTitle();
		System.out.println(title);

	}

	@Test
	public void verifyTitle2() {
		String title = getDriver().getTitle();
		System.out.println(title);

	}

	@Test
	public void verifyTitle5() {
		String title = getDriver().getTitle();
		System.out.println(title);

	}
}
