Hotel Management System
Overview
The Hotel Management System is a console-based Java application designed to manage room bookings and food orders in a hotel. It allows users to check room features, availability, book rooms, order food, and deallocate rooms. The application includes common Kenyan dishes for food orders and provides different pricing for both rooms and food.
User Information
Before accessing the main functionalities of the hotel management system, users are prompted to enter their personal information. The following details are collected:

Name:

Input: The user must provide their full name.
Validation: The name should only contain letters and spaces.
Gender:

Input: The user can select their gender from the following options:
Male
Female
Other
Validation: The input must match one of the options exactly.
Phone Number:

Input: The user must enter their phone number.
Validation: The phone number must consist of exactly 10 digits.
Email:

Input: The user must enter their email address.
Validation: The email must follow a standard format (e.g., user@example.com) and have a top-level domain of at least two characters.
Features
Check Room Features: Displays the features of a specific room, including bed size and amenities.
Check Room Availability: Allows users to check if a room is available for booking.
Book Room: Users can book a room by specifying the room number, with automatic payment calculation.
Order Food: Users can choose from a variety of Kenyan dishes, with each dish priced accordingly.
Deallocate Room: Allows for deallocating a room, marking it as available again.
Unique Room Features: Each room has unique features based on its number, including different bed sizes.
Technologies Used
Java (JDK 8 or higher)
Installation
Clone the Repository:

bash
Copy code
git clone <repository-url>
cd <repository-directory>
Compile the Program: Ensure you have Java installed on your machine. Compile the Java program using:

bash
Copy code
javac Main.java
Run the Program: After successful compilation, run the program using:

bash
Copy code
java Main
Usage
Choose an Option: After launching the application, you will be presented with a menu to choose from:

1: Check Features
2: Check Availability
3: Book Room
4: Order Food
5: Deallocate Room
6: Exit
Input Room Number: For options that require room details, input the room number as prompted.

Food Order: For ordering food, choose from the provided menu options of Kenyan dishes.

Payment Information: The system will automatically calculate and display the total payment required for room booking or food orders.

Continue or Exit: After completing an operation, you can choose to continue with another action or exit the application.

Example
Here’s a brief example of how the program might operate:

plaintext
Copy code
1. Check Features
2. Check Availability
3. Book Room
4. Order Food
5. Deallocate Room
6. Exit
Choose an option: 1
Room Number - 5
Features of Room 5: Room Number: 5, Bed Size: King Size, Wi-Fi, TV, AC
Contributions
Contributions are welcome! Feel free to fork the repository, make changes, and submit a pull request.

License
This project is licensed under the MIT License - see the LICENSE file for details.

Acknowledgments
Thanks to the community for their support and feedback.
