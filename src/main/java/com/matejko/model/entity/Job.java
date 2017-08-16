package com.matejko.model.entity;

import com.matejko.model.common.BuildingEnum;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public class Job {
    private Long orderId;
    private BuildingEnum buildingEnum;
    private Long level;

    public Job(final Long orderId, final BuildingEnum buildingEnum, final Long level) {
        this.orderId = orderId;
        this.buildingEnum = buildingEnum;
        this.level = level;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(final Long orderId) {
        this.orderId = orderId;
    }

    public BuildingEnum getBuildingEnum() {
        return buildingEnum;
    }

    public void setBuildingEnum(final BuildingEnum buildingEnum) {
        this.buildingEnum = buildingEnum;
    }

    public Long getLevel() {
        return level;
    }

    public void setLevel(final Long level) {
        this.level = level;
    }
}
