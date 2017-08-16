package com.matejko.model.common;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public enum MaterialsEnum {
    METAL("resources_metal"),
    CRYSTAL("resources_crystal"),
    DEUTERIUM("resources_deuterium"),
    DARK_MATTER("resources_darkmatter"),
    ENERGY("resources_energy");

    private String resource;

    MaterialsEnum(final String resource) {
        this.resource = resource;
    }

    public String getResource() {
        return resource;
    }
}
