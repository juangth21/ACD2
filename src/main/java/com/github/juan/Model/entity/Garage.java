package com.github.juan.Model.entity;

import java.util.List;
import java.util.Objects;

public class Garage {
    private int id;
    private String location;
    private List<Cars> cars;



    public Garage(int id, String location, List<Cars> cars) {
        this.id = id;
        this.location = location;
        this.cars = cars;

    }
    public Garage(String location) {
        this.location = location;
    }

    public Garage() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Cars> getCars() {
        return cars;
    }

    public void setCars(List<Cars> cars) {
        this.cars = cars;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Garage garage = (Garage) o;
        return id == garage.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Garage{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", cars=" + cars +
                '}';
    }
}
