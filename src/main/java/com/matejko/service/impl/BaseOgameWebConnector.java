package com.matejko.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.matejko.model.common.BuildingEnum;
import com.matejko.model.common.MaterialsEnum;
import com.matejko.model.common.TabEnum;
import com.matejko.model.standard.Building;
import com.matejko.model.standard.DecryptedUser;
import com.matejko.model.standard.Materials;
import com.matejko.model.standard.Planet;
import com.matejko.model.standard.Profile;
import com.matejko.service.interfaces.OgameWebConnector;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public abstract class BaseOgameWebConnector implements OgameWebConnector {
    private final WebDriver webDriver;
    private final WebActions webActions;

    public BaseOgameWebConnector(final WebDriver webDriver, final String mainUrl) {
        this.webDriver = webDriver;
        this.webActions = new WebActions(webDriver, mainUrl);
    }

    @Override
    public void logIn(final DecryptedUser user) {
        webActions.goToHomePage();
        webActions.closePopup("openX_interstitial");
        webActions.sleep(2000);
        webActions.clickSpan("Login");
        webActions.setTextBox("email", user.getUsername());
        webActions.setTextBox("password", user.getPassword());
        webActions.submit("loginForm");
        webActions.sleep(2000);
        webActions.clickSpan("Ostatnia gra");
        webActions.switchWindows();
    }

    @Override
    public Profile collectProfileData() {
        Materials materials = collectMaterials();
        List<Planet> planets = collectPlanets();

        return new Profile(materials, planets);
    }

    @Override
    public List<Building> collectBuildings() {
        List<Building> buildings = new ArrayList<>();
        buildings.addAll(collectResourcesData());
        buildings.addAll(collectStationsData());
        buildings.addAll(collectResearchData());
        return buildings;
    }

    @Override
    public List<Planet> collectPlanets() {
        webActions.sleep(1000);

        return webDriver.findElements(By.xpath("//div[@id='planetList']/*"))
                .stream()
                .map(f -> new Planet(f, f.getText().split("\n")[0], f.getText().split("\n")[1]))
                .collect(Collectors.toList());
    }

    @Override
    public boolean build(final BuildingEnum buildingEnum) {
        webActions.goToTab(buildingEnum.getType());

        webActions.clickButton(buildingEnum.getPath());
        webActions.sleep(5000);

        final var clicked = webActions.clickBuildButton("//*[@class='content']//*[@class='build-it_wrap']/button[@class='upgrade']");

        webActions.sleep(1500);

        return clicked;
    }

    @Override
    public void close() {
        webDriver.quit();
    }

    private Materials collectMaterials() {
        webActions.sleep(2500);

        Long metal = material(MaterialsEnum.METAL);
        Long crystal = material(MaterialsEnum.CRYSTAL);
        Long deuterium = material(MaterialsEnum.DEUTERIUM);
        Long darkMatter = material(MaterialsEnum.DARK_MATTER);
        Long energy = material(MaterialsEnum.ENERGY);

        return new Materials(metal, crystal, deuterium, darkMatter, energy);
    }

    private Long material(final MaterialsEnum metal) {
        return Long.valueOf(webDriver.findElement(By.xpath(String.format("//span[@id='%s']", metal.getResource())))
                .getText()
                .replace(".", ""));
    }

    private List<? extends Building> collectResourcesData() {
        return collectWebData(TabEnum.RESOURCES);
    }

    private List<? extends Building> collectStationsData() {
        return collectWebData(TabEnum.STATION);
    }

    private List<? extends Building> collectResearchData() {
        return collectWebData(TabEnum.RESEARCH);
    }

    private List<Building> collectWebData(TabEnum tab) {
        webActions.sleep(1000);
        webActions.goToTab(tab);

        return Arrays.stream(BuildingEnum.values())
                .filter(f -> Objects.equals(tab, f.getType()))
                .map(f -> new Building(f, Long.valueOf(preservePremiumAccountLevels(webDriver.findElement(By.xpath(f.getPath()))
                        .getText()
                        .trim()))))
                .collect(Collectors.toList());
    }

    private String preservePremiumAccountLevels(final String str) {
        if (!str.contains("\n"))
            return str;

        return str.split("\n")[1];
    }

    public WebDriver getWebDriver() {
        return webDriver;
    }
}
