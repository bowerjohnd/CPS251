package com.ebookfrenzy.lifecycledemo.ui.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.time.*

open class MainViewModel : ViewModel() {
    var displayString: MutableLiveData<String> = MutableLiveData()
    fun addToDisplayString(input: String) {

        displayString.value = displayString.value +
                input + " was fired at " + LocalTime.now().toString() + "\n"

        //resume pause destroy *****
        if (input == "onResume" || input == "onPause" || input == "onDestroy") {
            displayString.value = displayString.value + "*****\n"
        }
    }
}