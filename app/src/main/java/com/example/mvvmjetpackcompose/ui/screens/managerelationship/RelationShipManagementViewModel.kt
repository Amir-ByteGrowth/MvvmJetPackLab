package com.example.mvvmjetpackcompose.ui.screens.managerelationship

import androidx.lifecycle.ViewModel
import com.example.mvvmjetpackcompose.data.models.RelationModel
import com.example.mvvmjetpackcompose.data.remote.reporitory.MainRepository
import com.example.mvvmjetpackcompose.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RelationShipManagementViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    var relationShipList = listOf(
        RelationModel("Muhammad Anwar", "Father"),
        RelationModel("Muhammad Asad Ullah Khan", "Son"),
        RelationModel("Anza Amir", "Father"),
        RelationModel("Muhammad Orhan Khan", "Son"),
        RelationModel("Muhammad Alp Arslan", "Son")
    )

}