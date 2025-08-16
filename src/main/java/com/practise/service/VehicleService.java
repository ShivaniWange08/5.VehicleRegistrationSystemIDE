package com.practise.service;

import com.practise.entity.Vehicle;

import java.util.List;

public interface VehicleService {

    String saveVehicle(Vehicle vehicle);

    List<Vehicle> getAllVehicle();

    Vehicle getVehicleById(int id);

    String deleteVehicleById(int id);

    Vehicle updateVehicle(int id, Vehicle newVehicle);

    List<Vehicle> savelistOfvehicle(List<Vehicle> vehicleList);
}
