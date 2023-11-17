package se.kellygashi.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.kellygashi.main.Triangle;

import java.io.ByteArrayInputStream;

import static org.junit.jupiter.api.Assertions.*;


public class TestTriangle {


    @Test
    @DisplayName("Testing input with length more than 3")
    public void getUserInputInputLength() {
        String[] arr = {"1", "2", "3", "4", "5"};
        Triangle t = new Triangle(arr);
        assertNull(t.getCurrent_type(), "Current type should be null for invalid input length");
    }

    @Test
    @DisplayName("Testing that the input type is correct")
    public void testingCorrectInputType() {
        String[] arr = {"*", "y", "p"};
        Triangle t = new Triangle(arr);
        assertNull(t.getCurrent_type(), "Current type should be null for non-numeric input");
    }


    @Test
    @DisplayName("Testing getUserInput with valid input")
    public void getUserInputValid() {
        String simulatedUserInput = "3,4,5\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(bais);

        Triangle triangle = new Triangle();
        triangle.getUserInput();

        assertEquals(Triangle.TYPE.SCALENE, triangle.getCurrent_type(), "Triangle should be SCALENE for sides 3, 4, 5");

        System.setIn(System.in);
    }



    @Test
    @DisplayName("Testing getUserInput with invalid input")
    public void getUserInputInvalid() {
        String simulatedUserInput = "*,y,p\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(bais);

        Triangle triangle = new Triangle();
        triangle.getUserInput();

        assertNull(triangle.getCurrent_type(), "Current type should be null for invalid input");

        System.setIn(System.in);
    }

    @Test
    @DisplayName("Testing getUserInput with invalid input length")
    public void getUserInputLengthInvalid() {
        String simulatedUserInput = "2,2,4,5\n";
        ByteArrayInputStream bais = new ByteArrayInputStream(simulatedUserInput.getBytes());
        System.setIn(bais);

        Triangle triangle = new Triangle();
        triangle.getUserInput();

        assertNull(triangle.getCurrent_type(), "Current type should be null for invalid input");

        System.setIn(System.in);
    }


    @Test
    @DisplayName("Making sure triangle type ISOSCELES is identified correctly")
    public void getCurrentTypeTriangleTypeIsosceles() {
        Triangle t = new Triangle(3, 3, 5);
        String triangleType = String.valueOf(t.getCurrent_type());

        assertEquals("ISOSCELES", triangleType);
    }

    @Test
    @DisplayName("Boundary test: Triangle with two sides equal to the third")
    public void getCurrentTypeForTriangleEquality() {
        Triangle t = new Triangle(1, 1, 2);
        assertNull(t.getCurrent_type(), "Triangle with sides 1, 1, and 2 should not be valid");
    }

    @Test
    @DisplayName("Making sure triangle type SCALENE is identified correctly")
    public void getCurrentTypeTriangleTypeScalene() {
        Triangle t = new Triangle(3, 4, 5);
        String triangleType = String.valueOf(t.getCurrent_type());

        assertEquals("SCALENE", triangleType);
    }

    @Test
    @DisplayName("Making sure triangle type EQUILATERAL is identified correctly")
    public void getCurrentTypeTriangleTypeEquilateral() {
        Triangle t = new Triangle(3, 3, 3);
        String triangleType = String.valueOf(t.getCurrent_type());

        assertEquals("EQUILATERAL", triangleType);
    }

    @Test
    @DisplayName("Checking if it is not a triangle type with negative values")
    public void getCurrentTypeTriangleTypeNotTriangle() {
        Triangle t = new Triangle(-1, -1, -1);
        String triangleType = String.valueOf(t.getCurrent_type());

        assertEquals("null", triangleType);
    }

    @Test
    @DisplayName("Checking if it is not a triangle type")
    public void getCurrentTypeTriangleTypeNotTriangleTwo() {
        Triangle t = new Triangle(1, 1, 3);
        String triangleType = String.valueOf(t.getCurrent_type());

        assertEquals("null", triangleType);
    }
}
