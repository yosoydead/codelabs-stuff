package com.example.aboutmebinding
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
import androidx.databinding.DataBindingUtil
import com.example.aboutmebinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //add a reference to the binding object so that it can access views
    //the type of binding, the ActivityMainBinding class, is created by the compiler specifically
        //for this main activity. The name is derived from the name of the layout file, that is,
        //activity_main + Binding
    private lateinit var binding: ActivityMainBinding

    /*
    * now, that you have a reference to the data in your layout, create the actual layout
    * create a private var called myName by convention. assign the var an instance of the MyName class
    * */
    private val myName: MyName = MyName(name="Radu Bogdan-Mircea")

//    private lateinit var editText: EditText
//    private lateinit var nicknameText: TextView
//    private lateinit var doneButton: Button


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
        //setContentView(R.layout.activity_main)

        //replace the setContentView function with an instruction that does the following:
            //creates the binding object
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        //set the value of myName var in the layout through the binding object because
        //you cant access xml directly
        binding.myName = myName
            //uses the setContentView function from the DataBindingUtil class to associate
            //the activity_main layout with the MainActivity. This setContentView() also
            //takes care of some data binding setup for the views

        //now you can replace all calls to findViewById() with the references to the views
        //that are in the binding object

        //grabbing each neeeded component
//        editText = findViewById(R.id.nickname_edit)
//        nicknameText = findViewById(R.id.nickname_text)
//        doneButton = findViewById(R.id.done_button)

        //an event listener so when the enter key on the keyboard is pressed,
        //it acts like the done_button was clicked
        binding.nicknameEdit.setOnKeyListener(object: View.OnKeyListener{
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
        binding.doneButton.setOnClickListener { addNickname(this) }

        binding.nicknameText.setOnClickListener { updateNickname(it) }
    }

    /*
    * answer to how to hide the keyboard after i press the done button
    * https://stackoverflow.com/questions/1109022/close-hide-the-android-soft-keyboard
    * */
    private fun addNickname(activity: Activity){
        val currentView = activity.currentFocus

        //grabbing the value of edit text
        val text = binding.nicknameEdit.text.toString()

        //making the invisible textView visible and its text = editText
        //binding.nicknameText.text = text
        myName?.nickname = text

        binding.apply {
            myName?.nickname = text
            invalidateAll()
        }
        binding.nicknameText.visibility = View.VISIBLE

        //making the button and editText invisible
        binding.nicknameEdit.visibility = View.GONE
        binding.nicknameEdit.visibility = View.GONE

        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(currentView.windowToken, 0)
    }

    //give a view as parameter so i know what im working with/which view calls this method
    private fun updateNickname(view: View){
        //make the button and editTextView visible again
        binding.nicknameEdit.visibility = View.VISIBLE
        binding.doneButton.visibility = View.VISIBLE
        view.visibility = View.GONE

        //make the ediText focused
        binding.nicknameEdit.requestFocus()


        //show the keyboard instantly, not after a second tap
        val inputMethodManager = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.showSoftInput(binding.nicknameEdit, 0)
    }
}