package com.matejko.service.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.matejko.model.common.OperatingSystem;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public class ChromeOgameWebConnector extends BaseOgameWebConnector {

	private final OperatingSystem system;

	ChromeOgameWebConnector(final String mainUrl, final OperatingSystem system) {
		super(mainUrl);
		this.system = system;
	}

	@Override
	protected WebDriver webDriver() {
		System.setProperty("webdriver.chrome.driver", driver());
		return new ChromeDriver();
	}

	private String driver() {
		return "src" + system.getSlash() + "main" + system.getSlash() + "resources" + system.getSlash() + "drivers" + system.getSlash()
				+ system.getDriver();
	}
}
