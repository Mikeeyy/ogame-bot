package com.matejko.model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
@RequiredArgsConstructor
@Getter
public enum MaterialsEnum {
    METAL("resources_metal"),
    CRYSTAL("resources_crystal"),
    DEUTERIUM("resources_deuterium"),
    DARK_MATTER("resources_darkmatter"),
    ENERGY("resources_energy");

    private final String resource;
}
