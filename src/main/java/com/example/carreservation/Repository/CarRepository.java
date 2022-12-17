package com.example.carreservation.Repository;

import com.example.carreservation.Entity.Car;
import com.example.carreservation.Entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    List<Car> findCarsByReservation(Reservation reservation);
}
