user-app
========

The user-app program allows the user to perform basic CRUD operations on
a MySQL database. Current functionality includes:

-   Creating an email address
-   Reading database entries
-   Updating database entries
-   Deleting database entries

Getting Started
---------------

These instructions will get you a copy of the project up and running on
your local machine for development and testing purposes.

### Prerequisites

Ensure you have Java 8 or higher installed on your machine. To check,
run the following on the command line:

`java --version`8

If you do not have Java installed, you should get a prompt to do so.
Once installed,

you should also have access to `javac`. You can check this by running:

`javac --version`8

### Running user-app

Run these commands in your terminal to test the program is working
correctly.

    javac src/com/ciaran/user/servlets/CreateUserServlet.java
    javac src/com/ciaran/user/servlets/DeleteUserServlet.java
    javac src/com/ciaran/user/servlets/ReadUserServlet.java
    javac src/com/ciaran/user/servlets/UpdateUserServlet.java

    java CreateUserServlet.java
    java DeleteUserServlet.java
    java ReadUserServlet.java
    java UpdateUserServlet.java

Authors
-------

-   Ciaran McKenna

Contributing
------------

Pull requests are welcome. For major changes, please open an issue first
to discuss what you would like to change.

Please make sure to update tests as appropriate.

License
-------

[MIT](https://choosealicense.com/licenses/mit/)
