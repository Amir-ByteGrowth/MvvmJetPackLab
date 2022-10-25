package com.example.mvvmjetpackcompose

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import com.example.mvvmjetpackcompose.baseclasses.BaseViewModel


/**
 * Shared View Model class for sharing data between fragments
 */
class SharedViewModel : BaseViewModel() {
var name ="Amir"
    var otpVerifyingDataSharing :Int by mutableStateOf(0)
//    var movieListResponse:List<String> by mutableStateOf(listOf())

    var specimens: MutableLiveData<Int> = MutableLiveData<Int>()
}