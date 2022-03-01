package edu.wccnet.jbower26.ui.main

import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {
    private var nameList: ArrayList<String> = ArrayList()
    private var nameString = ""
    fun addName(value: String) {
        this.nameList.add(value + "\n")
    }

    fun returnNames(): String {
        nameString = ""
        if (nameList.isNotEmpty()) {
            for (value in this.nameList) {
                nameString += value
            }
        } else {
            nameString = "No Names to Display"
        }
        return nameString
    }
}