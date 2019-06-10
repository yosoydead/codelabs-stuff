package com.example.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.trivia.databinding.FragmentGameOverBinding

class GameOverFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        //inflate the layout for this fragment
        val binding: FragmentGameOverBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_over, container, false
        )


        //this will enable the user to navigate to the game fragmenta again if he presses the try again button
        binding.tryAgainButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_gameOverFragment_to_gameFragment)
        }

        return binding.root
    }
}