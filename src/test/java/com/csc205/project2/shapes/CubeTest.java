package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

 class CubeTest {

    private static final double DELTA = 0.0001;

    // 1. Basic Functionality
    @Test
    void testBasicFunctionality() {
        Cube cube = new Cube(4.0, "Blue");
        assertEquals(4.0, cube.getSideLength());
        cube.setSideLength(6.0);
        assertEquals(6.0, cube.getSideLength());
    }

    // 2. Calculation Accuracy
    @Test
    void testCalculationAccuracy() {
        Cube cube = new Cube(3.0, "Red");
        assertEquals(27.0, cube.getVolume(), DELTA);
        assertEquals(54.0, cube.getSurfaceArea(), DELTA);
    }

    // 3. Boundary Testing
    @Test
    void testBoundaryZeroValues() {
        Cube cube = new Cube(0.0, "Clear");
        assertEquals(0.0, cube.getVolume(), DELTA);
        assertEquals(0.0, cube.getSurfaceArea(), DELTA);
    }

    // 4. Input Validation
    @Test
    void testInputValidationNegativeValues() {
        Cube cube = new Cube();
        assertThrows(IllegalArgumentException.class, () -> {
            cube.setSideLength(-3.0);
        });
    }

    // 5. Inheritance Testing
    @Test
    void testPolymorphicBehavior() {
        Shape3D shape = new Cube(5.0, "Yellow");
        assertEquals(125.0, shape.getVolume(), DELTA);
        assertEquals("Cube", shape.getName());
    }
}
