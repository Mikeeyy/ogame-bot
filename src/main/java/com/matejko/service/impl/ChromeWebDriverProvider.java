package com.matejko.service.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.matejko.model.common.OperatingSystem;
import com.matejko.service.interfaces.WebDriverProvider;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ChromeWebDriverProvider implements WebDriverProvider {

	private final OperatingSystem system;

	@Override
	public WebDriver webDriver() {
		System.setProperty("webdriver.chrome.driver", driver());
		return new ChromeDriver();
	}

	private String driver() {
		return "src" + system.getSlash() + "main" + system.getSlash() + "resources" + system.getSlash() + "drivers" + system.getSlash()
				+ system.getDriver();
	}
}
