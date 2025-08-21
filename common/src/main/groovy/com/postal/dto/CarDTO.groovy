package com.postal.dto

import java.time.LocalDateTime

class CarDTO {

    UUID id
    String brand
    String model
    Short year
    LocalDateTime creationDate

    CarDTO() {
    }

    CarDTO(UUID id, String brand, String model, Short year, LocalDateTime creationDate) {
        this.id = id
        this.brand = brand
        this.model = model
        this.year = year
        this.creationDate = creationDate
    }
}
