package com.example.guesstheword.screens.game

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

//in the viewmodel, move every data field from the fragment
class GameViewModel: ViewModel() {

    //these are going to be mutable live data meaning they are going to change
    //encapsulated the mutableLiveData object
    //data should be read from outside the class, not editable
    private val _word = MutableLiveData<String>()
    val word: LiveData<String>
        get() = _word

    //encapsulated the mutableLiveData object
    //data should be read from outside the class, not editable
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    //this var will be used to notify the game that the list of word is empty
    //and navigate to the end game fragment
    private val _eventGameFinish = MutableLiveData<Boolean>()
    val eventGameFinish: LiveData<Boolean>
        get() = _eventGameFinish

    //this is going to be the list which has all the words for the game
    lateinit var wordList: MutableList<String>

    init {
        Log.i("GameViewModel", "GameViewModel created!")

        //initialize the values for the live data objects
        _word.value = ""
        _score.value = 0


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
            _word.value = wordList.removeAt(0)
        }else{
            //if the list of words is empty, trigger the end of game
            onGameFinish()
        }
    }

    //method for skip button
    //this method belongs to the view because it is used to process data from the viewModel
    //also, it is a onClick handler
    fun onSkip(){
        //if the list is not empty and you press the skip button
        //take 1 point from the players score
        if(!wordList.isEmpty()){
            //because im using live data, i need to check for null
            _score.value = (score.value)?.minus(1)
        }

        nextWord()
    }

    //method for correct button
    //this method belongs to the view because it is used to process data from the viewModel
    //also, it is a onClick handler
    fun onCorrect(){
        if(!wordList.isEmpty()){
            _score.value = (score.value)?.plus(1)
        }

        nextWord()
    }

    fun onGameFinish(){
        _eventGameFinish.value = true
    }

    fun onGameFinishComplete(){
        _eventGameFinish.value = false
    }

}
