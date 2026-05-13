package com.pluralsight;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class DealershipFileManager {

    public Dealership getDealership() {

        //declared outside to be used anywhere
        String fileName = "dealership.csv";
        Dealership dealership = null;

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            //reads first line(name,address,phone)
            line = br.readLine();
            String[] data = line.split("\\|");
            String name = data[0];
            String address = data[1];
            String phone = data[2];
            //creat object
            dealership = new Dealership(name, address, phone);

            while ((line = br.readLine()) != null) {
                //loops though vehicle list
                Vehicle vehicle = getVehicle(line);
                //adds the vehicles
                dealership.addVehicle(vehicle);
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return dealership;
    }

    private static Vehicle getVehicle(String line) {
        String[] data = line.split("\\|");
        int vin = Integer.parseInt(data[0]);
        int year = Integer.parseInt(data[1]);
        String make = data[2];
        String model = data[3];
        String vehicleType = data[4];
        String color = data[5];
        int odometer = Integer.parseInt(data[6]);
        double price = Double.parseDouble(data[7]);

        Vehicle vehicle = new Vehicle(vin, year, make, model, vehicleType, color, odometer, price);
        return vehicle;
    }

    public void saveDealership(Dealership dealership) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("dealership.csv"))) {
            bw.write(dealership.getName() + "|" + dealership.getAddress() + "|" + dealership.getPhone());
            bw.newLine();
            for (Vehicle vehicle : dealership.getAllVehicles()) {
                bw.write(vehicle.getVin() + "|" + vehicle.getYear() + "|" + vehicle.getMake() + "|" +
                        vehicle.getModel() + "|" + vehicle.getVehicleType() + "|" +  vehicle.getColor() + "|" +
                        vehicle.getOdometer() + "|" + vehicle.getPrice());
                bw.newLine();
            }
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}