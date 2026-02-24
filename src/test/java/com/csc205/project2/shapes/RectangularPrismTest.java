package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class RectangularPrismTest {

    private static final double DELTA = 0.0001;

    // 1. Basic Functionality
    @Test
    void testBasicFunctionality() {
        RectangularPrism prism = new RectangularPrism(2.0, 3.0, 4.0, "Black");
        assertEquals(2.0, prism.getLength());
        assertEquals(3.0, prism.getWidth());
        assertEquals(4.0, prism.getHeight());
    }

    // 2. Calculation Accuracy
    @Test
    void testCalculationAccuracy() {
        RectangularPrism prism = new RectangularPrism(2.0, 3.0, 4.0, "Black");
        assertEquals(24.0, prism.getVolume(), DELTA);
        assertEquals(52.0, prism.getSurfaceArea(), DELTA); // 2(6 + 8 + 12)
    }

    // 3. Boundary Testing
    @Test
    void testBoundaryZeroValues() {
        // If any dimension is 0, volume is 0
        RectangularPrism prism = new RectangularPrism(2.0, 3.0, 0.0, "Clear");
        assertEquals(0.0, prism.getVolume(), DELTA);
        // Surface area is just 2 * (l * w) if h is 0
        assertEquals(12.0, prism.getSurfaceArea(), DELTA);
    }

    // 4. Input Validation
    @Test
    void testInputValidationNegativeValues() {
        RectangularPrism prism = new RectangularPrism();
        assertThrows(IllegalArgumentException.class, () -> prism.setLength(-1.0));
    }

    // 5. Inheritance Testing
    @Test
    void testPolymorphicBehavior() {
        Shape3D shape = new RectangularPrism(1.0, 1.0, 1.0, "White");
        assertEquals(1.0, shape.getVolume(), DELTA);
        assertEquals("Rectangular Prism", shape.getName());
    }
}
