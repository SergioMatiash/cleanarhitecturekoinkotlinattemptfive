package com.example.cleanarhitecturekoinkotlinattemptfive.domain.usecase


import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.SaveUserNameParam
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.repository.UserRepository
import javax.inject.Inject

class SaveUserNameUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun execute (param: SaveUserNameParam) : Boolean{

        val oldUserName = userRepository.getName()
        if (oldUserName.firstName == param.name) {
            return true
        }

     val result: Boolean = userRepository.saveName(saveParam = param)
        return result
    }
}