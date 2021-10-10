package cubes;

import java.util.Objects;

public class Cube {

    private double sideLength;
    private String color;

    public Cube(double sideLength, String color) {
        this.sideLength = sideLength;
        this.color = color;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cube cube = (Cube) o;
        return cube.sideLength == sideLength && color.equals(cube.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sideLength, color);
    }

    @Override
    public String toString() {
        return "Cube{" +
                "sideLength=" + sideLength +
                ", color='" + color + '\'' +
                '}';
    }
}
