package com.pluralsight;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    Dealership dealership;

    public UserInterface () {
    }

    public void display(Scanner scanner) {
        init();
        boolean running = true;

        while (running) {
            System.out.println("1. Get vehicle by price");
            System.out.println("2. Get vehicle by make and model");
            System.out.println("3. Get vehicle by year");
            System.out.println("4. Get vehicle by color");
            System.out.println("5. Get vehicle by mileage");
            System.out.println("6. Get vehicle by type");
            System.out.println("7. Get all vehicles");
            System.out.println("8. Add vehicle");
            System.out.println("9. Remove vehicle");
            System.out.println("99. Quit");
            System.out.println("Enter your choice: ");


            switch (scanner.nextLine()) {
                case "1" -> processGetByPriceRequest();
                case "2" -> processGetByMakeModelRequest();
                case "3" -> processGetByYearRequest();
                case "4" -> processGetByColorRequest();
                case "5" -> processGetByMileRequest();
                case "6" -> processGetByVehicleTypeRequest();
                case "7" -> processGetByAllVehicleRequest();
                case "8" -> processAddRequest();
                case "9" -> processRemoveRequest();
                case "99" -> running = false;
            }
        }
    }

    public void processGetByPriceRequest() {
    }

    public void processGetByMakeModelRequest() {
    }

    public void processGetByYearRequest() {
    }

    public void processGetByColorRequest() {
    }

    public void processGetByMileRequest() {
    }

    public void processGetByVehicleTypeRequest() {
    }

    public void processGetByAllVehicleRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddRequest() {
    }

    public void processRemoveRequest() {
    }


    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    private void displayVehicles(List<Vehicle> vehicles) {
        for (Vehicle vehicle : vehicles) {
            System.out.printf("%d %d %s %s %s %s %d %.2f\n", vehicle.getVin(),  vehicle.getYear(), vehicle.getMake(),
                    vehicle.getModel(), vehicle.getVehicleType(), vehicle.getColor(), vehicle.getOdometer(), vehicle.getPrice());

        }
    }

}
