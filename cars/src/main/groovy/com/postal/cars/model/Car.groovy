package com.postal.cars.model

import com.postal.dto.CarDTO
import com.postal.dto.DTOConvertable
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp

import java.time.LocalDateTime

@Entity
@Table(name = 'cars')
class Car implements DTOConvertable<CarDTO> {

    @Id
    @GeneratedValue
    UUID id

    @Column(name = "brand", nullable = false)
    String brand

    @Column(name = "model", nullable = false)
    String model

    @Column(name = "year", nullable = false)
    Short year

    @Column(name = "creation_date", nullable = false)
    @CreationTimestamp
    LocalDateTime creationDate

    Car() {
    }

    Car(UUID id, String brand, String model, Short year, LocalDateTime creationDate) {
        this.id = id
        this.brand = brand
        this.model = model
        this.year = year
        this.creationDate = creationDate
    }

    @Override
    CarDTO toDTO() {
        new CarDTO(
                this.id,
                this.brand,
                this.model,
                this.year,
                this.creationDate
        )
    }

    static Car fromDTO(CarDTO dto) {
        new Car(
                dto.getId(),
                dto.getBrand(),
                dto.getModel(),
                dto.getYear(),
                dto.getCreationDate()
        )
    }
}
