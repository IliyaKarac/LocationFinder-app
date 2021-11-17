# LocationFinder-app

To install the app download the zip file and import the project into android studios.
Run the code and it will build the app.

The app has 50 default locaions that can be used to populate the database.
To do this uncomment the populate_db() line in main activity.java.
Be sure to make it a comment before running the code a second time.
On the top of the main activity there is a search bar that expects an address.
Type in an address and press search to receive the latitude and longitude of that address.
On the bottom are 3 buttons that will take you to a different activity.

Add will take you to a page that accepts an id, address, latitude, and longitude.
Input an int a string and 2 doubles to add this location to the db.

Delete takes you to a page that only accepts an id.
Enter an id and press the button to delete a location from the db.

Update will take you to a page that accepts an id, address, latitude, and longitude.
The id you enter must be in the database already.
The other 3 fields are used to update the database.
