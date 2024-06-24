public class Rectangle {
    private double width;
    private double height;

    // Constructor
    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // Method to calculate the area of the rectangle
    public double calculateArea() {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Width and height must be positive values.");
        }
        return width * height;
    }

    // Getters (No Setters to align with the requirement)
    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
}
