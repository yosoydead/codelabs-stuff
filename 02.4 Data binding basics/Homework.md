* Answer these questions
    * Question 1: Why do you want to minimize explicit and implicit calls to findViewById()?
        * Every time findViewById() is called, it traverses the view hierarchy. --> **answer**
        * findViewById() runs on the main or UI thread.
        * These calls can slow down the user interface. --> **answer**
        * Your app is less likely to crash.

    * Question 2: How would you describe data binding? For example, here are some things you could say about data binding:
        * The big idea about data binding is to create an object that connects/maps/binds two pieces of distant information together at compile time, so that you don't have to look for the data at runtime. --> **answer**
        * The object that surfaces these bindings to you is called the binding object.
        * The binding object is created by the compiler.

    * Question 3: Which of the following is NOT a benefit of data binding?
        * Code is shorter, easier to read, and easier to maintain.
        * Data and views are clearly separated.
        * The Android system only traverses the view hierarchy once to get each view.
        * Calling findViewById() generates a compiler error. --> **answer**
        * Type safety for accessing views.

    * Question 4: What is the function of the <layout> tag?
        * You wrap it around your root view in the layout.
        * Bindings are created for all the views in a layout.
        * It designates the top-level view in an XML layout that uses data binding.
        * You can use the <data> tag in inside a <layout> to bind a variable to a data class. --> **answer**

    * Question 5: Which is the correct way to reference bound data in the XML layout?
        * android:text="@={myDataClass.property}" --> **answer**
        * android:text="@={myDataClass}"
        * android:text="@={myDataClass.property.toString()}"
        * android:text="@={myDataClass.bound_data.property}"