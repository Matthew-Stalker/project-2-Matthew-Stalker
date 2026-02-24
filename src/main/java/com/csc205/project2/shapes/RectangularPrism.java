package com.csc205.project2.shapes;

public class RectangularPrism extends Shape3D {

    private double length;
    private double width;
    private double height;

    public RectangularPrism() {
        super("Rectangular Prism", "Undefined");
        this.length = 0.0;
        this.width = 0.0;
        this.height = 0.0;
    }

    public RectangularPrism(double length, double width, double height, String color) {
        super("Rectangular Prism", color);
        if (length < 0 || width < 0 || height < 0) {
            throw new IllegalArgumentException("Dimensions cannot be negative.");
        }
        this.length = length;
        this.width = width;
        this.height = height;
    }

    @Override
    protected double calculateSurfaceArea() {
        return 2.0 * (length * width + length * height + width * height);
    }

    @Override
    protected double calculateVolume() {
        return length * width * height;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        if (length < 0) {
            throw new IllegalArgumentException("Length cannot be negative.");
        }
        this.length = length;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        if (width < 0) {
            throw new IllegalArgumentException("Width cannot be negative.");
        }
        this.width = width;
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
        final StringBuilder sb = new StringBuilder("RectangularPrism {");
        sb.append("length=").append(length);
        sb.append(", width=").append(width);
        sb.append(", height=").append(height);
        sb.append(", ").append(super.toString().replace("Rectangular Prism {", "").replace("Unknown Shape {", ""));
        return sb.toString();
    }
}