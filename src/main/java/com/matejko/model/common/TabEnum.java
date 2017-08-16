package com.matejko.model.common;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public enum TabEnum {
    OVERVIEW("overview"),
    RESOURCES("resources"),
    STATION("station"),
    TRADER_OVERVIEW("traderOverview"),
    RESEARCH("research"),
    SHIPYARD("shipyard"),
    DEFENSE("defense"),
    FLEET1("fleet1"),
    GALAXY("galaxy"),
    ALLIANCE("alliance"),
    SHOP("shop");

    private String url;

    TabEnum(final String url) {
        this.url = url;
    }

    public String getUrl() {
        return this.url;
    }
}
