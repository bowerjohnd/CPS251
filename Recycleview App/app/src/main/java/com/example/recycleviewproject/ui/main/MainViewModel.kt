package com.example.recycleviewproject.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val data = Data()

    val titles = data.randomTitles
    val details = data.randomDetails
    val images = data.randomImages
}