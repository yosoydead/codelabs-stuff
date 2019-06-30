package com.example.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.example.guesstheword.R
import com.example.guesstheword.databinding.GameFragmentBinding

//this is the game fragment
//for now, it contains all the logic for the game
class GameFragment: Fragment(){
    private var word = ""
    private var score = 0

    //this is going to be the list which has all the words for the game
    private lateinit var wordList: MutableList<String>

    //this is just the binding object from the layout
    private lateinit var binding: GameFragmentBinding

    //create a ref to the ViewModel
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //inflate the view and obtain an instance of the binding class
        binding = DataBindingUtil.inflate(inflater, R.layout.game_fragment, container, false)

        //make an instance of the view model
        //if i dont use ViewModelProviders, every time the fragment/activity is
        //recreated, the view model gets recreated as well and so mitigates
        //the advantage of having a view model
        viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        Log.i("GameFragment", "Called ViewModelProviders.of")

        resetList()
        nextWord()

        //logic for the button of the screen
        binding.correctButton.setOnClickListener{ onCorrect() }
        binding.skipButton.setOnClickListener{ onSkip() }

        updateScoreText()
        updateWordText()

        return binding.root
    }

    /**
     * Resets the list of words and randomizes the order
     */
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

    //method for skip button
    private fun onSkip(){
        //if the list is not empty and you press the skip button
        //take 1 point from the players score
        if(!wordList.isEmpty()){
            score--
        }

        nextWord()
    }

    //method for correct button
    private fun onCorrect(){
        if(!wordList.isEmpty()){
            score++
        }

        nextWord()
    }

    private fun nextWord(){
        //if the list is not empty, give a new word to the screen
        if(!wordList.isEmpty()){
            word = wordList.removeAt(0)
        }

        //update the screen methods
        updateWordText()
        updateScoreText()
    }

    private fun updateWordText(){
        binding.wordIsText.text = word
    }

    private fun updateScoreText(){
        binding.scoreText.text = score.toString()
    }
}