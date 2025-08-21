package com.postal.users.repository

import com.postal.users.model.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UsersRepository extends JpaRepository<User, UUID> {

}