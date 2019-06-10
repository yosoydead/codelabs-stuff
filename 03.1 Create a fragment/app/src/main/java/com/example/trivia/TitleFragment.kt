package com.example.trivia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.trivia.databinding.FragmentTitleBinding

class TitleFragment: Fragment() {

    /*
    * to make a fragment compile, you need to create a binding object
    * and inflate the fragments view (which is = to using setContextView() )
    *
    * to inflate the fragments view, call the DataBindingUtil.inflate()
    * */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        //create a var called binding
        //it takes 4 arguments
        //1-> the LayoutInflater used to inflate the binding layout
        //2-> the xml layout resource of the layout to inflate
        //3-> container for the parent ViewGroup. it is optional
        //4-> attachToParent value
        var binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater,
            R.layout.fragment_title,
            container,
            false
            )

        //this contains the inflated view
        return binding.root
    }
}