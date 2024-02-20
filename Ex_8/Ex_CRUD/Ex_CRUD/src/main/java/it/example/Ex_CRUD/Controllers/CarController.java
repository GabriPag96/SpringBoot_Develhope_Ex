package it.example.Ex_CRUD.Controllers;

import it.example.Ex_CRUD.Entities.Car;
import it.example.Ex_CRUD.Repositories.CarRepository;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;

import static org.springframework.web.client.HttpClientErrorException.*;

@RestController
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarRepository carRepository;

    @PostMapping("/addAcar")
    public Car newCar(@RequestBody Car car){
       Car addCar = carRepository.saveAndFlush(car);
       return addCar;
    }

    @GetMapping("/allCars")
    public List<Car> allCarList(){
        List<Car> cars = carRepository.findAll();
        return cars;
    }

    @GetMapping("/aCar/{id}")
    public Car carById(@RequestParam Long id){
        Car foundAcar = null;
        if (carRepository.existsById(id)){
            foundAcar = carRepository.getReferenceById(id);
        }
        return foundAcar;
    }

    @PutMapping("/changeCar/{id}")
    public Car updateCar(@PathVariable Long id,@RequestParam Car car){
        car.setId(id);
        Car newCar = carRepository.saveAndFlush(car);
        return newCar;
    }

    @DeleteMapping("/deleteCar/{id}")
    public ResponseEntity<?> deleteACar(@RequestParam Long id){
       if (carRepository.existsById(id)){
           carRepository.deleteById(id);
           return new ResponseEntity<>(HttpStatus.OK);
       }else {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @DeleteMapping("/deleteAllCars")
    public void deleteAll(){
        carRepository.deleteAll();
    }
}
