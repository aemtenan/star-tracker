package com.example.startracker.model;

import jakarta.persistence.*;

@Entity
@Table(name = "stars")
public class Star {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String name;

    private String constellation;

    private String distanceInLightYears;

    private String temperatureInKelvin;

    public Star(){}

    public Star(String name, String constellation, String distanceInLightYears, String temperatureInKelvin) {
        this.name = name;
        this.constellation = constellation;
        this.distanceInLightYears = distanceInLightYears;
        this.temperatureInKelvin = temperatureInKelvin;
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

    public String getConstellation() {
        return constellation;
    }

    public void setConstellation(String constellation) {
        this.constellation = constellation;
    }

    public String getDistanceInLightYears() {
        return distanceInLightYears;
    }

    public void setDistanceInLightYears(String distanceInLightYears) {
        this.distanceInLightYears = distanceInLightYears;
    }

    public String getTemperatureInKelvin() {
        return temperatureInKelvin;
    }

    public void setTemperatureInKelvin(String temperatureInKelvin) {
        this.temperatureInKelvin = temperatureInKelvin;
    }
}
