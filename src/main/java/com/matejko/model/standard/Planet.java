package com.matejko.model.standard;

import org.openqa.selenium.WebElement;

/**
 * Created by Mikołaj Matejko on 10.08.2017 as part of ogame-expander
 */
public class Planet {
    private WebElement webElement;
    private String name;
    private String position;

    public Planet(final WebElement webElement, final String name, final String position) {
        this.webElement = webElement;
        this.name = name;
        this.position = position;
    }

    public WebElement getWebElement() {
        return webElement;
    }

    public void setWebElement(final WebElement webElement) {
        this.webElement = webElement;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(final String position) {
        this.position = position;
    }
}
