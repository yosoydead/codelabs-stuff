package com.example.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.ViewModel

//in the viewmodel, move every data field from the fragment
class GameViewModel: ViewModel() {

    var word = ""
    var score = 0

    //this is going to be the list which has all the words for the game
    lateinit var wordList: MutableList<String>

    init {
        Log.i("GameViewModel", "GameViewModel created!")
        resetList()
        nextWord()
    }

    override fun onCleared() {
        super.onCleared()

        Log.i("GameViewModel", "GameViewModel destroyed")
    }

    private fun resetList() {
        wordList = mutableListOf(
            "queen",
            "hospital",
            "basketball",
            "cat",
            "change",
            "snail",
            "soup",
            "calendar",
            "sad",
            "desk",
            "guitar",
            "home",
            "railway",
            "zebra",
            "jelly",
            "car",
            "crow",
            "trade",
            "bag",
            "roll",
            "bubble"
        )
        wordList.shuffle()
    }


    private fun nextWord(){
        //if the list is not empty, give a new word to the screen
        if(!wordList.isEmpty()){
            word = wordList.removeAt(0)
        }
    }

    //method for skip button
    //this method belongs to the view because it is used to process data from the viewModel
    //also, it is a onClick handler
    fun onSkip(){
        //if the list is not empty and you press the skip button
        //take 1 point from the players score
        if(!wordList.isEmpty()){
            score--
        }

        nextWord()
    }

    //method for correct button
    //this method belongs to the view because it is used to process data from the viewModel
    //also, it is a onClick handler
    fun onCorrect(){
        if(!wordList.isEmpty()){
            score++
        }

        nextWord()
    }
}
