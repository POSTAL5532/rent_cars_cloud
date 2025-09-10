package com.postal.orders.model

import com.postal.dto.DTOConvertable
import com.postal.dto.OrderDTO
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp

import java.time.LocalDateTime

@Entity
@Table(name = 'orders')
class Order implements DTOConvertable<OrderDTO> {

    @Id
    @GeneratedValue
    UUID id

    @Column(name = "user_id", nullable = false)
    UUID userId

    @Column(name = "car_id", nullable = false)
    UUID carId

    @Column(name = "creation_date", nullable = false)
    @CreationTimestamp
    LocalDateTime creationDate

    @Column(name = "update_date", nullable = false)
    @UpdateTimestamp
    LocalDateTime updateDate

    Order() {
    }

    Order(UUID id, UUID userId, UUID carId, LocalDateTime creationDate, LocalDateTime updateDate) {
        this.id = id
        this.userId = userId
        this.carId = carId
        this.creationDate = creationDate
        this.updateDate = updateDate
    }

    @Override
    OrderDTO toDTO() {
        new OrderDTO(
                this.id,
                this.userId,
                this.carId,
                this.creationDate,
                this.updateDate
        )
    }

    static Order fromDTO(OrderDTO dto) {
        new Order(
                dto.getId(),
                dto.getUserId(),
                dto.getCarId(),
                dto.getCreationDate(),
                dto.getUpdateDate()
        )
    }
}
