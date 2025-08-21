package com.postal.dto

import java.time.LocalDateTime

class UserDTO {

    UUID id
    String email
    String name
    String surname
    LocalDateTime registeredAt

    UserDTO() {
    }

    UserDTO(UUID id, String email, String name, String surname, LocalDateTime registeredAt) {
        this.id = id
        this.email = email
        this.name = name
        this.surname = surname
        this.registeredAt = registeredAt
    }
}
