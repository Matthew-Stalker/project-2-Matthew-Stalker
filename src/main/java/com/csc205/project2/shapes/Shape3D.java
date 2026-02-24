package com.csc205.project2.shapes;

public abstract class Shape3D implements ThreeDimensionalShape {

    // 3. Common properties
    private String name;
    private String color;

    // 4. Constructors for initialization
    public Shape3D() {
        this.name = "Unknown Shape";
        this.color = "Undefined";
    }

    public Shape3D(String name, String color) {
        this.name = name;
        this.color = color;
    }

    // Abstract methods to be implemented by concrete subclasses
    protected abstract double calculateSurfaceArea();
    protected abstract double calculateVolume();

    // 2. Concrete implementations of interface methods calling abstract methods
    @Override
    public double getSurfaceArea() {
        return calculateSurfaceArea();
    }

    @Override
    public double getVolume() {
        return calculateVolume();
    }

    // 3 & 6. Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // 5. A toString() method that formats information consistently
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(name)
                .append(" {")
                .append("color='").append(color).append('\'')
                .append(", surfaceArea=").append(String.format("%.4f", getSurfaceArea()))
                .append(", volume=").append(String.format("%.4f", getVolume()))
                .append('}');
        return sb.toString();
    }
}
