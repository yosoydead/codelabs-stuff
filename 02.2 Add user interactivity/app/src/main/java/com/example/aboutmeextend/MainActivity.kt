package com.example.aboutmeextend

import android.app.Activity
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
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
    *
    *  create a click listener for the nickname_text so it shows the editText and button again
    *
    * */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //grabbing each neeede component
        editText = findViewById(R.id.nickname_edit)
        nicknameText = findViewById(R.id.nickname_text)
        doneButton = findViewById(R.id.done_button)

        //an event listener so when the enter key on the keyboard is pressed,
        //it acts like the done_button was clicked
        editText.setOnKeyListener(object: View.OnKeyListener{
            override fun onKey(v: View?, keyCode: Int, event: KeyEvent?): Boolean {
                if(event?.action == KeyEvent.ACTION_DOWN){
                    when(keyCode){
                        KeyEvent.KEYCODE_ENTER -> {
                            addNickname(this@MainActivity)
                            return true
                        }
                    }
                }
                return false
            }

        })

        //setting the onclick listener
        doneButton.setOnClickListener { addNickname(this) }

        nicknameText.setOnClickListener { updateNickname(it) }
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

    //give a view as parameter so i know what im working with/which view calls this method
    private fun updateNickname(view: View){
        //make the button and editTextView visible again
        editText.visibility = View.VISIBLE
        doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        //make the ediText focused
        editText.requestFocus()


        //show the keyboard instantly, not after a second tap
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(editText, 0)
    }
}
