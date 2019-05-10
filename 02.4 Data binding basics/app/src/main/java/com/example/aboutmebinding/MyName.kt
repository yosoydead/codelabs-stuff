package com.example.aboutmebinding

/*
* you can take advantage of data binding to make a data class directly available to a view
* for this example, instead of setting the name and nickname using string resources, you create
*   a data class for the name and nickname. You make the data class available to the view using
*   data binding
* */
data class MyName(var name: String = "", var nickname: String = "") {
}