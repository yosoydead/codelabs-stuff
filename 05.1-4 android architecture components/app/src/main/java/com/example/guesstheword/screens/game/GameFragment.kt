package com.example.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.example.guesstheword.R
import com.example.guesstheword.databinding.GameFragmentBinding

//this is the game fragment
//for now, it contains all the logic for the game
class GameFragment: Fragment(){

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

        //logic for the button of the screen
        binding.correctButton.setOnClickListener{ onCorrect() }
        binding.skipButton.setOnClickListener{ onSkip() }
        binding.endGameButton.setOnClickListener{ onEndGame() }

        updateScoreText()
        updateWordText()

        return binding.root
    }

    /**
     * Resets the list of words and randomizes the order
     */


    //method for skip button
    //this method belongs to the view because it is used to process data from the viewModel
    //also, it is a onClick handler
    private fun onSkip(){
        //if the list is not empty and you press the skip button
        //take 1 point from the players score
//        if(!wordList.isEmpty()){
//            score--
//        }
//
//        nextWord()

        viewModel.onSkip()
        updateWordText()
        updateScoreText()
    }

    //method for correct button
    //this method belongs to the view because it is used to process data from the viewModel
    //also, it is a onClick handler
    private fun onCorrect(){
//        if(!wordList.isEmpty()){
//            score++
//        }
//
//        nextWord()

        viewModel.onCorrect()
        updateWordText()
        updateScoreText()
    }

    private fun onEndGame(){
        gameFinished()
    }


    private fun updateWordText(){
        binding.wordIsText.text = viewModel.word
    }

    private fun updateScoreText(){
        binding.scoreText.text = viewModel.score.toString()
    }

    private fun gameFinished(){
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()
        val action = GameFragmentDirections.actionGameFragmentToScoreFragment(viewModel.score)
        Log.i("Game Fragment", "action = $action")
        NavHostFragment.findNavController(this).navigate(action)
    }
}