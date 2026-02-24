
/**
 * Write a description of class CircleCylinder here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
class Circle {
    //private instant variables
    private double radius;
    private String color;
    //default constractor
    public Circle () { 
    }
    //constructor with radius
    public Circle(double radius) {
        this.radius = radius;
    }
    //constructor with radius and color
    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }
    //getters and setters
    public double getradius() {
        return radius;
    }
    public void setradius (double radius) {
        this.radius = radius;
    }
    public String getcolor () {
        return color;
    }
    public void setcolor (String color) {
        this.color = color;
    }
    //calculate area
    public double getArea() {
        return Math.PI * radius * radius;
    }
    // tostring method
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", color=" + color + "]";
    }
}
// ============================================================
// PART B: The Cylinder Class (Subclass of Circle)
// ============================================================
class Cylinder extends Circle {
    //private instant variable
    private double height = 1.0;
    // default constructor
    public Cylinder() {
        super();
    }
    // Constructor with radius
    public Cylinder(double radius) {
        super(radius);
    }
    // Constructor with radius and height
    public Cylinder(double radius, double height) {
        super(radius);
        this.height = height;
    }
    // Constructor with radius, height and color
    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;
    }
    //Getter and Setter
    public double getheight() {
        return height;
    }
    public void setheight (double height) {
        this.height = height;
    }
    // calculate volume
    public double getVolume()  {
        return getArea() * height;
    }
    //Override to String()
    @Override
    public String toString() {
        return "Cylinder[" + super.toString() + ", height=" + height + "]";
    }
}
// ============================================================
// PART C: Test Driver - Upcasting and Downcasting
// ============================================================
public class Lab1_CircleCylinder {
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("Lab 1: Circle and Cylinder Hierachy");
        System.out.println("======================================");
        //Section 1
        System.out.println("Section 1: Basic Object Creation ------");
        Circle c1 = new Circle(5.0, "Blue");
        System.out.println("Circle: " + c1);
        System.out.println("Area: " + c1.getArea());
        Cylinder cy1 = new Cylinder(5.0, 20, "Green");
        System.out.println("Cylinder: " + cy1);
        System.out.println("Base Area: " + cy1.getArea());
        System.out.println("Volume: " + cy1.getVolume());
        
        //Section 2
        System.out.println("Section 2: Upcasting -------------"); 
        Circle c2 = new Cylinder(3.0, 7.0, "yellow");
        System.out.println("c2 is a: " + c2.getClass().getSimpleName());
        System.out.println("c2.toString(): " + c2);
        System.out.println("c2.getArea(): " + c2.getArea());
        System.out.println("c2.getRadius(): " + c2.getradius());
        // System.out.println("c2.getVolume(): " + c2.getVolume());
        // ANSWER:
        // Compile-time error.
        // getVolume() is not defined in Circle.
        // Even though the object is Cylinder at runtime,
        // the reference type is Circle.


        // ----- Section 3 -----
        System.out.println("Section 3: Downcasting ");

        Circle c3 = new Cylinder(4.0, 8.0, "Purple");
        Cylinder cy2 = (Cylinder) c3;
        System.out.println("After downcast: " + cy2);
        System.out.println("Now we can call getVolume(): " + cy2.getVolume());

        // Circle c4 = new Circle(2.0);
        // Cylinder cy3 = (Cylinder) c4;
        // ANSWER:
        // Runtime error: ClassCastException.
        // A Circle object is NOT a Cylinder object.


        // ----- Section 4 -----
        System.out.println("\n--- Section 4: instanceof Operator ---");

        Circle[] shapes = {
            new Circle(2.0, "red"),
            new Cylinder(3.0, 5.0, "blue"),
            new Circle(4.0, "green"),
            new Cylinder(1.0, 10.0, "orange")
        };

        for (Circle shape : shapes) {

            System.out.println(shape);

            if (shape instanceof Cylinder) {
                Cylinder temp = (Cylinder) shape;
                System.out.println("  -> This is a Cylinder! Volume = " + temp.getVolume());
            } else {
                System.out.println("  -> This is just a Circle. Area = " + shape.getArea());
            }
        }

        System.out.println("\n========================================");
        System.out.println("  End of Lab 1");
        System.out.println("========================================");
    }
}


/*
 * QUESTIONS & ANSWERS
 *
 * 1. Why does c2.toString() print "Cylinder[...]" even though c2 is declared as Circle?
 *    Because Java uses runtime polymorphism (dynamic method dispatch).
 *    The actual object is a Cylinder, so the overridden toString()
 *    method in Cylinder is executed.
 *
 * 2. Why can't we call c2.getVolume() when c2 references a Cylinder object?
 *    Because the reference type is Circle.
 *    At compile-time, Java only allows methods defined in Circle.
 *
 * 3. What is the difference between compile-time type and runtime type?
 *    Compile-time type: The declared type of the reference variable (Circle c2).
 *    Runtime type: The actual object created in memory (new Cylinder(...)).
 *
 * 4. When would you use instanceof in a real application?
 *    When working with collections of parent-class objects
 *    and you need to safely determine the actual object type
 *    before performing downcasting.
 */       