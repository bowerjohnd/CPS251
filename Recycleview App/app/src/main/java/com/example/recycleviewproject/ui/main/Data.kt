package com.example.recycleviewproject.ui.main

import com.example.recycleviewproject.R
import kotlin.random.Random

class Data{
    val allTitles: Array<String> = arrayOf(
        "Chapter One",
        "Chapter Two", "Chapter Three", "Chapter Four",
        "Chapter Five", "Chapter Six", "Chapter Seven",
        "Chapter Eight")

    val allDetails: Array<String> = arrayOf(
        "Item one details", "Item two details",
        "Item three details", "Item four details",
        "Item five details", "Item six details",
        "Item seven details", "Item eight details")

    val allImages: Array<Int> = arrayOf(
        R.drawable.android_image_1,
        R.drawable.android_image_2, R.drawable.android_image_3,
        R.drawable.android_image_4, R.drawable.android_image_5,
        R.drawable.android_image_6, R.drawable.android_image_7,
        R.drawable.android_image_8)

    var size = allTitles.size

    val randomTitles: Array<String> = randomTitleFun()
    val randomDetails: Array<String> = randomDetailFun()
    val randomImages: Array<Int> = randomImageFun()


    fun randomTitleFun(): Array<String> {
        var temp = arrayOf<String>()

        for (x in 0..size) {
            temp += allTitles[Random.nextInt(0, size)]
        }
        return temp
    }
    fun randomDetailFun(): Array<String> {
        var temp = arrayOf<String>()
        for (x in 0..size) {
            temp += allDetails[Random.nextInt(0, size)]
        }
        return temp
    }
    fun randomImageFun(): Array<Int> {
        var temp = arrayOf<Int>()
        for (x in 0..size) {
            temp += allImages[Random.nextInt(0, size)]
        }
        return temp
    }

}