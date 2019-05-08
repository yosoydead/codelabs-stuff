* Change an app
    * Open the DiceRoller app. Add a button to the app labeled "Reset" that appears just below the Roll button. Have that button reset the result text view to 0. -> **done**

* Answer these questions
    * Question 1: Which method on an Activity inflates the app's layout and makes its views available as objects?
        - onCreate()
        - setClickListener()
        - setContentView() -> **answer**
        - show()
    * Question 2: Which view attribute do you use to set the width of a view so that it adjusts to fit the content?
        - android:view_width="wrap"
        - android:layout_width="wrap_content" -> **answer**
        - android:layout_height="wrap_content"
        - android:layout_width="match_parent"
        

* Check to make sure the app has the following:
    - The app layout should include one text view and two buttons. --> **yes**
    - The app's code should set two click handlers, one for each button. --> **yes**
    - The click handler that resets the text view should set the text property to 0. --> **yes**