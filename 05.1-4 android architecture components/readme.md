* This app will be part of 4 codelabs:
    * 1. ViewModel and ViewModelFactory
    * 2. LiveData and LiveData observers
    * 3. Data binding with ViewModel and LiveData
    * 4. LiveData transformations
* Part 1 will be about:
    - use of the **ViewModel** to store and manage UI-related data (ViewModel allows data to survive device-config changes)
    - use of the **ViewModelFactory** to instantiate and return the ViewModel object that survives config changes
    - a **ViewModel** can do simple calculations and transformations on data to prepare it to be displayed by the UI controller
    - to create a **ViewModel** that does not get recreated every time an activity/fragment is destroyed, you have to use something called **ViewModelProvider**
