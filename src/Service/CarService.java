package Service;

import Entity.Car;
import Entity.Reservation;
import Repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CarService {

    private final CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository){ this.carRepository = carRepository;}
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public Car getCarById(Long id) {
        return carRepository.findById(id).orElse(null);
    }

    public Car createCar(Car car) {
        return carRepository.save(car);
    }

    public void deleteCar(Long id) {
        carRepository.deleteById(id);
    }

    public Car updateCar(Long id, Car car) {
        if (carRepository.findById(id).isEmpty()) {
            return null;
        }
        return carRepository.save(car);
    }
}