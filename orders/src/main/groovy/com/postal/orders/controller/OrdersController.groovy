package com.postal.orders.controller

import com.postal.dto.OrderDTO
import com.postal.orders.model.Order
import com.postal.orders.service.OrdersService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/orders")
class OrdersController {

    private final OrdersService ordersService

    OrdersController(OrdersService ordersService) {
        this.ordersService = ordersService
    }

    @GetMapping
    ResponseEntity<List<OrderDTO>> getAllOrders() {
        ResponseEntity.ok(ordersService.all.collect { o -> o.toDTO() })
    }

    @GetMapping("/{id}")
    ResponseEntity<OrderDTO> getOrder(@PathVariable("id") String id) {
        ResponseEntity.ok(ordersService.getOrder(UUID.fromString(id)).toDTO())
    }

    @GetMapping("/user/{userId}")
    ResponseEntity<List<OrderDTO>> getOrdersByUserId(@PathVariable("userId") String userId) {
        ResponseEntity.ok(ordersService.getOrdersByUserId(UUID.fromString(userId)).collect { o -> o.toDTO() })
    }

    @GetMapping("/car/{carId}")
    ResponseEntity<List<OrderDTO>> getOrdersByCarId(@PathVariable("carId") String carId) {
        ResponseEntity.ok(ordersService.getOrdersByCarId(UUID.fromString(carId)).collect { o -> o.toDTO() })
    }

    @PostMapping
    ResponseEntity<UUID> createOrder(@RequestBody OrderDTO orderDTO) {
        ResponseEntity.ok(ordersService.createOrder(Order.fromDTO(orderDTO)))
    }

    @DeleteMapping("/{id}")
    def deleteOrder(@PathVariable("id") String id) {
        ordersService.deleteOrder(UUID.fromString(id))
        ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    ResponseEntity<OrderDTO> updateOrder(@PathVariable("id") String id, @RequestBody OrderDTO orderDTO) {
        def updatedOrder = ordersService.updateOrder(Order.fromDTO(orderDTO), UUID.fromString(id))
        ResponseEntity.ok(updatedOrder.toDTO())
    }
}
