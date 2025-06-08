package com.example.Module22.model;

import java.util.Objects;

public class Country {

    private String name;
    private int population;

    public Country() {
    }

    public Country(String name, int population) {
        this.name = name;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name  +
        ", population=" + population +
                '}';
    }

}
