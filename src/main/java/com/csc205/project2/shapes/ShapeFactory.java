package com.csc205.project2.shapes;

public class ShapeFactory {

    /**
     * Creates a Shape3D object based on the provided class type and dimensions.
     *
     * @param shapeClass The class of the shape to create (e.g., Sphere.class)
     * @param name       The custom name for the shape (can be null or empty)
     * @param dimensions The physical dimensions required for the specific shape
     * @return A constructed Shape3D object
     * @throws IllegalArgumentException if inputs are invalid or dimensions don't match the shape
     */
    public static Shape3D create(Class<? extends Shape3D> shapeClass, String name, double... dimensions) {
        if (shapeClass == null) {
            throw new IllegalArgumentException("Shape class cannot be null.");
        }
        if (dimensions == null) {
            throw new IllegalArgumentException("Dimensions array cannot be null.");
        }

        Shape3D shape = null;

        // Route creation based on the class type and validate dimension counts
        if (shapeClass == Sphere.class) {
            validateDimensions(dimensions, 1, "Sphere");
            shape = new Sphere(dimensions[0], "Undefined");
        } else if (shapeClass == Cube.class) {
            validateDimensions(dimensions, 1, "Cube");
            shape = new Cube(dimensions[0], "Undefined");
        } else if (shapeClass == Cylinder.class) {
            validateDimensions(dimensions, 2, "Cylinder");
            shape = new Cylinder(dimensions[0], dimensions[1], "Undefined");
        } else if (shapeClass == RectangularPrism.class) {
            validateDimensions(dimensions, 3, "Rectangular Prism");
            shape = new RectangularPrism(dimensions[0], dimensions[1], dimensions[2], "Undefined");
        } else if (shapeClass == Tetrahedron.class) {
            validateDimensions(dimensions, 1, "Tetrahedron");
            shape = new Tetrahedron(dimensions[0], "Undefined");
        } else {
            throw new IllegalArgumentException("Unsupported shape class: " + shapeClass.getSimpleName());
        }

        // Apply custom name if a valid string was provided
        if (name != null && !name.trim().isEmpty()) {
            shape.setName(name);
        }

        return shape;
    }

    // Helper method to keep validation DRY (Don't Repeat Yourself)
    private static void validateDimensions(double[] dimensions, int expectedLength, String shapeName) {
        if (dimensions.length != expectedLength) {
            throw new IllegalArgumentException(shapeName + " requires exactly " + expectedLength + " dimension(s). You provided " + dimensions.length + ".");
        }
        for (double dim : dimensions) {
            if (dim < 0) {
                throw new IllegalArgumentException("Dimensions cannot be negative.");
            }
        }
    }
}