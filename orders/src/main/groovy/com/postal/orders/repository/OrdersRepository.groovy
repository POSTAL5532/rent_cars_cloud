package com.postal.orders.repository

import com.postal.orders.model.Order
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface OrdersRepository extends JpaRepository<Order, UUID> {

    List<Order> findByUserId(UUID userId)
    List<Order> findByCarId(UUID carId)
}
