package com.matejko.model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
@RequiredArgsConstructor
@Getter
public enum BuildingEnum {
    METAL_MINE(TabEnum.RESOURCES, "button1", "//*[@id=\"producers\"]/li[contains(@class,'metalMine')]//span[@class='level']"),
    CRYSTAL_MINE(TabEnum.RESOURCES, "button2", "//*[@id=\"producers\"]/li[contains(@class,'crystalMine')]//span[@class='level']"),
    DEUTERIUM_MINE(TabEnum.RESOURCES, "button3", "//*[@id=\"producers\"]/li[contains(@class,'deuteriumSynthesizer')]//span[@class='level']"),
    SOLAR_PLANT(TabEnum.RESOURCES, "button4", "//*[@id=\"producers\"]/li[contains(@class,'solarPlant')]//span[@class='level']"),
    FUSION_PLANT(TabEnum.RESOURCES, "button5", "//*[@id=\"producers\"]/li[contains(@class,'fusionPlant')]//span[@class='level']"),

    METAL_DEPOT(TabEnum.RESOURCES, "button7", "//*[@id=\"producers\"]/li[contains(@class,'metalStorage')]//span[@class='level']"),
    CRYSTAL_DEPOT(TabEnum.RESOURCES, "button8", "//*[@id=\"producers\"]/li[contains(@class,'crystalStorage')]//span[@class='level']"),
    DEUTERIUM_DEPOT(TabEnum.RESOURCES, "button9", "//*[@id=\"producers\"]/li[contains(@class,'deuteriumStorage')]//span[@class='level']"),

    ROBOTICS_FACTORY(TabEnum.STATION, "button0", "//*[@id=\"technologies\"]//li[contains(@class,'roboticsFactory')]//span[@class='level']"),
    SHIPYARD(TabEnum.STATION, "button1", "//*[@id=\"technologies\"]//li[contains(@class,'shipyard')]//span[@class='level']"),
    LABORATORY(TabEnum.STATION, "button2", "//*[@id=\"technologies\"]//li[contains(@class,'researchLaboratory')]//span[@class='level']"),
    ALLIED_DEPOSIT(TabEnum.STATION, "button3", "//*[@id=\"technologies\"]//li[contains(@class,'allianceDepot')]//span[@class='level']"),
    ROCKETS_SILO(TabEnum.STATION, "button4", "//*[@id=\"technologies\"]//li[contains(@class,'missileSilo')]//span[@class='level']"),
    NANITS_FACTORY(TabEnum.STATION, "button5", "//*[@id=\"technologies\"]//li[contains(@class,'naniteFactory')]//span[@class='level']"),
    TERRAFORMER(TabEnum.STATION, "button6", "//*[@id=\"technologies\"]//li[contains(@class,'terraformer')]//span[@class='level']"),
    COSMIC_DOCK(TabEnum.STATION, "button7", "//*[@id=\"technologies\"]//li[contains(@class,'repairDock')]//span[@class='level']"),
    
    ENERGETIC_TECH(TabEnum.RESEARCH, "details113", "//*[@id=\"technologies_basic\"]//li[contains(@class,'energyTechnology')]//span[@class='level']"),
    LASER_TECH(TabEnum.RESEARCH, "details120", "//*[@id=\"technologies_basic\"]//li[contains(@class,'laserTechnology')]//span[@class='level']"),
    JON_TECH(TabEnum.RESEARCH, "details121", "//*[@id=\"technologies_basic\"]//li[contains(@class,'ionTechnology')]//span[@class='level']"),
    HYPERSPACE_TECH(TabEnum.RESEARCH, "details114", "//*[@id=\"technologies_basic\"]//li[contains(@class,'hyperspaceTechnology')]//span[@class='level']"),
    PLASMA_TECH(TabEnum.RESEARCH, "details122", "//*[@id=\"technologies_basic\"]//li[contains(@class,'plasmaTechnology')]//span[@class='level']"),

    FUEL_ENGINE(TabEnum.RESEARCH, "details115", "//*[@id=\"technologies_drive\"]//li[contains(@class,'combustionDriveTechnology')]//span[@class='level']"),
    IMPULSE_ENGINE(TabEnum.RESEARCH, "details117", "//*[@id=\"technologies_drive\"]//li[contains(@class,'impulseDriveTechnology')]//span[@class='level']"),
    HYPERSPACE_ENGINE(TabEnum.RESEARCH, "details118", "//*[@id=\"technologies_drive\"]//li[contains(@class,'hyperspaceDriveTechnology')]//span[@class='level']"),

    SPY_TECH(TabEnum.RESEARCH, "details106", "//*[@id=\"technologies_advanced\"]//li[contains(@class,'espionageTechnology')]//span[@class='level']"),
    COMPUTER_TECH(TabEnum.RESEARCH, "details108", "//*[@id=\"technologies_advanced\"]//li[contains(@class,'computerTechnology')]//span[@class='level']"),
    ASTRO_TECH(TabEnum.RESEARCH, "details124", "//*[@id=\"technologies_advanced\"]//li[contains(@class,'astrophysicsTechnology')]//span[@class='level']"),
    INTERGALACTIC_WEB_TECH(TabEnum.RESEARCH, "details123", "//*[@id=\"technologies_advanced\"]//li[contains(@class,'researchNetworkTechnology')]//span[@class='level']"),
    GRAVITY_TECH(TabEnum.RESEARCH, "details199", "//*[@id=\"technologies_advanced\"]//li[contains(@class,'gravitonTechnology')]//span[@class='level']"),

    COMBAT_TECH(TabEnum.RESEARCH, "details109", "//*[@id=\"technologies_combat\"]//li[contains(@class,'weaponsTechnology')]//span[@class='level']"),
    DEFENSE_TECH(TabEnum.RESEARCH, "details110", "//*[@id=\"technologies_combat\"]//li[contains(@class,'shieldingTechnology')]//span[@class='level']"),
    ARMOR_TECH(TabEnum.RESEARCH, "details111", "//*[@id=\"technologies_combat\"]//li[contains(@class,'armorTechnology')]//span[@class='level']");

    private final TabEnum type;
    private final String id;
    private final String path;
}
