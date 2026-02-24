package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CylinderTest {

    private static final double DELTA = 0.0001;

    // 1. Basic Functionality
    @Test
    void testBasicFunctionality() {
        Cylinder cylinder = new Cylinder(2.0, 5.0, "Orange");
        assertEquals(2.0, cylinder.getRadius());
        assertEquals(5.0, cylinder.getHeight());
    }

    // 2. Calculation Accuracy
    @Test
    void testCalculationAccuracy() {
        Cylinder cylinder = new Cylinder(2.0, 5.0, "Orange");
        // Vol = PI * 2^2 * 5 = 62.8318
        assertEquals(62.8318, cylinder.getVolume(), DELTA);
        // SA = 2*PI*2*5 + 2*PI*2^2 = 87.9645
        assertEquals(87.9645, cylinder.getSurfaceArea(), DELTA);
    }

    // 3. Boundary Testing
    @Test
    void testBoundaryZeroValues() {
        Cylinder cylinder = new Cylinder(0.0, 5.0, "Clear");
        assertEquals(0.0, cylinder.getVolume(), DELTA);
        // Even with height, a 0 radius means 0 volume and surface area
        assertEquals(0.0, cylinder.getSurfaceArea(), DELTA);
    }

    // 4. Input Validation
    @Test
    void testInputValidationNegativeValues() {
        Cylinder cylinder = new Cylinder();
        assertThrows(IllegalArgumentException.class, () -> cylinder.setRadius(-2.0));
        assertThrows(IllegalArgumentException.class, () -> cylinder.setHeight(-5.0));
    }

    // 5. Inheritance Testing
    @Test
    void testPolymorphicBehavior() {
        Shape3D shape = new Cylinder(1.0, 1.0, "Purple");
        assertEquals(Math.PI, shape.getVolume(), DELTA);
        assertInstanceOf(ThreeDimensionalShape.class, shape);
    }
}
