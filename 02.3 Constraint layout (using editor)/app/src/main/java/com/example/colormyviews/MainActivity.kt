package com.example.colormyviews

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //create all the click listeners when the main view is created
        setListeners()
    }

//    make a function makeColored. use a view as parameter
    private fun makeColored(view: View){
        //depending on the view passed as parameter, set a color
        when(view.id){
            R.id.box_one_text -> view.setBackgroundColor(Color.DKGRAY)
            R.id.box_two_text -> view.setBackgroundColor(Color.GRAY)
            R.id.box_three_text -> view.setBackgroundColor(Color.BLUE)
            R.id.box_four_text -> view.setBackgroundColor(Color.MAGENTA)
            R.id.box_five_text -> view.setBackgroundColor(Color.BLUE)
            else -> view.setBackgroundColor(Color.LTGRAY)
        }
    }

    //add a function called setListeners to set click-listeners for each view
    //use findViewById to get a reference to each textView
    private fun setListeners(){
        val boxOne = findViewById<TextView>(R.id.box_one_text)
        val boxTwo = findViewById<TextView>(R.id.box_two_text)
        val boxThree = findViewById<TextView>(R.id.box_three_text)
        val boxFour = findViewById<TextView>(R.id.box_four_text)
        val boxFive = findViewById<TextView>(R.id.box_five_text)

        val root = findViewById<View>(R.id.constraint_layout)

        //define a list that holds the views from above
        val views: List<View> = listOf(boxOne, boxTwo, boxThree, boxFour, boxFive, root)

        //loop through each view and set a click listener to it
        for(item in views){
            item.setOnClickListener{ makeColored(it) }
        }

    }
}
