package com.postal.users.controller

import com.postal.dto.UserDTO
import com.postal.users.model.User
import com.postal.users.service.UsersService
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
@RequestMapping("/users")
class UsersController {

    private final UsersService usersService

    UsersController(UsersService usersService) {
        this.usersService = usersService
    }

    @GetMapping
    ResponseEntity<List<UserDTO>> getAllUsers() {
        ResponseEntity.ok(usersService.all.collect { u -> u.toDTO() })
    }

    @GetMapping("/{id}")
    ResponseEntity<UserDTO> getUser(@PathVariable("id") String id) {
        ResponseEntity.ok(usersService.getUser(UUID.fromString(id)).toDTO())
    }

    @PostMapping
    ResponseEntity<UUID> createUser(@RequestBody UserDTO userDTO) {
        ResponseEntity.ok(usersService.createUser(User.fromDTO(userDTO)))
    }

    @DeleteMapping("/{id}")
    def deleteUser(@PathVariable("id") String id) {
        usersService.deleteUser(UUID.fromString(id))
        ResponseEntity.noContent().build()
    }

    @PutMapping("/{id}")
    ResponseEntity<UserDTO> updateUser(@PathVariable("id") String id, @RequestBody UserDTO userDTO) {
        def updatedUser = usersService.updateUser(User.fromDTO(userDTO), UUID.fromString(id))
        ResponseEntity.ok(updatedUser.toDTO())
    }
}
