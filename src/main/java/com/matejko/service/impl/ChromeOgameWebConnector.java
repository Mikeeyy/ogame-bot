package com.matejko.service.impl;

import org.openqa.selenium.WebDriver;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public class ChromeOgameWebConnector extends BaseOgameWebConnector {

	public ChromeOgameWebConnector(final String mainUrl, final WebDriver webDriver) {
		super(webDriver, mainUrl);
	}
}
