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

    var randomTitles: Array<String> = arrayOf()
    var randomDetails: Array<String> = arrayOf()
    var randomImages: Array<Int> = arrayOf()

    init {
        this.randomTitleFun()
        this.randomDetailFun()
        this.randomImageFun()
    }

    fun randomTitleFun() {
        for (x in 0..size) {
            this.randomTitles += allTitles[Random.nextInt(0, size)]
        }
    }
    fun randomDetailFun() {
        for (x in 0..size) {
            this.randomDetails += allDetails[Random.nextInt(0, size)]
        }
    }
    fun randomImageFun() {
        for (x in 0..size) {
            this.randomImages += allImages[Random.nextInt(0, size)]
        }
    }
}