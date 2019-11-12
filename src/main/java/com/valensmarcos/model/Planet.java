package com.valensmarcos.model;

import java.util.Objects;

public class Planet {
    private String name;
    private float mass;
    private int habitable;

    public Planet(String name, float mass, int habitable) {
        this.name = name;
        this.mass = mass;
        this.habitable = habitable;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getMass() {
        return mass;
    }

    public void setMass(float mass) {
        this.mass = mass;
    }

    public int getHabitable() {
        return habitable;
    }

    public void setHabitable(int habitable) {
        this.habitable = habitable;
    }

    @Override
    public String toString() {
        return "Planet{" +
                "name='" + name + '\'' +
                ", mass=" + mass +
                ", habitable=" + habitable +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Planet planet = (Planet) o;
        return Float.compare(planet.mass, mass) == 0 &&
                habitable == planet.habitable &&
                Objects.equals(name, planet.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, mass, habitable);
    }
}
