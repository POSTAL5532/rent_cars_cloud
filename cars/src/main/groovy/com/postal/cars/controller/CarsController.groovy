package com.postal.cars.controller

import com.postal.dto.CarDTO
import com.postal.cars.model.Car
import com.postal.cars.service.CarsService
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.context.config.annotation.RefreshScope
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/cars")
@RefreshScope
class CarsController {

    private final CarsService carsService

    @Value('${someProp}')
    String property

    CarsController(CarsService carsService) {
        this.carsService = carsService
    }

    @GetMapping
    ResponseEntity<List<CarDTO>> getAllCars() {
        println "============================ " + property + " ============================"
        ResponseEntity.ok(carsService.all.collect { c -> c.toDTO() })
    }

    @GetMapping("/{id}")
    ResponseEntity<CarDTO> getCar(@PathVariable("id") String id) {
        ResponseEntity.ok(carsService.getCar(UUID.fromString(id)).toDTO())
    }

    @PostMapping
    ResponseEntity<UUID> createCar(@RequestBody CarDTO carDTO) {
        ResponseEntity.ok(carsService.createCar(Car.fromDTO(carDTO)))
    }

    @DeleteMapping("/{id}")
    def deleteCar(@PathVariable("id") String id) {
        carsService.deleteCar(UUID.fromString(id))
        ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    ResponseEntity<CarDTO> updateCar(@PathVariable("id") String id, @RequestBody CarDTO carDTO) {
        def updatedCar = carsService.updateCar(Car.fromDTO(carDTO), UUID.fromString(id))
        ResponseEntity.ok(updatedCar.toDTO())
    }
}
