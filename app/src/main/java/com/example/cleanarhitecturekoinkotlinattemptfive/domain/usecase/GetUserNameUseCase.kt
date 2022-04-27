package com.example.cleanarhitecturekoinkotlinattemptfive.domain.usecase

import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.UserName
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.repository.UserRepository
import javax.inject.Inject

class GetUserNameUseCase @Inject constructor(private val userRepository: UserRepository) {

    fun execute () : UserName {
       return userRepository.getName()
    }
}