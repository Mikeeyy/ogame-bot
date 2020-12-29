package com.matejko.model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum OperatingSystem {
	WINDOWS("\\", "windows\\chromedriver.exe"),
	MAC("/", "mac/chromedriver"),
	LINUX("/", "linux/chromedriver");

	private final String slash;
	private final String driver;
}
