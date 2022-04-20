package com.example.cleanarhitecturekoinkotlinattemptfive.domain.usecase

import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.UserName
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.repository.UserRepository

class GetUserNameUseCase (private val userRepository: UserRepository) {

    fun execute () : UserName {
       return userRepository.getName()
    }
}