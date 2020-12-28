package com.matejko.model.standard;

import org.openqa.selenium.WebElement;

import lombok.Value;

/**
 * Created by Mikołaj Matejko on 10.08.2017 as part of ogame-expander
 */
@Value
public class Planet {
	WebElement webElement;
	String name;
	String position;
}
