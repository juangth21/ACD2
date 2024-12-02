package com.github.juan.Model.entity;

import java.util.Objects;

public class Cars {
    private int id;
    private String model;
    private int tuition;

    public Cars(int id, String model, int tuition) {
        this.id = id;
        this.model = model;
        this.tuition = tuition;
    }

    public Cars(String model, int tuition) {
        this.model = model;
        this.tuition = tuition;
    }

    public Cars() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTuition() {
        return tuition;
    }

    public void setTuition(int tuition) {
        this.tuition = tuition;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return id == cars.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Species{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", tuition=" + tuition +
                '}';
    }
}
