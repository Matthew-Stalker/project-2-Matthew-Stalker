package com.csc205.project2;

import com.csc205.project2.shapes.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShapeFactoryDriver {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Shape3D> userShapes = new ArrayList<>();

        System.out.println("=================================================");
        System.out.println("      3D SHAPE ANALYZER (FACTORY EDITION)        ");
        System.out.println("=================================================");

        // 1. Interactive Features using the Factory
        System.out.println("\n--- Part 1: Interactive Shape Creation ---");
        boolean keepBuilding = true;
        while (keepBuilding) {
            System.out.println("\nChoose a shape to create via the Factory:");
            System.out.println("1) Sphere  2) Cube  3) Cylinder  4) Rectangular Prism  5) Tetrahedron  6) Skip to Analysis");
            System.out.print("Selection: ");
            String choice = scanner.nextLine();

            if (choice.equals("6")) {
                keepBuilding = false;
                continue;
            }

            try {
                Shape3D newShape = null;

                // Notice how we use ShapeFactory.create() instead of the 'new' keyword
                switch (choice) {
                    case "1":
                        System.out.print("Enter radius for the Sphere: ");
                        double radius = Double.parseDouble(scanner.nextLine());
                        newShape = ShapeFactory.create(Sphere.class, "", radius);
                        break;
                    case "2":
                        System.out.print("Enter side length for the Cube: ");
                        double side = Double.parseDouble(scanner.nextLine());
                        newShape = ShapeFactory.create(Cube.class, "", side);
                        break;
                    case "3":
                        System.out.print("Enter radius for the Cylinder: ");
                        double cylRadius = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter height for the Cylinder: ");
                        double cylHeight = Double.parseDouble(scanner.nextLine());
                        newShape = ShapeFactory.create(Cylinder.class, "", cylRadius, cylHeight);
                        break;
                    case "4":
                        System.out.print("Enter length for the Prism: ");
                        double length = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter width for the Prism: ");
                        double width = Double.parseDouble(scanner.nextLine());
                        System.out.print("Enter height for the Prism: ");
                        double height = Double.parseDouble(scanner.nextLine());
                        newShape = ShapeFactory.create(RectangularPrism.class, "", length, width, height);
                        break;
                    case "5":
                        System.out.print("Enter side length for the Tetrahedron: ");
                        double tetSide = Double.parseDouble(scanner.nextLine());
                        newShape = ShapeFactory.create(Tetrahedron.class, "", tetSide);
                        break;
                    default:
                        System.out.println("Invalid selection. Try again.");
                        continue;
                }

                // If the factory successfully built the shape, apply properties
                if (newShape != null) {
                    System.out.print("Enter a custom name (or press Enter to keep default '" + newShape.getName() + "'): ");
                    String customName = scanner.nextLine();
                    if (!customName.trim().isEmpty()) {
                        newShape.setName(customName);
                    }

                    System.out.print("Enter a color for your shape: ");
                    String color = scanner.nextLine();
                    newShape.setColor(color);

                    userShapes.add(newShape);
                    System.out.println("--> Factory successfully built a " + newShape.getColor() + " " + newShape.getName() + "!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            } catch (IllegalArgumentException e) {
                // This catches the validation errors thrown by our Factory!
                System.out.println("Factory Error: " + e.getMessage());
            }
        }

        // 2. Polymorphic & Formatted Output
        System.out.println("\n--- Part 2: Polymorphic Printing ---");
        System.out.println("Your Custom Shapes:");
        if (userShapes.isEmpty()) {
            System.out.println("No custom shapes created.");
        } else {
            for (Shape3D shape : userShapes) {
                System.out.println(shape.toString());
            }
        }

        // 3. Comparative Analysis
        System.out.println("\n--- Part 3: Comparative Analysis ---");
        System.out.println("Constraint: If all primary dimensions (radius, side, length) equal 5.0...");

        List<Shape3D> constraintShapes = new ArrayList<>();

        // Creating the baseline shapes using the Factory
        Shape3D s1 = ShapeFactory.create(Sphere.class, "Constraint Sphere", 5.0);
        s1.setColor("Cyan");
        constraintShapes.add(s1);

        Shape3D s2 = ShapeFactory.create(Cube.class, "Constraint Cube", 5.0);
        s2.setColor("Magenta");
        constraintShapes.add(s2);

        Shape3D s3 = ShapeFactory.create(Cylinder.class, "Constraint Cylinder", 5.0, 5.0);
        s3.setColor("Yellow");
        constraintShapes.add(s3);

        Shape3D s4 = ShapeFactory.create(RectangularPrism.class, "Constraint Prism", 5.0, 5.0, 5.0);
        s4.setColor("Black");
        constraintShapes.add(s4);

        Shape3D s5 = ShapeFactory.create(Tetrahedron.class, "Constraint Tetra", 5.0);
        s5.setColor("White");
        constraintShapes.add(s5);

        Shape3D largestVolumeShape = constraintShapes.get(0);
        Shape3D largestSurfaceAreaShape = constraintShapes.get(0);
        Shape3D mostEfficientShape = constraintShapes.get(0);
        double maxEfficiency = constraintShapes.get(0).getVolume() / constraintShapes.get(0).getSurfaceArea();

        System.out.printf("%-20s %-15s %-15s %-20s%n", "SHAPE TYPE", "SURFACE AREA", "VOLUME", "EFFICIENCY (V/SA)");
        System.out.println("-------------------------------------------------------------------------");

        for (Shape3D shape : constraintShapes) {
            double vol = shape.getVolume();
            double sa = shape.getSurfaceArea();
            double efficiency = vol / sa;

            // Trim the name slightly for the table if it's too long
            String displayName = shape.getName().replace("Constraint ", "");

            System.out.printf("%-20s %-15.4f %-15.4f %-20.4f%n",
                    displayName,
                    sa,
                    vol,
                    efficiency);

            if (vol > largestVolumeShape.getVolume()) {
                largestVolumeShape = shape;
            }
            if (sa > largestSurfaceAreaShape.getSurfaceArea()) {
                largestSurfaceAreaShape = shape;
            }
            if (efficiency > maxEfficiency) {
                mostEfficientShape = shape;
                maxEfficiency = efficiency;
            }
        }

        System.out.println("-------------------------------------------------------------------------");
        System.out.printf("LARGEST VOLUME:       %s (%.4f)%n", largestVolumeShape.getName(), largestVolumeShape.getVolume());
        System.out.printf("LARGEST SURFACE AREA: %s (%.4f)%n", largestSurfaceAreaShape.getName(), largestSurfaceAreaShape.getSurfaceArea());
        System.out.printf("MOST EFFICIENT:       %s (Ratio: %.4f)%n", mostEfficientShape.getName(), maxEfficiency);

        // 4. Performance Timing
        System.out.println("\n--- Part 4: Performance Timing ---");
        System.out.println("Calculating volume for the constraint shapes 1,000,000 times...");

        long startTime = System.nanoTime();

        double dummyTotal = 0;
        for (int i = 0; i < 1_000_000; i++) {
            for (Shape3D shape : constraintShapes) {
                dummyTotal += shape.getVolume();
            }
        }

        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        System.out.println("Total operations complete.");
        System.out.println("Time elapsed: " + durationMs + " milliseconds.");

        scanner.close();
    }
}