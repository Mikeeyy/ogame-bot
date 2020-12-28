package com.matejko.helper;

import java.util.ArrayList;
import java.util.List;

import com.matejko.model.standard.Planet;

/**
 * Created by Mikołaj Matejko on 16.08.2017 as part of ogame-expander
 */
public class PlanetVisitatorHelper {
    private final List<String> visitedPlanets = new ArrayList<>();

    public void visitNextPlanet(final List<Planet> planets) {
        planets.stream()
                .filter(f -> !visitedPlanets.contains(f.getPosition()))
                .findFirst()
                .ifPresent(f -> {
                    visitedPlanets.add(f.getPosition());
                    f.getWebElement().click();
                });
    }
}
