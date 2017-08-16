package com.matejko.service.interfaces;

import com.matejko.model.common.BuildingEnum;
import com.matejko.model.standard.Building;
import com.matejko.model.standard.DecryptedUser;
import com.matejko.model.standard.Planet;
import com.matejko.model.standard.Profile;

import java.util.List;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public interface OgameWebConnector extends WebConnector {
    void logIn(DecryptedUser user);

    Profile collectProfileData();

    List<Building> collectBuildings();

    List<Planet> collectPlanets();

    boolean build(BuildingEnum buildingEnum);
}
