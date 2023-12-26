Building Information Analyzer
Overview
This Kotlin program is designed to analyze building information stored in CSV and XML files. The program reads data about buildings, including city, street, house number, and number of floors. It then performs analysis to identify duplicate entries and provides statistics on floors by city.

Code Structure
Building.kt
Defines the data class Building to represent the structure of building information with properties: city, street, house number, and number of floors.

CSV.kt
Contains the CSV class with a method readCsv to read building information from a CSV file. It returns a list of Building objects.

XML.kt
Includes the XML class with a method readXml to read building information from an XML file. It returns a list of Building objects.

Interface.kt
Implements the Interface class responsible for user interaction. Users provide the file path, and the program determines the file type (CSV or XML). It then reads the data, identifies duplicates, and provides statistics on floors by city.

Main.kt
The main entry point of the program. It creates an instance of the Interface class and iteratively interacts with the user until the user enters "stop."

Usage
Run the program.
Enter the file path of the CSV or XML file when prompted.
The program will analyze the data, identify duplicates, and provide floor statistics by city.
Repeat or enter "stop" to exit.
Dependencies
Kotlin
Java XML and File I/O libraries
Notes
The program supports CSV and XML file formats.
Duplicate buildings are identified based on equality of all fields.
Floor statistics are presented in a tabular format, showing the number of buildings for each floor in each city.
Example
bash
Copy code
Enter file path (To stop, enter 'stop'):
C:\Users\artem\Documents\address.csv
Time: 1534 ms
Duplicates
...
Floor statistics by City
...
Enter file path (To stop, enter 'stop'):
C:\Users\artem\Documents\address.xml
Time: 748 ms
Duplicates
...
Floor statistics by City
...
Enter file path (To stop, enter 'stop'):
stop
Feel free to explore and adapt the code to suit your specific needs.
