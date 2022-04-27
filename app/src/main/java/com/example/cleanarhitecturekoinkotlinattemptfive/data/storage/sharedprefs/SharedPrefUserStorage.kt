package com.example.cleanarhitecturekoinkotlinattemptfive.data.storage.sharedprefs

import android.content.Context
import com.example.cleanarhitecturekoinkotlinattemptfive.data.storage.UserStorage
import com.example.cleanarhitecturekoinkotlinattemptfive.data.storage.models.User
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.UserName


private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
private const val KEY_FIRST_NAME = "FIRSTNAME"
private const val KEY_LAST_NAME = "LASTNAME"

private const val DEFAULT_LAST_NAME = "LASTNAME BY DEFAULT"

class SharedPrefUserStorage (context: Context) : UserStorage {

    private val sharedPreferences = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun save(user: User): Boolean {
        sharedPreferences.edit().putString(KEY_FIRST_NAME, user.firstName).apply()
        sharedPreferences.edit().putString(KEY_LAST_NAME, user.lastName).apply()
        return true }

    override fun get(): User {
        val firstName = sharedPreferences.getString(KEY_FIRST_NAME, "") ?: "something by default"
        val lastName = sharedPreferences.getString(KEY_LAST_NAME, DEFAULT_LAST_NAME) ?: DEFAULT_LAST_NAME

        return User(firstName = firstName, lastName = lastName)
    }



}