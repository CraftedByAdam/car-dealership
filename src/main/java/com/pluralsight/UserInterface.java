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
                case "1" -> processGetByPriceRequest(scanner);
                case "2" -> processGetByMakeModelRequest(scanner);
                case "3" -> processGetByYearRequest(scanner);
                case "4" -> processGetByColorRequest(scanner);
                case "5" -> processGetByMileRequest(scanner);
                case "6" -> processGetByVehicleTypeRequest(scanner);
                case "7" -> processGetByAllVehicleRequest();
                case "8" -> processAddRequest(scanner);
                case "9" -> processRemoveRequest(scanner);
                case "99" -> running = false;
            }
        }
    }

    public void processGetByPriceRequest(Scanner scanner) {
        System.out.println("Enter minimum price:");
        double minimumPrice = scanner.nextDouble();
        System.out.println("Enter maximum price:");
        double maximumPrice = scanner.nextDouble();
        scanner.nextLine();

        List<Vehicle> match = dealership.getVehicleByPrice(minimumPrice, maximumPrice);
        displayVehicles(match);
    }

    public void processGetByMakeModelRequest(Scanner scanner) {
        System.out.println("Enter make:");
        String make = scanner.nextLine();
        System.out.println("Enter model:");
        String model = scanner.nextLine();

        List<Vehicle> match = dealership.getVehicleByMakeModel(make, model);
        displayVehicles(match);
    }

    public void processGetByYearRequest(Scanner scanner) {
        System.out.println("Enter minimum year:");
        int minimumYear = scanner.nextInt();
        System.out.println("Enter maximum year:");
        int maximumYear = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> match = dealership.getVehicleByYear(minimumYear, maximumYear);
        displayVehicles(match);
    }

    public void processGetByColorRequest(Scanner scanner) {
        System.out.println("Enter color:");
        String color = scanner.nextLine();

        List<Vehicle> match = dealership.getVehicleByColor(color);
        displayVehicles(match);
    }

    public void processGetByMileRequest(Scanner scanner) {
        System.out.println("Enter minimum miles:");
        int minimumMiles = scanner.nextInt();
        System.out.println("Enter maximum miles:");
        int maximumMiles = scanner.nextInt();
        scanner.nextLine();

        List<Vehicle> match = dealership.getVehicleByMiles(minimumMiles, maximumMiles);
        displayVehicles(match);
    }

    public void processGetByVehicleTypeRequest(Scanner scanner) {
        System.out.println("Enter Type:");
        String type = scanner.nextLine();

        List<Vehicle> match = dealership.getVehicleByType(type);
        displayVehicles(match);
    }

    public void processGetByAllVehicleRequest() {
        List<Vehicle> vehicles = dealership.getAllVehicles();
        displayVehicles(vehicles);
    }

    public void processAddRequest(Scanner scanner) {
        System.out.println("Enter vin:");
        int vin = scanner.nextInt();
        System.out.println("Enter year:");
        int year = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter make:");
        String make = scanner.nextLine();
        System.out.println("Enter model:");
        String model = scanner.nextLine();
        System.out.println("Enter type:");
        String type = scanner.nextLine();
        System.out.println("Enter color:");
        String color = scanner.nextLine();
        System.out.println("Enter odometer:");
        int odometer = scanner.nextInt();
        System.out.println("Enter price:");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Vehicle vehicle = new Vehicle(vin, year, make, model, type, color, odometer, price);
        dealership.addVehicle(vehicle);

        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(this.dealership);
    }

    public void processRemoveRequest(Scanner scanner) {
        System.out.println("Enter vin:");
        int vin = scanner.nextInt();
        scanner.nextLine();

        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                dealership.removeVehicle(vehicle);
                break;
            }
        }
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        dealershipFileManager.saveDealership(this.dealership);
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
