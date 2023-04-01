package com.geektech.home3month6.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MathViewModel: ViewModel() {
    private var points = 0
    val pointsLive = MutableLiveData<Int>()
    private var history = arrayListOf<String>()
    val historyLive = MutableLiveData<ArrayList<String>>()

    fun plus(){
        points++
        pointsLive.value = points
        history.add("+ ")
        historyLive.value = history
    }
    fun minus(){
        points--
        pointsLive.value = points
        history.add("- ")
        historyLive.value = history
    }
}