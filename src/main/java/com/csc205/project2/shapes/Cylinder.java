package com.csc205.project2.shapes;

public class Cylinder extends Shape3D {

    private double radius;
    private double height;

    public Cylinder() {
        super("Cylinder", "Undefined");
        this.radius = 0.0;
        this.height = 0.0;
    }

    public Cylinder(double radius, double height, String color) {
        super("Cylinder", color);
        if (radius < 0 || height < 0) {
            throw new IllegalArgumentException("Dimensions cannot be negative.");
        }
        this.radius = radius;
        this.height = height;
    }

    @Override
    protected double calculateSurfaceArea() {
        return 2.0 * Math.PI * radius * height + 2.0 * Math.PI * Math.pow(radius, 2);
    }

    @Override
    protected double calculateVolume() {
        return Math.PI * Math.pow(radius, 2) * height;
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

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0) {
            throw new IllegalArgumentException("Height cannot be negative.");
        }
        this.height = height;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cylinder {");
        sb.append("radius=").append(radius);
        sb.append(", height=").append(height);
        sb.append(", ").append(super.toString().replace("Cylinder {", "").replace("Unknown Shape {", ""));
        return sb.toString();
    }
}