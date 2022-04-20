package com.example.cleanarhitecturekoinkotlinattemptfive.domain.repository

import android.content.Context
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.SaveUserNameParam
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.UserName

interface UserRepository {



    fun saveName (saveParam: SaveUserNameParam) : Boolean

    fun getName () : UserName
}