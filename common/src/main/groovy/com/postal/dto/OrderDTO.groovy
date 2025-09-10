package com.postal.dto

import java.time.LocalDateTime

class OrderDTO {

    UUID id
    UUID userId
    UUID carId
    LocalDateTime creationDate
    LocalDateTime updateDate

    OrderDTO() {
    }

    OrderDTO(UUID id, UUID userId, UUID carId, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.id = id
        this.userId = userId
        this.carId = carId
        this.creationDate = creationDate
        this.updateDate = updateDate
    }
}
