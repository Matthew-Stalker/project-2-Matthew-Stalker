
AI GENERATION DOCUMENTATION
===========================
****Class Name: Shape3D**
AI Tool Used: Gemini 3.1Pro
Generation Date: 02/23/2026**


[Original Prompt:]
Create an Abstract Base class in Java named Shape3D.java that follows the following steps:
1. Implements this interface:
package com.csc205.project2.shapes;

public interface ThreeDimensionalShape {

    double getSurfaceArea();
    double getVolume();

}
2. Concrete implementations of getVolume() and getSurfaceArea() that call the abstract methods.
3. Common properties such as name and color with getters and setters.
4. Constructors for initialization.
5. A toString() method that formats information consistently and correctly.
6. Any other getters and setters as appropriate.

[Follow-up Prompts:]
1. None

[Manual Modifications:]
- None

=======================================================================

**Class Name(s): Cube, Cylinder, RectangularPrism, Sphere, Tetrahedron**
AI Tool Used: Gemini 3.1Pro
Generation Date: 02/23/2026


[Original Prompt:]
Now I would like you to create five concrete shape classes for each of the following:
1. Sphere - properties: radius
2. Cube - properties: sideLength
3. Cylinder - properties: radius, height
4. RectangularPrism - properties: length, width, height
5. Tetrahedron - properties: sideLength

[Follow-up Prompts:]
1. "Provide the updated Java code for the shape classes so that they throw the IllegalArgumentException required to make the Input Validation tests pass"


[Manual Modifications:]
- None

Formula Verification: Can be a calculator, textbook, or online resource.
- Volume formulas verified against: sciencenotes.org, omnicalculator.com, copilot.com
- Surface area formulas verified against: sciencenotes.org, omnicalculator.com, copilot.com
=======================================================================

**Class Name(s): CubeTest, CylinderTest, RectangularPrismTest, SphereTest, TetrahedronTest**
AI Tool Used: Gemini 3.1Pro
Generation Date: 02/23/2026


[Original Prompt:]
Next, for each shape class, generate JUnit 5 test classes that include these Test Categories:

1. Basic Functionality: Constructor, getters, setters
2. Calculation Accuracy: Volume and surface area with known values
3. Boundary Testing: Zero values, very small/large numbers
4. Input Validation: Negative values, null inputs
5. Inheritance Testing: Polymorphic behavior verification

Here is an example for the Sphere class:
// Test with known mathematical results
@Test void sphereVolumeCalculation() {
// Volume of sphere with radius 3 should be 4/3 * π * 3³ = 113.097...
}

// Test boundary conditions
@Test void sphereWithZeroRadius() {
// What should happen? Document your decision.
}

// Test polymorphism
@Test void sphereAsShape3D() {
// Verify it works when treated as Shape3D reference
}

[Follow-up Prompts (if any):]
1. "[Prompts to solve test class issues]"
- Do these test files need to be in a different package? I'm getting an error when I run CubeTest of "DiscoveryIssueException".
- How do I create a test class if it doesn't exist?
- I'm still getting "org.junit.platform.launcher.core.DiscoveryIssueException: TestEngine with ID 'junit-jupiter' encountered 5 critical issues during test discovery:"
- These are my current maven pom dependencies *copied and pasted the dependencies*

[Manual Modifications:]
1. I didn't have a test package in my fork, so I put the test classes in the same package as the shape classes. 
This prompted the IDE to tell me I needed something different in the maven dependencies and added a dependency for JUnit 5 in the pom.xml file 
but with a scope as compile. So I needed to change the pom file to a test scope for the JUnit dependency with the help of my AI assistant.
=======================================================================

**Class Name: ShapeDriver**
AI Tool Used: Gemini 3.1Pro
Generation Date: 02/23/2026

[Original Prompt:]
I sorted out all the dependency issues. It compiles, runs, and passes all the tests.

Now I need an advanced driver class called ShapeDriver.java that demonstrates the following:

Polymorphism: Array/List of Shape3D references holding different shapes
Comparative Analysis: Which shape has the largest volume for given constraints?
Interactive Features: Allow the user to create shapes with custom parameters
Performance Timing: Measure calculation speeds (optional)
Formatted Output: Professional presentation of results

[Follow-up Prompts:]
1. "The driver class actually needs to be in the project2 package and not in the shapes package so adjust the code in the driver class to reflect this."
2. AI asked:
Would you like me to help you add the remaining three shapes (Cylinder, Rectangular Prism, and Tetrahedron) into the interactive creation menu?
3. Yes, but also include the largest surface area and the most efficient shape by dividing volume by surface area.
4. In the driver class, can you also allow the user to set the color and name of the custom shape they design?

[Shape Factory Pattern Prompts & Interaction]
Prompt: Can you explain to me what an OOP factory pattern is? Then, implement a factory pattern that creates shapes from Class and string/dimension inputs.
For example:
Shape3D shape = ShapeFactory.create(Sphere.class, "Red Ball", 5.0);

Meet the following requirements as well:
1. Ensure the factory handles invalid inputs gracefully
2. Include a test suite for the factory method

Follow-up prompt: Could you create a new driver class called ShapeFactoryDriver that utilizes the new shape factory code instead of the constructors?
Follow-up prompt: Can you create a ReadMe for the new Driver class?