package com.valensmarcos.model;

import java.io.Serializable;
import java.util.Objects;

public class Satellite implements Serializable {
    private long id;
    private String name;
    private long massa;
    private int speed;
    private Planet planet;

    public Satellite() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getMassa() {
        return massa;
    }

    public void setMassa(long massa) {
        this.massa = massa;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet planet) {
        this.planet = planet;
    }

    @Override
    public String toString() {
        return "Satellite{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", massa=" + massa +
                ", speed=" + speed +
                ", planet=" + planet +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Satellite satellite = (Satellite) o;
        return id == satellite.id &&
                massa == satellite.massa &&
                speed == satellite.speed &&
                Objects.equals(name, satellite.name) &&
                Objects.equals(planet, satellite.planet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, massa, speed, planet);
    }
}
