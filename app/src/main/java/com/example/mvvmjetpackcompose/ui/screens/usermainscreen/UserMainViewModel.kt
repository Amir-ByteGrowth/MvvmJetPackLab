package com.example.mvvmjetpackcompose.ui.screens.usermainscreen

import androidx.lifecycle.ViewModel
import com.example.mvvmjetpackcompose.R
import com.example.mvvmjetpackcompose.data.models.TestModel
import com.example.mvvmjetpackcompose.data.remote.reporitory.MainRepository
import com.example.mvvmjetpackcompose.utils.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserMainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {
    var testsList = listOf(
        TestModel(R.drawable.iconsmicroscop, "All"),
        TestModel(R.drawable.iconssugar, "Diabetes"),
        TestModel(R.drawable.iconheart, "Heart"),
        TestModel(R.drawable.iconliver, "Liver"),
        TestModel(R.drawable.iconbrain, "Brain"),
        TestModel(R.drawable.iconkidney, "Kidney")
    )

    var chughtaiServicesList = listOf(
        TestModel(R.drawable.iconsamplecollect, "Home Sampling"),
        TestModel(R.drawable.iconssugar, "View Report"),
        TestModel(R.drawable.iconheart, "Blue Card"),
        TestModel(R.drawable.iconliver, "Locations"),
        TestModel(R.drawable.iconbrain, "Travel Request")
    )

    var servicesList = listOf(
        TestModel(R.drawable.iconsmedicine, "Medicine"),
        TestModel(R.drawable.iconsxray, "Radiology"),
        TestModel(R.drawable.iconshosp, "Appointment"),
        TestModel(R.drawable.iconsambulancehome, "Home Care"),
        TestModel(R.drawable.iconbrain, "Ambulance"),
    )

    var settingsList = listOf(
        TestModel(R.drawable.icon, "About Us"),
        TestModel(R.drawable.icon, "Help"),
        TestModel(R.drawable.icon, "Call Us"),
        TestModel(R.drawable.icon, "Wallet"),
        TestModel(R.drawable.icon, "Merge Member Request"),
        TestModel(R.drawable.icon, "Log Out")
    )
}