* This code will be for 06.1 and 06.2 modules
* In Android, data is represented in data classes  (data is modified/accessed through function calls)
* In a database, data represents an **entity** and it is accessed through **queries**
    - an **entity** represents an object and its properties to store in the database. An entity class defines a table, each instance of that class represents a row in the table. Each property defines a column
    - a **query** is a request for data or information from a database table or a request to perform an action on the data
* **Room** is a framework that does all the hard work of getting from data classes to entities that can be stored in **SQLite** and from function declarations to **SQL queries**
* Each **entity** must be defined as an annotated *data class* and the **interactions** as an annotated *interface*. **Room** uses these annotated classes to create tables in the database and queries that act on the database.
* **DAO** provides convenience methods for inserting, deleting and updating the database. It is defined as an *interface* using annotations
* To create a database from the **entity** and the **dao**, an abstract class annotated **@Database** needs to be created. This class has one method that either creates an instance of the database if it doesn't exist or returns a reference to an existing database. This class needs to inherit from **RoomDatabase** and will act as a database holder. The app needs only **one** instance of the database for the whole app.
