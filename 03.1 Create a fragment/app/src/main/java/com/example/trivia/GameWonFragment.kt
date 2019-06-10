package com.example.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.trivia.databinding.FragmentGameWonBinding

class GameWonFragment: Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        var binding: FragmentGameWonBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_game_won, container, false
        )

        //set a click listener so when the user presses the next match button
        //the app will navigate back to the game fragment
        binding.nextMatchButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_gameWonFragment_to_gameFragment)
        }

        return binding.root
    }
}