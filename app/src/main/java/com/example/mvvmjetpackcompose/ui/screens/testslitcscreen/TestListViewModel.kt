package com.example.mvvmjetpackcompose.ui.screens.testslitcscreen

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.data.models.RelationShipEnableModel
import com.example.mvvmjetpackcompose.data.models.TestListModel
import com.example.mvvmjetpackcompose.data.models.TestModel
import com.example.mvvmjetpackcompose.data.remote.reporitory.MainRepository
import com.example.mvvmjetpackcompose.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TestListViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    var testListModel = listOf(
        TestListModel(
            "Blood C/F (Complete,CBC)",
            "Includes 11 Tests",
            "Computer blood examination",
            "Recommended for: Male,Female",
            "600 PKR"
        ),
        TestListModel(
            "Urine C/F (Complete,UBT)",
            "Includes 11 Tests",
            "Computer blood examination",
            "Recommended for: Male,Female",
            "450 PKR"
        ),
        TestListModel(
            "Blood C/F (Complete,ANB)",
            "Includes 11 Tests",
            "Computer blood examination",
            "Recommended for: Male,Female",
            "320 PKR"
        ),
        TestListModel(
            "HEART (Complete,Female)",
            "Includes 11 Tests",
            "Computer blood examination",
            "Recommended for: Male,Female",
            "370 PKR"
        ),
        TestListModel(
            "Nerve (Complete,Female)",
            "Includes 11 Tests",
            "Computer blood examination",
            "Recommended for: Male,Female",
            "180 PKR"
        ),
        TestListModel(
            "Shoulder C/F (Complete,Female)",
            "Includes 11 Tests",
            "Computer blood examination",
            "Recommended for: Male,Female",
            "980 PKR"
        )
    )



    var showDialog = mutableStateOf(false)

    var relationShipEnableModels = mutableStateListOf(
        RelationShipEnableModel("Amir", false),
        RelationShipEnableModel("Rashid", false),
        RelationShipEnableModel("Nomi", false),
        RelationShipEnableModel("Abdul Rehman", false),
        RelationShipEnableModel("Asad", false),
        RelationShipEnableModel("Orhan", false),
        RelationShipEnableModel("Anza Fatima", false),
        RelationShipEnableModel("Nauman", false)
    )
}