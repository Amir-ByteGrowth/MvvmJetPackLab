package com.example.mvvmjetpackcompose.data.models

data class TestModel(val icon: Int, val name: String)

data class TestListModel(
    val testName: String,
    val testInclude: String,
    val testType: String,
    val recommendedFor: String,
    val price: String
)