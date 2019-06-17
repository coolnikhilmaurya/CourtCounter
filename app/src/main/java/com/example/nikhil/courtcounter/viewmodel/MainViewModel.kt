package com.example.nikhil.courtcounter.viewmodel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.nikhil.courtcounter.modal.item

class MainViewModel : ViewModel() {
    var scores: MutableLiveData<item> = MutableLiveData()

    init {
        scores.postValue(item(0, 0))
    }

    fun getScore(): item? {
        return scores.value
    }

    fun setScore(score: item) {
        scores.postValue(score)
    }

    fun resetScore() {
        scores.postValue(item(0, 0))
    }
}