package com.matejko.model.common;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
@RequiredArgsConstructor
@Getter
public enum TabEnum {
    OVERVIEW("overview"),
    RESOURCES("supplies"),
    STATION("facilities"),
    TRADER_OVERVIEW("traderOverview"),
    RESEARCH("research"),
    SHIPYARD("shipyard"),
    DEFENSE("defenses"),
    FLEET1("fleetdispatch"),
    GALAXY("galaxy"),
    ALLIANCE("alliance"),
    SHOP("shop");

    private final String url;
}
