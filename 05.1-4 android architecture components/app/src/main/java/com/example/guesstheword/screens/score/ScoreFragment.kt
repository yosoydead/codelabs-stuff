package com.example.guesstheword.screens.score

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.guesstheword.R
import com.example.guesstheword.databinding.ScoreFragmentBinding

class ScoreFragment: Fragment(){

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<ScoreFragmentBinding>(inflater,
            R.layout.score_fragment,
            container,
            false)

        return binding.root
    }
}