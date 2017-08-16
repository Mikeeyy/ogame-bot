package com.matejko.model.standard;

import java.util.List;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public class Profile {
    private Materials materials;
    private List<Planet> planets;

    public Profile(final Materials materials, final List<Planet> planets) {
        this.materials = materials;
        this.planets = planets;
    }

    public Materials getMaterials() {
        return materials;
    }

    public void setMaterials(final Materials materials) {
        this.materials = materials;
    }

    public List<Planet> getPlanets() {
        return planets;
    }

    public void setPlanets(final List<Planet> planets) {
        this.planets = planets;
    }
}
