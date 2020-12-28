package com.matejko.model.standard;

import com.matejko.model.common.BuildingEnum;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
@RequiredArgsConstructor
@Getter
public class Building {
    private final BuildingEnum buildingEnum;
    private final Long level;
}
