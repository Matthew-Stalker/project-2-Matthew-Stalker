# ShapeFactoryReadMe

## Overview
This project is an interactive Java console application designed to model, analyze, and compare various three-dimensional geometric shapes. It calculates the surface area and volume of different shapes and determines their spatial efficiency.

The application architecture demonstrates core Object-Oriented Programming (OOP) principles, utilizing abstract base classes, inheritance, polymorphism, and creational design patterns to build a robust and easily extensible system.

## Project Structure
The source code is organized into a primary package and a sub-package to cleanly separate the executable drivers from the shape definitions:

* `src/main/java/com/csc205/project2/`
    * `ShapeDriver.java` - The original interactive console application.
    * `ShapeFactoryDriver.java` - An advanced driver demonstrating the Factory Pattern.
    * `shapes/`
        * `ThreeDimensionalShape.java` - The foundational interface.
        * `Shape3D.java` - The abstract base class providing shared properties.
        * `Sphere.java`, `Cube.java`, `Cylinder.java`, `RectangularPrism.java`, `Tetrahedron.java` - Concrete shape implementations.
        * `ShapeFactory.java` - A centralized factory for instantiating shapes.



## Core Concepts & OOP Patterns

### 1. Polymorphism & Inheritance
The project relies heavily heavily on polymorphism. The `Shape3D` abstract class implements the `ThreeDimensionalShape` interface, establishing a strict contract that all concrete shapes must follow (`getSurfaceArea()` and `getVolume()`).
Because of this inheritance structure, the driver classes can store entirely different shapes (like a `Sphere` and a `Cube`) inside a single `List<Shape3D>`. The application can iterate through this list and call methods on the objects dynamically at runtime without needing to know their specific types.

### 2. The Factory Pattern
The `ShapeFactory.java` class implements the Factory creational design pattern. Instead of using the `new` keyword directly inside the driver classes, the application passes the desired `Class` type and its physical dimensions to the Factory.
By centralizing instantiation, the Factory pattern keeps the driver classes clean and helps adhere to core SOLID design concepts—particularly the Single Responsibility Principle—by entirely separating the logic of object creation and validation from the main application flow.

### 3. Graceful Error Handling
Both the concrete shape classes and the `ShapeFactory` include built-in input validation. Attempting to create a shape with negative dimensions, or passing an incorrect number of dimensions to the factory (e.g., passing two dimensions for a Cube), will immediately throw an `IllegalArgumentException` with a clear, descriptive error message.

---

## How to Run the Application

1. Open the project in your preferred Java IDE (IntelliJ IDEA, Eclipse, VS Code).
2. Navigate to `src/main/java/com/csc205/project2/`.
3. Right-click on `ShapeFactoryDriver.java` and select **Run**.
4. Follow the on-screen console prompts to dynamically build custom shapes, view their properties, and run the comparative analysis engine.

## How to Run the Test Suite

The project includes a comprehensive JUnit 5 test suite located in the `src/test/java/` directory. It covers basic functionality, calculation accuracy, boundary testing (zero values), input validation, and factory instantiation.

**Using Maven:**
If you are running the project via the terminal or command line, simply execute:
```bash
mvn clean test