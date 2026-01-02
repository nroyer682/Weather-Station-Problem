# Weather-Station-Problem

A Java-based object-oriented programming project that models a weather station system with connections to various weather applications.

## Overview

This project demonstrates fundamental OOP concepts through a weather station ecosystem where:
- Weather stations can connect to multiple weather applications
- Weather applications (Sensor Apps and Dummy Apps) can connect to multiple weather stations
- Connections are bidirectional and managed automatically
- Dynamic array resizing handles growing numbers of connections
- A singleton WeatherPerson class manages user-owned applications

## Project Structure

```
Weather_Station_Problem/
├── src/
│   ├── model/
│   │   ├── WeatherStation.java    # Weather station with dynamic app connections
│   │   ├── WeatherApp.java        # Abstract base class for weather apps
│   │   ├── SensorApp.java         # Sensor application implementation
│   │   ├── DummyApp.java          # Placeholder application implementation
│   │   └── WeatherPerson.java     # Singleton user class
│   └── tests/
│       └── StarterTests.java      # JUnit test suite
└── bin/                           # Compiled class files
```

## Class Descriptions

### WeatherStation
- Represents a weather station that can connect to multiple weather apps
- Initial capacity: 2 apps
- Auto-grows by 3 slots when capacity is reached (2 → 5 → 8 → 11...)
- Provides methods to retrieve all connected apps or only dummy apps
- Maintains bidirectional connections with apps

### WeatherApp (Abstract)
- Base class for all weather applications
- Manages connections to weather stations
- Subclasses: `SensorApp` and `DummyApp`

### SensorApp
- A functional weather sensor application
- Can connect to up to a specified number of weather stations
- Provides method to retrieve connected dummy apps of a specific station

### DummyApp
- A placeholder weather application (still in development)
- Can connect to up to a specified number of weather stations
- Provides basic toString functionality

### WeatherPerson
- Singleton pattern implementation
- Represents a user who owns weather applications
- Can manage up to 100 weather apps
- Tracks both sensor and dummy apps separately

## Features

- **Bidirectional Connections**: Connecting an app to a station automatically connects the station to the app
- **Dynamic Array Resizing**: Weather stations automatically expand capacity when needed
- **Type Filtering**: Retrieve only dummy apps from a station's connected apps
- **Singleton Pattern**: WeatherPerson uses singleton pattern for global user state
- **Polymorphism**: Weather apps demonstrate inheritance and dynamic typing

## Setup and Compilation

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- JUnit 4 for running tests

### Compilation

```bash
# Navigate to the project directory
cd Weather_Station_Problem

# Compile all source files
javac -d bin src/model/*.java

# Compile tests (ensure JUnit is in classpath)
javac -cp .:junit-4.13.2.jar:hamcrest-core-1.3.jar -d bin src/tests/*.java src/model/*.java
```

### Running Tests

```bash
# Run JUnit tests
java -cp bin:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.StarterTests
```

## Usage Examples

### Creating a Weather Station

```java
WeatherStation station = new WeatherStation("Station@NorthYork");
System.out.println(station);
// Output: Station@NorthYork has no connected apps.
```

### Creating Weather Apps

```java
// Create a sensor app with max 20 stations
SensorApp sensor = new SensorApp("Sensor1234", 20);

// Create a dummy app with max 60 stations
DummyApp dummy = new DummyApp("Dummy5678", 60);
```

### Connecting Apps to Stations

```java
// Connect apps to station (bidirectional)
station.connect(sensor);
station.connect(dummy);

System.out.println(station);
// Output: Station@NorthYork is connected by 2 apps: <Weather Sensor App Sensor1234, Weather Dummy App Dummy5678>.

System.out.println(sensor);
// Output: Weather Sensor App Sensor1234 is connected to 1 stations: <Station@NorthYork>.
```

### Using WeatherPerson

```java
WeatherPerson person = WeatherPerson.getInstance();
person.setName("Yuna");
person.addApp(sensor);
person.addApp(dummy);

System.out.println(person);
// Output: Yuna has 1 sensor apps and 1 dummy apps.
```

### Retrieving Dummy Apps

```java
// Get all dummy apps connected to a station
DummyApp[] dummies = station.getDummyApps();

// Get dummy apps connected to a specific station from a sensor
DummyApp[] connectedDummies = sensor.getConnectedDummysOf("Station@NorthYork");
```

## Key Design Patterns

1. **Singleton Pattern**: WeatherPerson class ensures only one instance exists
2. **Polymorphism**: WeatherApp subclasses (SensorApp, DummyApp) demonstrate inheritance
3. **Dynamic Arrays**: Automatic resizing when capacity is exceeded
4. **Bidirectional Associations**: Apps and stations maintain references to each other

## Testing

The project includes comprehensive JUnit tests in `StarterTests.java` covering:
- Weather station creation and app management
- Sensor and dummy app creation
- Connection establishment (bidirectional)
- Dynamic array resizing
- Dummy app filtering
- WeatherPerson singleton behavior
- Edge cases (empty arrays, invalid stations)

Run all tests using:
```bash
java -cp bin:junit-4.13.2.jar:hamcrest-core-1.3.jar org.junit.runner.JUnitCore tests.StarterTests
```

## Implementation Notes

- Weather stations initially support 2 apps, growing by 3 slots when full
- No error handling for exceeding preset maximums (ArrayIndexOutOfBoundsException will occur)
- Apps cannot be added to the same station twice (assumption)
- WeatherPerson can manage up to 100 apps (assumption: never exceeded)
- toString methods use specific formatting (e.g., "1 apps", "2 apps" - grammatically simplified)

## License

This is an educational project for demonstrating OOP concepts.

## Author

nroyer682