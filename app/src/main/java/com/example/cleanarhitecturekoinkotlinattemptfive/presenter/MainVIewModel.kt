package com.example.cleanarhitecturekoinkotlinattemptfive.presenter

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.SaveUserNameParam
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.models.UserName
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.usecase.GetUserNameUseCase
import com.example.cleanarhitecturekoinkotlinattemptfive.domain.usecase.SaveUserNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainVIewModel @Inject constructor(private val getUserNameUseCase: GetUserNameUseCase, private val saveUserNameUseCase: SaveUserNameUseCase): ViewModel() {

    private val resultLiveMutable = MutableLiveData<String> ()
    val resultLive: LiveData<String> = resultLiveMutable


    init {
        Log.e("AAA", "VM: CREATED ")
    }

    override fun onCleared() {
        Log.e("AAA", "VM: HAS BEEN CLEARED ")

        super.onCleared()
    }

    fun save (text: String) {

        val params = SaveUserNameParam(name = text)
        val resultData: Boolean = saveUserNameUseCase.execute(param = params)
       resultLiveMutable.value = "Save result = $resultData"

    }


    fun load (){

        val userName: UserName = getUserNameUseCase.execute()
        resultLiveMutable.value = "${userName.firstName} ${userName.lastName}"


    }


}