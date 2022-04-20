package com.example.cleanarhitecturekoinkotlinattemptfive.data.repository


import com.example.cleanarhitecturekoinkotlinattemptfive.data.storage.models.User
import com.example.cleanarhitecturekoinkotlinattemptfive.data.storage.UserStorage
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.SaveUserNameParam
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.UserName
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.repository.UserRepository





class UserRepositoryImpl (private val userStorage: UserStorage): UserRepository {


    override fun saveName(saveParam: SaveUserNameParam): Boolean {

        val user = mapToStorage(saveParam)
        val result = userStorage.save(user)
        return result
    }


    override fun getName(): UserName {

        val user = userStorage.get()

        return mapToDomain(user)

    }


    private fun mapToDomain (user: User): UserName {
        return  UserName (firstName = user.firstName, lastName = user.lastName)
    }

    private fun mapToStorage (saveParam: SaveUserNameParam): User {
        return User(firstName = saveParam.name, lastName = "by default from repositoryimpl")
    }

}