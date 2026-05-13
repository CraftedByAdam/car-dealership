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
        List<Vehicle> vehiclesByPrice = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getPrice() >= min && vehicle.getPrice() <= max) {
                vehiclesByPrice.add(vehicle);
            }
        }
        return vehiclesByPrice;
    }

    public List<Vehicle> getVehicleByMakeModel(String make, String model) {
        List<Vehicle> vehiclesByMakeModel = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)) {
                vehiclesByMakeModel.add(vehicle);
            }
        }
        return vehiclesByMakeModel;
    }

    public List<Vehicle> getVehicleByYear (double min, double max) {
        List<Vehicle> vehiclesByYear = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getYear() >= min && vehicle.getYear() <= max) {
                vehiclesByYear.add(vehicle);
            }
        }
        return vehiclesByYear;
    }

    public List<Vehicle> getVehicleByColor (String color) {
        List<Vehicle> vehiclesByColor = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getColor().equals(color)) {
                vehiclesByColor.add(vehicle);
            }
        }
        return vehiclesByColor;
    }

    public List<Vehicle> getVehicleByMiles (double min, double max) {
        List<Vehicle> vehiclesByMiles = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getOdometer() >= min && vehicle.getOdometer() <= max) {
                vehiclesByMiles.add(vehicle);
            }
        }
        return vehiclesByMiles;
    }

    public List<Vehicle> getVehicleByType (String type) {
        List<Vehicle> vehiclesByType = new ArrayList<>();
        for (Vehicle vehicle : inventory) {
            if (vehicle.getVehicleType().equals(type)) {
                vehiclesByType.add(vehicle);
            }
        }
        return vehiclesByType;
    }

    public List<Vehicle> getAllVehicles() {
        return this.inventory;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }
    public void removeVehicle(Vehicle vehicle) {
        inventory.remove(vehicle);
    }

}
