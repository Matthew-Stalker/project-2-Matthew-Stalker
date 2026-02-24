package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SphereTest {

    private static final double DELTA = 0.0001;

    // 1. Basic Functionality
    @Test
    void testBasicFunctionality() {
        Sphere sphere = new Sphere(5.0, "Red");
        assertEquals(5.0, sphere.getRadius(), "Getter should return the initialized radius.");
        assertEquals("Red", sphere.getColor());

        sphere.setRadius(7.5);
        assertEquals(7.5, sphere.getRadius(), "Setter should update the radius.");
    }

    // 2. Calculation Accuracy
    @Test
    void testCalculationAccuracy() {
        Sphere sphere = new Sphere(3.0, "Blue");
        // Volume = 4/3 * PI * 3^3 = 113.0973355
        assertEquals(113.0973, sphere.getVolume(), DELTA, "Volume calculation is incorrect.");
        // Surface Area = 4 * PI * 3^2 = 113.0973355
        assertEquals(113.0973, sphere.getSurfaceArea(), DELTA, "Surface Area calculation is incorrect.");
    }

    // 3. Boundary Testing
    @Test
    void testBoundaryZeroValues() {
        // Decision: A shape with zero dimensions is treated as a point in space. Area and volume should be 0.
        Sphere sphere = new Sphere(0.0, "Clear");
        assertEquals(0.0, sphere.getVolume(), DELTA);
        assertEquals(0.0, sphere.getSurfaceArea(), DELTA);
    }

    // 4. Input Validation
    @Test
    void testInputValidationNegativeValues() {
        Sphere sphere = new Sphere();
        assertThrows(IllegalArgumentException.class, () -> {
            sphere.setRadius(-5.0);
        }, "Setting a negative radius should throw an exception.");
    }

    // 5. Inheritance Testing
    @Test
    void testPolymorphicBehavior() {
        Shape3D shape = new Sphere(2.0, "Green");
        // Verify we can call interface methods via the abstract base class reference
        assertTrue(shape.getVolume() > 0);
        assertTrue(shape.getSurfaceArea() > 0);
        assertEquals("Green", shape.getColor());
        assertEquals("Sphere", shape.getName());
    }
}
