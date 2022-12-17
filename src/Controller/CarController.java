package Controller;

import Entity.Car;
import Service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CarController {

    private final CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    // FETCH ALL
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return carService.getAllCars();
    }

    // FETCH BY ID
    @GetMapping("/cars/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable("id") Long id) {
        Car car = carService.getCarById(id);
        return new ResponseEntity<>(car, HttpStatus.OK);
    }

    @PostMapping("/cars")
    public ResponseEntity<Car> createCar(@RequestBody Car car) {
        Car newCar = carService.createCar(car);
        return new ResponseEntity<>(newCar, HttpStatus.CREATED);
    }

    @PutMapping("/cars/{id}")
    public ResponseEntity<Car> updateCar(@RequestBody Car car, @PathVariable("id") Long id) {
        return new ResponseEntity<>(carService.updateCar(id, car), HttpStatus.OK);
    }

    @DeleteMapping("/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable("id") Long id) {
        carService.deleteCar(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }


/*
    // FETCH ALL BY Reservation
    @GetMapping("/cars/{reservationId}")
    public List<Car> getCarsByReservation(@PathVariable Long reservationId) {
        Reservation reservation = reservationService.findById(reservationId);
        return carService.findCarsByReservation(reservation);
    }

    // SAVE Car
    @PostMapping("/cars")
    public Car saveCar(@RequestBody Car car) {
        Car newCar = carService.saveCar(car);
        return carService.save(car);
    }

    // ASSIGN PARTY FOR A CANDIDATE
    @PutMapping("/assign-reservation/{carId}/{reservationId}")
    public Car addReservationToCar(@PathVariable Long carId, @PathVariable Long reservationId) {
        Car car = carService.findById(carId);
        Reservation reservation = reservationService.findById(reservationId);

        car.setReservation(reservation);
        return carService.save(car);
    }


    // EDIT Car
    @PutMapping("/car/{carId}")
    public Car updateCar(@PathVariable Long carId, @RequestBody Car updatedCar) {
        Car car = carService.findById(carId);

        car.setBrand(updatedCar.getBrand());
        car.setModel(updatedCar.getModel());
        car.setPricePrDay(updatedCar.getPricePrDay());
        car.setBestDiscount(updatedCar.getBestDiscount());

        return carService.save(car);
    }


    // DELETE Car
    @DeleteMapping("/car/{carId}")
    public void deleteCar(@PathVariable Long carId) {
        Car car = carService.findById(carId);
        carService.delete(car);
    }
*/

}
