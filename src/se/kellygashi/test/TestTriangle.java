package se.kellygashi.test;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import se.kellygashi.main.Triangle;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestTriangle {

    @Test
    @DisplayName("Making sure triangle type ISOSCELES is identified correctly")
    public void getUserInputCorrectTriangleTypeIsosceles() {
        Triangle t = new Triangle(3,3,5);
        t.getUserInput();
        String triangleType = String.valueOf(t.getCurrent_type());

        assertEquals("ISOSCELES", triangleType);
    }

    @Test
    @DisplayName("Making sure triangle type ISOSCELES is identified correctly")
    public void getUserInputCorrectTriangleTypeScalene() {
        Triangle t = new Triangle(3,4,5);
        t.getUserInput();
        String triangleType = String.valueOf(t.getCurrent_type());

        assertEquals("SCALENE", triangleType);
    }
}
