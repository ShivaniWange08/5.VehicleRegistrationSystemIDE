package com.practise.serviceimpl;

import com.practise.entity.Vehicle;
import com.practise.repository.VehicleRepository;
import com.practise.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleServiceimpl implements VehicleService {

    @Autowired
   private VehicleRepository vehicleRepository;

    @Override
    public String saveVehicle(Vehicle vehicle) {
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return "vehicle saved";
    }

    @Override
    public List<Vehicle> getAllVehicle() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        return vehicleList;
    }

    @Override
    public Vehicle getVehicleById(int id) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Vehicle with id not found" +id));
        return vehicle;
    }

    @Override
    public String deleteVehicleById(int id) {
        vehicleRepository.deleteById(id);
        return "Vehicle Deleted";
    }

    @Override
    public Vehicle updateVehicle(int id, Vehicle newVehicle) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(()-> new NullPointerException("Vehicle with id not found in database" +id));
        System.err.println("old vehicle in database " +vehicle);
        System.err.println("Vehicle object with value to be updated" +newVehicle);
        vehicle.setOwnerName(newVehicle.getOwnerName());
        vehicle.setVehicleNumber(newVehicle.getVehicleNumber());
        vehicle.setModel(newVehicle.getModel());
        vehicle.setRegistrationYear(newVehicle.getRegistrationYear());

        Vehicle upadteVehicle = vehicleRepository.save(vehicle);
        System.err.println("Vehicle with updated value" +upadteVehicle);
        return upadteVehicle;
    }

    @Override
    public List<Vehicle> savelistOfvehicle(List<Vehicle> vehicleList) {
        vehicleRepository.saveAll(vehicleList);
        return vehicleList;
    }

}
