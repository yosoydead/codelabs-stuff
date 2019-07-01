package com.example.guesstheword.screens.score

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.guesstheword.R
import com.example.guesstheword.databinding.ScoreFragmentBinding

class ScoreFragment: Fragment(){

    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<ScoreFragmentBinding>(inflater,
            R.layout.score_fragment,
            container,
            false)

        viewModelFactory = ScoreViewModelFactory(ScoreFragmentArgs.fromBundle(arguments!!).score)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ScoreViewModel::class.java)

        Log.i("ScoreFragment", "score value: ${ScoreFragmentArgs.fromBundle(arguments!!).score}")

        binding.scoreViewModel = viewModel

        //attach an observer to the liveData object from the viewModel
        viewModel.score.observe(this, Observer { newScore ->
            binding.scoreText.text = newScore.toString()
        })

        viewModel.eventPlayAgain.observe(this, Observer {playAgain ->
            if(playAgain == true){
                findNavController().navigate(ScoreFragmentDirections.actionScoreFragmentToGameFragment())
                viewModel.onPlayAgainComplete()
            }
        })

//        binding.playAgainButton.setOnClickListener{
//            viewModel.onPlayAgain()
//        }

        return binding.root
    }
}