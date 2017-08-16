package com.matejko.model.entity;

import com.matejko.model.common.BuildingEnum;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

/**
 * Created by Mikołaj Matejko on 01.08.2017 as part of ogame-expander
 */
@Entity
public class JobHistory extends BaseEntity {
    @ManyToOne
    private User user;

    @Enumerated(EnumType.STRING)
    private BuildingEnum buildingEnum;
    private Long level;
    private String planet;

    public User getUser() {
        return user;
    }

    public void setUser(final User user) {
        this.user = user;
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

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(final String planet) {
        this.planet = planet;
    }
}
