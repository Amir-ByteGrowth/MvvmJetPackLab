package com.example.mvvmjetpackcompose

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.MutableLiveData
import com.example.mvvmjetpackcompose.baseclasses.BaseViewModel


/**
 * Shared View Model class for sharing data between fragments
 */
class SharedViewModel : BaseViewModel() {
    var name = "Amir"
    var otpVerifyingDataSharing: Int by mutableStateOf(0)
//    var movieListResponse:List<String> by mutableStateOf(listOf())

    var itemsInCart: MutableLiveData<Int> = MutableLiveData<Int>(0)

    init {

    }

    fun addCart() {
        itemsInCart.value = itemsInCart.value!! + 1
        Log.d("AddCart",itemsInCart.value.toString())
    }

    fun subCart() {
        itemsInCart.value = itemsInCart.value!! + 1
    }

    fun clearCart() {
        itemsInCart.value = 0
    }
}