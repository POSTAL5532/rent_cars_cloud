package com.postal.orders.service

import com.postal.orders.model.Order
import com.postal.orders.repository.OrdersRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class OrdersService {

    final OrdersRepository ordersRepository

    OrdersService(OrdersRepository ordersRepository) {
        this.ordersRepository = ordersRepository
    }

    List<Order> getAll() {
        ordersRepository.findAll()
    }

    Order getOrder(UUID id) {
        def order = ordersRepository.findById(id)

        if (order.isEmpty()) {
            throw new NoSuchElementException("Order with ID=${id} didn't find.")
        }

        order.get()
    }

    List<Order> getOrdersByUserId(UUID userId) {
        ordersRepository.findByUserId(userId)
    }

    List<Order> getOrdersByCarId(UUID carId) {
        ordersRepository.findByCarId(carId)
    }

    @Transactional
    UUID createOrder(Order order) {
        def newOrder = new Order()

        newOrder.setUserId(order.getUserId())
        newOrder.setCarId(order.getCarId())

        ordersRepository.save(newOrder).getId()
    }

    @Transactional
    Order updateOrder(Order orderData, UUID id) {
        def order = getOrder(id)

        order.setUserId(orderData.getUserId())
        order.setCarId(orderData.getCarId())

        ordersRepository.save(order)
    }

    @Transactional
    def deleteOrder(UUID id) {
        ordersRepository.deleteById(id)
    }
}
