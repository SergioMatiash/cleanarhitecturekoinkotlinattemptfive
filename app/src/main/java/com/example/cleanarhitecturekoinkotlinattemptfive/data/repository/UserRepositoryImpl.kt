package com.example.cleanarhitecturekoinkotlinattemptfive.data.repository

import android.content.Context
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.SaveUserNameParam
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.UserName
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.repository.UserRepository


private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
private const val KEY_FIRST_NAME = "FIRSTNAME"
private const val KEY_LAST_NAME = "LASTNAME"


class UserRepositoryImpl (context: Context): UserRepository {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveParam: SaveUserNameParam): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, saveParam.name).apply()
        return true
    }

    override fun getName(): UserName {

        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: "something by default"
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, "nothing to show") ?: "something by default"

        return UserName(firstName = firstName, lastName = lastName)

    }


}