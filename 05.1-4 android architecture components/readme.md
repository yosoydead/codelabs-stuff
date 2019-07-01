* This app will be part of 4 codelabs:
    * 1. ViewModel and ViewModelFactory
    * 2. LiveData and LiveData observers
    * 3. Data binding with ViewModel and LiveData
    * 4. LiveData transformations
* Part 1 will be about:
    - use of the **ViewModel** to store and manage UI-related data (ViewModel allows data to survive device-config changes)
    - use of the **ViewModelFactory** to instantiate and return the ViewModel object that survives config changes
    - a **ViewModel** can do simple calculations and transformations on data to prepare it to be displayed by the UI controller
    - to create a **ViewModel** that does not get recreated every time an activity/fragment is destroyed, you have to use something called **ViewModelProvider**. The **ViewModelProvider** returns an existing **ViewModel** if one exists, or it creates a new one if it does not already exist
    - The **ViewModel** should never contain references to fragments, activities or views because views, activities, fragments  do not survive config changes
* Part 2:
    - **LiveData** is an observable data holder class that is lifecycler aware. This means that the observer is notified when data held by the **LiveData** object changes
    - **LiveData** holds data. It is a wrapper that can be used with any data
    - It only updates observers that are in an active lifecycler state such as **Started** or **Resumed**
    - **!!!** data in a **MutableLiveData** object can be changed from outside its class
    - **!!!** data in a **LiveData** object can be read from outside its class, but **not** changed. From outside the **ViewModel**, data should be readable, but not editable.
