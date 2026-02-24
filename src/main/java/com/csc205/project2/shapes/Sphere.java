package com.csc205.project2.shapes;

public class Sphere extends Shape3D {

    private double radius;

    public Sphere() {
        super("Sphere", "Undefined");
        this.radius = 0.0;
    }

    public Sphere(double radius, String color) {
        super("Sphere", color);
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        this.radius = radius;
    }

    @Override
    protected double calculateSurfaceArea() {
        return 4.0 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    protected double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(radius, 3);
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        if (radius < 0) {
            throw new IllegalArgumentException("Radius cannot be negative.");
        }
        this.radius = radius;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Sphere {");
        sb.append("radius=").append(radius);
        sb.append(", ").append(super.toString().replace("Sphere {", "").replace("Unknown Shape {", ""));
        return sb.toString();
    }
}