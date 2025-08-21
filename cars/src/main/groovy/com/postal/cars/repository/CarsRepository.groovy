package com.postal.cars.repository

import com.postal.cars.model.Car
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarsRepository extends JpaRepository<Car, UUID> {

}
