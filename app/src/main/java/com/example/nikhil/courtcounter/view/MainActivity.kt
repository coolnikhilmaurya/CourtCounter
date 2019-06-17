package com.example.nikhil.courtcounter.view

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.nikhil.courtcounter.R
import com.example.nikhil.courtcounter.modal.item
import com.example.nikhil.courtcounter.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var mainViewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainViewModel= ViewModelProviders.of(this).get(MainViewModel::class.java)

        mainViewModel.scores.observe(this, Observer {
            tvScoreA.text=it?.scoreA.toString()
            tvScoreB.text=it?.scoreB.toString()
            Log.d("mytag","LiveData Observed")
        })


        btnAPlus2.setOnClickListener {
            val score= getCurrentScore()
            score?.scoreA= score?.scoreA!! + 2
            mainViewModel.setScore(score)
        }
        btnAPlus3.setOnClickListener {
            val score= getCurrentScore()
            score?.scoreA= score?.scoreA!! + 3
            mainViewModel.setScore(score)
        }



        btnBPlus2.setOnClickListener {
            val score=mainViewModel.getScore()
            score?.scoreB= score?.scoreB!! + 2
            mainViewModel.setScore(score)
        }
        btnBPlus3.setOnClickListener {
            val score=mainViewModel.getScore()
            score?.scoreB= score?.scoreB!! + 3
            mainViewModel.setScore(score)
        }

        btnReset.setOnClickListener {
            mainViewModel.resetScore()
        }
    }

    fun getCurrentScore():item?{
        return mainViewModel.getScore()
    }


}
