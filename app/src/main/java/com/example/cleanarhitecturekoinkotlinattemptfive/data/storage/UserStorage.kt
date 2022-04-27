package com.example.cleanarhitecturekoinkotlinattemptfive.data.storage

import com.example.cleanarhitecturekoinkotlinattemptfive.data.storage.models.User

interface UserStorage {

    fun save (user: User): Boolean
    fun get (): User
}