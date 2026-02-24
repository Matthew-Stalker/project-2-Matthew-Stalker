package com.csc205.project2.shapes;

public class Tetrahedron extends Shape3D {

    private double sideLength;

    public Tetrahedron() {
        super("Tetrahedron", "Undefined");
        this.sideLength = 0.0;
    }

    public Tetrahedron(double sideLength, String color) {
        super("Tetrahedron", color);
        if (sideLength < 0) {
            throw new IllegalArgumentException("Side length cannot be negative.");
        }
        this.sideLength = sideLength;
    }

    @Override
    protected double calculateSurfaceArea() {
        return Math.sqrt(3.0) * Math.pow(sideLength, 2);
    }

    @Override
    protected double calculateVolume() {
        return Math.pow(sideLength, 3) / (6.0 * Math.sqrt(2.0));
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
        final StringBuilder sb = new StringBuilder("Tetrahedron {");
        sb.append("sideLength=").append(sideLength);
        sb.append(", ").append(super.toString().replace("Tetrahedron {", "").replace("Unknown Shape {", ""));
        return sb.toString();
    }
}