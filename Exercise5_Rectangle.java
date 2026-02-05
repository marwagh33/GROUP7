/**
 * EXERCISE 5: Rectangle Class (Geometry)
 * PT821: Object-Oriented Programming - Classes and Objects
 *
 * TASK: Complete the Rectangle class for geometric calculations
 *
 * Requirements:
 * 1. Add the following private attributes:
 *    - length (double)
 *    - width (double)
 *    - color (String)
 *    - isFilled (boolean)
 *
 * 2. Create constructors:
 *    - Default constructor (length=1, width=1, color="white", isFilled=false)
 *    - Constructor with length and width only
 *    - Full parameterized constructor
 *
 * 3. Add getters for all attributes
 *
 * 4. Add setters with validation:
 *    - length must be > 0
 *    - width must be > 0
 *
 * 5. Add behavior methods:
 *    - calculateArea() - returns length * width
 *    - calculatePerimeter() - returns 2 * (length + width)
 *    - calculateDiagonal() - returns sqrt(length^2 + width^2)
 *    - isSquare() - returns true if length equals width
 *    - resize(double factor) - multiplies both dimensions by factor
 *    - compare(Rectangle other) - returns "larger", "smaller", or "equal" based on area
 *    - displayInfo() - shows all rectangle details with calculations
 *
 * 6. Test your class with at least 3 rectangles
 *
 * HINT: Use Math.sqrt() for square root and Math.pow() for power
 */
public class Exercise5_Rectangle {
    private double length;
    private double width;
    private String color;
    private boolean isFilled;
    
    public Exercise5_Rectangle() {
        this.length=1;
        this.width=1;
        this.color="white";
        this.isFilled=false;
    }
    public Exercise5_Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        this.color = "white";
        this.isFilled = false;
    }
    public Exercise5_Rectangle(double length, double width, String color, boolean isFilled) {
        this.length = length;
        this.width = width;
        this.color = color;
        this.isFilled = isFilled;
    }
    //getter 
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    //setter for length
     public void setLength(double length) {
        if (length > 0) {
            this.length = length;
        } else {
            System.out.println("Length must be greater than 0");
        }
    }
//setter for width 
    public void setWidth(double width) {
        if (width > 0) {
            this.width = width;
        } else {
            System.out.println("Width must be greater than 0");
        }
    }
    //calulate and return area
    public double calculateArea() {
        return length * width;
    }
  //calulate and return parameter
    public double calculatePerimeter() {
        return 2 * (length + width);
    }
//calulate and return diagonal 
    public double calculateDiagonal() {
        return Math.sqrt(Math.pow(length, 2) + Math.pow(width, 2));
    }
//calulate and return square
    public boolean isSquare() {
        return length == width;
    }
    //calulate and return resize 
    public void resize(double factor) {
        if (factor > 0) {
            length *= factor;
            width *= factor;
        } else {
            System.out.println("Resize factor must be greater than 0");
        }
    }
    //comparison between area1 and area2

    public String compare(Exercise5_Rectangle other) {
        double area1 = this.calculateArea();
        double area2 = other.calculateArea();

        if (area1 > area2) {
            return "larger";
        } else if (area1 < area2) {
            return "smaller";
        } else {
            return "equal";
        }
    }
    //display geometry exercise 

    public static void main(String[] args) {
        System.out.println("=== Rectangle Geometry Exercise ===\n");
        Exercise5_Rectangle rect1 = new Exercise5_Rectangle();
        Exercise5_Rectangle rect2 = new Exercise5_Rectangle(10,15);
        Exercise5_Rectangle rect3 = new Exercise5_Rectangle(7,7, "blue",true);
        System.out.println("Rectangle1 Details:");
        System.out.println("Length: " + rect1.getLength());
        System.out.println("Width: " + rect1.getWidth());
        System.out.println("Color: " + rect1.getColor());
        System.out.println("Filled: " + rect1.isFilled());
        System.out.println("Area: " + rect1.calculateArea());
        System.out.println("Perimeter: " + rect1.calculatePerimeter());
        System.out.println("Diagonal: " + rect1.calculateDiagonal());
        System.out.println("Is Square: " + rect1.isSquare());
        System.out.println("Rectangle2 Details:");
        System.out.println("Length: " + rect2.getLength());
        System.out.println("Width: " + rect2.getWidth());
        System.out.println("Color: " + rect2.getColor());
        System.out.println("Filled: " + rect2.isFilled());
        System.out.println("Area: " + rect2.calculateArea());
        System.out.println("Perimeter: " + rect2.calculatePerimeter());
        System.out.println("Diagonal: " + rect2.calculateDiagonal());
        System.out.println("Is Square: " + rect2.isSquare());
        System.out.println("Rectangle3 Details:");
        System.out.println("Length: " + rect3.getLength());
        System.out.println("Width: " + rect3.getWidth());
        System.out.println("Color: " + rect3.getColor());
        System.out.println("Filled: " + rect3.isFilled());
        System.out.println("Area: " + rect3.calculateArea());
        System.out.println("Perimeter: " + rect3.calculatePerimeter());
        System.out.println("Diagonal: " + rect3.calculateDiagonal());
        System.out.println("Is Square: " + rect3.isSquare());
        System.out.println("rect1 is square? " + rect1.isSquare());
        System.out.println("rect2 is square? " + rect2.isSquare());
        System.out.println("rect3 is square? " + rect3.isSquare());
        System.out.println("rect1 compared to rect2: " + rect1.compare(rect2));
        rect1.resize(3);
        double totalArea = rect1.calculateArea() + rect2.calculateArea() + rect3.calculateArea();
        System.out.println("Total area of rect1, rect2, and rect3: " + totalArea);
        System.out.println("\n=== Exercise Complete ===");
    }
}
