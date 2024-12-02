package com.github.juan.Test;

import com.github.juan.Model.dao.GarageDAO;
import com.github.juan.Model.entity.Garage;


public class testUpdateGarage {
    public static void main(String[] args) {
        Garage g = new Garage();
        g.setId(122);
        g.setLocation("Updated");
        GarageDAO garageDAO = new GarageDAO();
        Garage updatedGarage = garageDAO.update(g);
        if (updatedGarage != null) {
            System.out.println("Garaje actualizado:");
            System.out.println("Location: " + updatedGarage.getLocation());
        } else {
            System.out.println("Error en la actualizacion");
        }
    }
}
