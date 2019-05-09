package com.example.aboutmeextend

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var nicknameText: TextView
    private lateinit var doneButton: Button


    /*
    * create a click listener for the done button
    *   - get the text from the nickname_edit
    *   - set the text to nickname_text
    *   - hide the edit text and the button
    *   - display the nickname textView
    *   - hide the keyboard after the button has been pressed.
    *       by default it stays visible even after the button is pressed
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //grabbing each neeede component
        editText = findViewById(R.id.nickname_edit)
        nicknameText = findViewById(R.id.nickname_text)
        doneButton = findViewById(R.id.done_button)

        //setting the onclick listener
        doneButton.setOnClickListener { addNickname(this) }
    }

    /*
    * answer to how to hide the keyboard after i press the done button
    * https://stackoverflow.com/questions/1109022/close-hide-the-android-soft-keyboard
    * */
    private fun addNickname(activity: Activity){
        val currentView = activity.currentFocus

        //grabbing the value of edit text
        val text = editText.text

        //making the invisible textView visible and its text = editText
        nicknameText.text = text.toString()
        nicknameText.visibility = View.VISIBLE

        //making the button and editText invisible
        editText.visibility = View.GONE
        doneButton.visibility = View.GONE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentView.windowToken, 0)
    }
}
