package com.example.guesstheword.screens.game

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
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

        //initialize the binding object from the view which uses the gameViewModel as model
        binding.gameViewModel = viewModel

        //logic for the button of the screen
//        binding.correctButton.setOnClickListener{ onCorrect() }
//        binding.skipButton.setOnClickListener{ onSkip() }
//        binding.endGameButton.setOnClickListener{ onEndGame() }

        //attach an observer object to the score property of the viewModel
        //it the score in the viewModel changes, notify the UI and update it
        viewModel.score.observe(this, Observer { newScore ->
            //update the value of the scoreText TextView with the help of this observer
            //with this, i can delete the updateScoreText()
            binding.scoreText.text = newScore.toString()
        })

        viewModel.word.observe(this, Observer { newWord->
            //update the value of the wordText TextView with the help of this observer
            //with this, i can delete the updateWordText()
            binding.wordText.text = newWord
        })

        //attach an observer to the game ending variable
        viewModel.eventGameFinish.observe(this, Observer<Boolean> { hasFinished ->
            if(hasFinished == true){
                gameFinished()
            }
        })

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
//        updateWordText()
//        updateScoreText()
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
//        updateWordText()
//        updateScoreText()
    }

    private fun onEndGame(){
        gameFinished()
    }


//    private fun updateWordText(){
//        //use the value of the word property from the viewModel because it is live data now
//        binding.wordIsText.text = viewModel.word.value
//    }
//
//    private fun updateScoreText(){
//        binding.scoreText.text = viewModel.score.value.toString()
//    }

    private fun gameFinished(){
        Toast.makeText(activity, "Game has just finished", Toast.LENGTH_SHORT).show()

        //i use this method to tell the viewModel that the game has finished and the boolean
        //value should be reset to false because if it remains true, every time the game fragment
        //is re-created, the toast message saying "Game has just finished!" shows every time
        viewModel.onGameFinishComplete()


        //had to make a null check on the live data object and then pass it as an argument
        //to the transition from game fragment to score fragment
        var actualScore = viewModel.score.value?: 0
        val action = GameFragmentDirections.actionGameFragmentToScoreFragment(actualScore)

        Log.i("Game Fragment", "action = $action")
        NavHostFragment.findNavController(this).navigate(action)
    }
}