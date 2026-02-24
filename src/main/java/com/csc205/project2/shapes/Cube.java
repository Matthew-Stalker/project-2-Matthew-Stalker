package com.csc205.project2.shapes;

public class Cube extends Shape3D {

    private double sideLength;

    public Cube() {
        super("Cube", "Undefined");
        this.sideLength = 0.0;
    }

    public Cube(double sideLength, String color) {
        super("Cube", color);
        if (sideLength < 0) {
            throw new IllegalArgumentException("Side length cannot be negative.");
        }
        this.sideLength = sideLength;
    }

    @Override
    protected double calculateSurfaceArea() {
        return 6.0 * Math.pow(sideLength, 2);
    }

    @Override
    protected double calculateVolume() {
        return Math.pow(sideLength, 3);
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        if (sideLength < 0) {
            throw new IllegalArgumentException("Side length cannot be negative.");
        }
        this.sideLength = sideLength;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Cube {");
        sb.append("sideLength=").append(sideLength);
        sb.append(", ").append(super.toString().replace("Cube {", "").replace("Unknown Shape {", ""));
        return sb.toString();
    }
}