package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TetrahedronTest {

    private static final double DELTA = 0.0001;

    // 1. Basic Functionality
    @Test
    void testBasicFunctionality() {
        Tetrahedron tetra = new Tetrahedron(5.0, "Green");
        assertEquals(5.0, tetra.getSideLength());
    }

    // 2. Calculation Accuracy
    @Test
    void testCalculationAccuracy() {
        Tetrahedron tetra = new Tetrahedron(3.0, "Green");
        // Vol = 3^3 / (6 * sqrt(2)) = 3.18198
        assertEquals(3.1820, tetra.getVolume(), DELTA);
        // SA = sqrt(3) * 3^2 = 15.58845
        assertEquals(15.5885, tetra.getSurfaceArea(), DELTA);
    }

    // 3. Boundary Testing
    @Test
    void testBoundaryZeroValues() {
        Tetrahedron tetra = new Tetrahedron(0.0, "Clear");
        assertEquals(0.0, tetra.getVolume(), DELTA);
        assertEquals(0.0, tetra.getSurfaceArea(), DELTA);
    }

    // 4. Input Validation
    @Test
    void testInputValidationNegativeValues() {
        Tetrahedron tetra = new Tetrahedron();
        assertThrows(IllegalArgumentException.class, () -> tetra.setSideLength(-4.0));
    }

    // 5. Inheritance Testing
    @Test
    void testPolymorphicBehavior() {
        Shape3D shape = new Tetrahedron(4.0, "Pink");
        assertTrue(shape.getSurfaceArea() > 0);
        assertInstanceOf(Shape3D.class, shape);
    }
}