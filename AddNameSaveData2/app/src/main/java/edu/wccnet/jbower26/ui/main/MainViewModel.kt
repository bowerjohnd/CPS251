package edu.wccnet.jbower26.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import edu.wccnet.jbower26.R

class MainViewModel : ViewModel() {
    var nameList: ArrayList<String> = ArrayList()
    var nameString: MutableLiveData<String> = MutableLiveData()
    var inputName = ""

    fun addName() {
        val temp = inputName.replace(" ", "")
        if (temp.isNotEmpty()) {
            nameList.add(inputName + "\n")
            nameString.value = returnNames()
        }
    }

    fun returnNames(): String {
        var temp = ""
        if (nameList.isNotEmpty()) {
            for (value in this.nameList) {
                temp += value
            }
        }
        return temp
    }
}