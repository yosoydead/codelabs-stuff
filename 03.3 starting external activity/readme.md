* This module uses the files from the android trivia app (module 03.1 and 03.2).
* My android trivia app combined both 03.1 and 03.2 modules because it wasn't working at first and I had to scrap it and re-do it.
	* **Note** that my version of the trivia app from 03.1 uses a newer version of the navigation and navigatioUI components so the code will differ a bit.
* For the purpose of this module, I downloaded the needed files from codelabs.
* To pass data from  fragment A to fragment B we need some parameters.
	* One way of sending data between fragments is to use the apps **Bundle** which is a key-value data structure. By using this method, some errors might occur:
		1. Type mis-match error. Say you send a string from A and B requests an int. The default value when requesting is 0 and this kind of type mis-match can make the app behave in an unexpected manner or just crash.
		2. Missing key errors. If B requests an argument that isn't set in the bundle, this operation returns **null**. This would not throw an error at compile time but might cause severe problems when the user runs the app.
	* Another way would be to just catch these errors.
	* Android's navigation architecture components can help with these problems because they include a feature called **Safe Args**. This is a plugin that generates code and classes that help detect errors at compile-time that might not have happened until the app runs.
* In this module, I'll add a **share** icon to the top of the **Congratulations** screen. This icon lets the user share their result in an email or text.
	* The generated classes after installing the safe args plugin are located in the **generatedJava** directory.
	* By changing the argument provided to the **findNavController().navigate()** method to the stuff provided by the **FragmentDirections** classes does not change the functionality of the app. It just provides a safe way to pass data between fragments.
