package com.csc205.project2.shapes;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ShapeFactoryTest {

    // 1. Successful Creation Tests
    @Test
    public void testCreateSphereSuccess() {
        Shape3D shape = ShapeFactory.create(Sphere.class, "Red Ball", 5.0);
        assertInstanceOf(Sphere.class, shape);
        assertEquals("Red Ball", shape.getName());
        assertEquals(5.0, ((Sphere) shape).getRadius());
    }

    @Test
    public void testCreateCylinderSuccess() {
        Shape3D shape = ShapeFactory.create(Cylinder.class, "Pipe", 2.0, 10.0);
        assertInstanceOf(Cylinder.class, shape);
        assertEquals("Pipe", shape.getName());
        assertEquals(2.0, ((Cylinder) shape).getRadius());
        assertEquals(10.0, ((Cylinder) shape).getHeight());
    }

    @Test
    public void testCreateRectangularPrismSuccess() {
        Shape3D shape = ShapeFactory.create(RectangularPrism.class, "Box", 2.0, 3.0, 4.0);
        assertInstanceOf(RectangularPrism.class, shape);
        assertEquals("Box", shape.getName());
        assertEquals(2.0, ((RectangularPrism) shape).getLength());
        assertEquals(3.0, ((RectangularPrism) shape).getWidth());
        assertEquals(4.0, ((RectangularPrism) shape).getHeight());
    }

    // 2. Graceful Error Handling Tests
    @Test
    public void testInvalidDimensionCount() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            // A cube only takes 1 dimension, passing 2 should fail
            ShapeFactory.create(Cube.class, "Bad Cube", 5.0, 10.0);
        });
        assertTrue(exception.getMessage().contains("requires exactly 1 dimension(s)"));
    }

    @Test
    public void testNegativeDimensions() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(Sphere.class, "Negative Sphere", -5.0);
        });
        assertEquals("Dimensions cannot be negative.", exception.getMessage());
    }

    @Test
    public void testNullClassInput() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ShapeFactory.create(null, "Ghost Shape", 5.0);
        });
        assertEquals("Shape class cannot be null.", exception.getMessage());
    }

    @Test
    public void testOptionalNamingBehavior() {
        Shape3D shape = ShapeFactory.create(Cube.class, "", 3.0);
        // It should fallback to the default name established in the Cube constructor
        assertEquals("Cube", shape.getName());
    }
}