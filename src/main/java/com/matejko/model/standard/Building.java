package com.matejko.model.standard;

import com.matejko.model.common.BuildingEnum;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public class Building {
    private final BuildingEnum buildingEnum;
    private final Long level;

    public Building(final BuildingEnum buildingEnum, final Long level) {
        this.buildingEnum = buildingEnum;
        this.level = level;
    }

    public BuildingEnum getBuildingEnum() {
        return buildingEnum;
    }

    public Long getLevel() {
        return level;
    }
}
