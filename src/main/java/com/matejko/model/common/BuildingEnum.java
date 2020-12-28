package com.matejko.model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
@RequiredArgsConstructor
@Getter
public enum BuildingEnum {
    METAL_MINE(TabEnum.RESOURCES, "button1", "//*[@id=\"building\"]/li[@id='button1']//span[@class='level']"),
    CRYSTAL_MINE(TabEnum.RESOURCES, "button2", "//*[@id=\"building\"]/li[@id='button2']//span[@class='level']"),
    DEUTERIUM_MINE(TabEnum.RESOURCES, "button3", "//*[@id=\"building\"]/li[@id='button3']//span[@class='level']"),
    SOLAR_PLANT(TabEnum.RESOURCES, "button4", "//*[@id=\"building\"]/li[@id='button4']//span[@class='level']"),
    FUSION_PLANT(TabEnum.RESOURCES, "button5", "//*[@id=\"building\"]/li[@id='button5']//span[@class='level']"),
    METAL_DEPOT(TabEnum.RESOURCES, "button7", "//*[@id=\"storage\"]/li[@id='button7']//span[@class='level']"),
    CRYSTAL_DEPOT(TabEnum.RESOURCES, "button8", "//*[@id=\"storage\"]/li[@id='button8']//span[@class='level']"),
    DEUTERIUM_DEPOT(TabEnum.RESOURCES, "button9", "//*[@id=\"storage\"]/li[@id='button9']//span[@class='level']"),
    ROBOTICS_FACTORY(TabEnum.STATION, "button0", "//*[@id=\"stationbuilding\"]/li[@id='button0']//a[contains(@id,'details')]"),
    SHIPYARD(TabEnum.STATION, "button1", "//*[@id=\"stationbuilding\"]/li[@id='button1']//a[contains(@id,'details')]"),
    LABORATORY(TabEnum.STATION, "button2", "//*[@id=\"stationbuilding\"]/li[@id='button2']//a[contains(@id,'details')]"),
    ALLIED_DEPOSIT(TabEnum.STATION, "button3", "//*[@id=\"stationbuilding\"]/li[@id='button3']//a[contains(@id,'details')]"),
    ROCKETS_SILO(TabEnum.STATION, "button4", "//*[@id=\"stationbuilding\"]/li[@id='button4']//a[contains(@id,'details')]"),
    NANITS_FACTORY(TabEnum.STATION, "button5", "//*[@id=\"stationbuilding\"]/li[@id='button5']//a[contains(@id,'details')]"),
    TERRAFORMER(TabEnum.STATION, "button6", "//*[@id=\"stationbuilding\"]/li[@id='button6']//a[contains(@id,'details')]"),
    COSMIC_DOCK(TabEnum.STATION, "button7", "//*[@id=\"stationbuilding\"]/li[@id='button7']//a[contains(@id,'details')]"),
    ENERGETIC_TECH(TabEnum.RESEARCH, "details113", "//a[@id='details113']"),
    LASER_TECH(TabEnum.RESEARCH, "details120", "//a[@id='details120']"),
    JON_TECH(TabEnum.RESEARCH, "details121", "//a[@id='details121']"),
    HYPERSPACE_TECH(TabEnum.RESEARCH, "details114", "//a[@id='details114']"),
    PLASMA_TECH(TabEnum.RESEARCH, "details122", "//a[@id='details122']"),
    FUEL_ENGINE(TabEnum.RESEARCH, "details115", "//a[@id='details115']"),
    IMPULSE_ENGINE(TabEnum.RESEARCH, "details117", "//a[@id='details117']"),
    HYPERSPACE_ENGINE(TabEnum.RESEARCH, "details118", "//a[@id='details118']"),
    SPY_TECH(TabEnum.RESEARCH, "details106", "//a[@id='details106']"),
    COMPUTER_TECH(TabEnum.RESEARCH, "details108", "//a[@id='details108']"),
    ASTRO_TECH(TabEnum.RESEARCH, "details124", "//a[@id='details124']"),
    INTERGALACTIC_WEB_TECH(TabEnum.RESEARCH, "details123", "//a[@id='details123']"),
    GRAVITY_TECH(TabEnum.RESEARCH, "details199", "//a[@id='details199']"),
    COMBAT_TECH(TabEnum.RESEARCH, "details109", "//a[@id='details109']"),
    DEFENSE_TECH(TabEnum.RESEARCH, "details110", "//a[@id='details110']"),
    ARMOR_TECH(TabEnum.RESEARCH, "details111", "//a[@id='details111']");

    private final TabEnum type;
    private final String id;
    private final String path;
}
