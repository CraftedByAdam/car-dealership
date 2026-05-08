package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Dealership {
    private String name;
    private String address;
    private String phone;

    private ArrayList<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //return type so I can take/reurn something from the list
    public List<Vehicle> getVehicleByPrice (double min, double max) {
        return null;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model) {
        return null;
    }

    public List<Vehicle> getVehicleByYear (double min, double max) {
        return null;
    }

    public List<Vehicle> getVehicleByColor (String color) {
        return null;
    }

    public List<Vehicle> getVehicleByMiles (double min, double max) {
        return null;
    }

    public List<Vehicle> getVehicleByType (String type) {
        return null;
    }

    public List<Vehicle> getAllVehicles() {
        return null;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
    }

}
