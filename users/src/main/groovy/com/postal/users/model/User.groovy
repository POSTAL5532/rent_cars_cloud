package com.postal.users.model

import com.postal.dto.DTOConvertable
import com.postal.dto.UserDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp

import java.time.LocalDateTime

@Entity
@Table(name = 'users')
class User implements DTOConvertable<UserDTO> {

    @Id
    @GeneratedValue
    UUID id

    @Column(name = "email", nullable = false, unique = true)
    String email

    @Column(name = 'name', nullable = false)
    String name

    @Column(name = 'surname', nullable = false)
    String surname

    @Column(name = "creation_date", nullable = false)
    @CreationTimestamp
    LocalDateTime registeredAt

    User() {
    }

    User(UUID id, String email, String name, String surname, LocalDateTime registeredAt) {
        this.id = id
        this.email = email
        this.name = name
        this.surname = surname
        this.registeredAt = registeredAt
    }

    @Override
    UserDTO toDTO() {
        new UserDTO(
                this.id,
                this.email,
                this.name,
                this.surname,
                this.registeredAt
        )
    }

    static User fromDTO(UserDTO dto) {
        new User(
                dto.getId(),
                dto.getEmail(),
                dto.getName(),
                dto.getSurname(),
                dto.getRegisteredAt()
        )
    }
}
