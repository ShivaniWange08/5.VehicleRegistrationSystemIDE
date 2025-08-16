package com.practise.controller;

import com.practise.entity.Vehicle;
import com.practise.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @PostMapping("/addVehicle")
    public ResponseEntity<String> addVehicle(@RequestBody Vehicle vehicle){
        System.err.println(vehicle);
        vehicleService.saveVehicle(vehicle);
        return new ResponseEntity<>("Vehicle Data Add Successfully", HttpStatus.CREATED);
    }

    @GetMapping("/getAllVehicle")
    public ResponseEntity<List<Vehicle>> getAllData(){
      List<Vehicle> vehicleList = vehicleService.getAllVehicle();
      return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("/getVehicleById/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable("id") int id){
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return new ResponseEntity<>(vehicle, HttpStatus.OK);
    }

    @DeleteMapping("/deleteVehicleById/{id}")
   public ResponseEntity<String> deleteById(@PathVariable ("id") int id){
        String delete = vehicleService.deleteVehicleById(id);
        return new ResponseEntity<>(delete, HttpStatus.OK);
    }

    @PutMapping("/updateVehicle/{id}")
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable ("id") int id, @RequestBody Vehicle vehicle){
        Vehicle updateVehicle = vehicleService.updateVehicle(id, vehicle);
        return new ResponseEntity<>(updateVehicle, HttpStatus.OK);
    }


    @PostMapping("/listOfVehicle")
    public ResponseEntity<List<Vehicle>> savelistofVehicle(@RequestBody List<Vehicle> vehicleList){
        vehicleService.savelistOfvehicle(vehicleList);
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }
}
