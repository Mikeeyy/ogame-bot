package com.matejko.model.standard;

/**
 * Created by Mikołaj Matejko on 29.07.2017 as part of ogame-expander
 */
public class Materials {
    private Long metal;
    private Long crystal;
    private Long deuterium;
    private Long darkMatter;
    private Long energy;

    public Materials(final Long metal, final Long crystal, final Long deuterium, final Long darkMatter, final Long energy) {
        this.metal = metal;
        this.crystal = crystal;
        this.deuterium = deuterium;
        this.darkMatter = darkMatter;
        this.energy = energy;
    }

    public Long getMetal() {
        return metal;
    }

    public void setMetal(final Long metal) {
        this.metal = metal;
    }

    public Long getCrystal() {
        return crystal;
    }

    public void setCrystal(final Long crystal) {
        this.crystal = crystal;
    }

    public Long getDeuterium() {
        return deuterium;
    }

    public void setDeuterium(final Long deuterium) {
        this.deuterium = deuterium;
    }

    public Long getDarkMatter() {
        return darkMatter;
    }

    public void setDarkMatter(final Long darkMatter) {
        this.darkMatter = darkMatter;
    }

    public Long getEnergy() {
        return energy;
    }

    public void setEnergy(final Long energy) {
        this.energy = energy;
    }
}
