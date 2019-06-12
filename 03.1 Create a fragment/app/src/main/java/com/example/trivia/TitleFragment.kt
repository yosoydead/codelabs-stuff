package com.example.trivia

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
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

        //click listener to navigate from title to game fragment
        //in the new version of navigation components i have to use the Navigation object
        //in order to access the findNavController method
        //in older versions it was a method accessible for every view
        binding.playButton.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_titleFragment_to_gameFragment)
        }

        //add an options menu
        setHasOptionsMenu(true)

        //this contains the inflated view
        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.onNavDestinationSelected(item,
            Navigation.findNavController(view!!)) || super.onOptionsItemSelected(item)
    }
}