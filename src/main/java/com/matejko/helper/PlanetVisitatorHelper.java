package com.matejko.helper;

import com.matejko.model.standard.Planet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mikołaj Matejko on 16.08.2017 as part of ogame-expander
 */
public class PlanetVisitatorHelper {
    private List<String> visitedPlanets;

    public PlanetVisitatorHelper() {
        this.visitedPlanets = new ArrayList<>();
    }

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
