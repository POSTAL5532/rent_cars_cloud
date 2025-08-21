package com.postal.cars.service

import com.postal.cars.model.Car
import com.postal.cars.repository.CarsRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class CarsService {

    final CarsRepository carsRepository;

    CarsService(CarsRepository carsRepository) {
        this.carsRepository = carsRepository
    }

    List<Car> getAll() {
        carsRepository.findAll()
    }

    Car getCar(UUID id) {
        def car = carsRepository.findById(id)

        if (car.isEmpty()) {
            throw new NoSuchElementException("Car with ID=${id} didn't find.")
        }

        car.get()
    }

    @Transactional
    UUID createCar(Car car) {
        def newCar = new Car()

        newCar.setBrand(car.getBrand())
        newCar.setModel(car.getModel())
        newCar.setYear(car.getYear())

        carsRepository.save(newCar).getId()
    }

    @Transactional
    Car updateCar(Car carData, UUID id) {
        def car = getCar(id)

        car.setBrand(carData.getBrand())
        car.setModel(carData.getModel())
        car.setYear(carData.getYear())

        carsRepository.save(car)
    }

    @Transactional
    def deleteCar(UUID id) {
        carsRepository.deleteById(id)
    }
}
