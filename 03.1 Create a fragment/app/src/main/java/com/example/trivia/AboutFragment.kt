package com.example.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class AboutFragment:Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              saveInstanceState: Bundle?): View?{

        //inflates the layout for this fragment
        return inflater.inflate(R.layout.fragment_about, container, false)
    }
}