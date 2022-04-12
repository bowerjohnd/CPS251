package edu.wccnet.jbower26.recycleviewintentsapp.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    companion object {
        var titles = arrayOf<String>()
        var details = arrayOf<String>()
        var images = arrayOf<Int>()

        val data = Data()

        init {
            this.titles = data.randomTitles
            this.details = data.randomDetails
            this.images = data.randomImages
        }
    }


}