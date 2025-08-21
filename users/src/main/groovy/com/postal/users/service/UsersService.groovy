package com.postal.users.service

import com.postal.users.model.User
import com.postal.users.repository.UsersRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class UsersService {

    final UsersRepository usersRepository;

    UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository
    }

    List<User> getAll() {
        usersRepository.findAll()
    }

    User getUser(UUID id) {
        def user = usersRepository.findById(id)

        if (user.isEmpty()) {
            throw new NoSuchElementException("User with ID=${id} didn't find.")
        }

        user.get()
    }

    @Transactional
    UUID createUser(User user) {
        def newUser = new User()

        newUser.setEmail(user.getEmail())
        newUser.setName(user.getName())
        newUser.setSurname(user.getSurname())

        usersRepository.save(newUser).getId()
    }

    @Transactional
    User updateUser(User userData, UUID id) {
        def user = getUser(id)

        user.setEmail(userData.getEmail())
        user.setName(userData.getName())
        user.setSurname(userData.getSurname())

        usersRepository.save(user)
    }

    @Transactional
    def deleteUser(UUID id) {
        usersRepository.deleteById(id)
    }
}
