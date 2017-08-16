package com.matejko.service.impl;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public class ChromeOgameWebConnector extends BaseOgameWebConnector {
    ChromeOgameWebConnector(final String mainUrl) {
        super(mainUrl);
    }

    @Override
    protected WebDriver webDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\drivers\\chromedriver.exe");
        return new ChromeDriver();
    }
}
