package day02;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MathAlgorithmsTest {

    private MathAlgorithms algorithms = new MathAlgorithms();

    @Test
    void greatestCommonDivisorTest() {
        assertEquals(16, algorithms.greatestCommonDivisor(48, 80));
        assertEquals(3, algorithms.greatestCommonDivisor(9, -24));
        assertEquals(1, algorithms.greatestCommonDivisor(6, 35));
    }

    @Test
    void greatestCommonDivisorSimplerTest() {
        assertEquals(16, algorithms.greatestCommonDivisorSimpler(48, 80));
        assertEquals(3, algorithms.greatestCommonDivisorSimpler(9, -24));
        assertEquals(1, algorithms.greatestCommonDivisorSimpler(6, 35));
    }

    @Test
    void greatestCommonDivisorEuclidesTest() {
        assertEquals(16, algorithms.greatestCommonDivisorEuclides(48, 80));
        assertEquals(3, algorithms.greatestCommonDivisorEuclides(9, -24));
        assertEquals(1, algorithms.greatestCommonDivisorEuclides(6, 35));
    }

    @Test
    void greatestCommonDivisorTestWithZeroParameter() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> algorithms.greatestCommonDivisor(0, 45));
        assertEquals("None of the numbers can be zero!", iae.getMessage());
    }

    @Test
    void greatestCommonDivisorSimplerTestWithZeroParameter() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> algorithms.greatestCommonDivisorSimpler(0, 45));
        assertEquals("None of the numbers can be zero!", iae.getMessage());
    }

    @Test
    void greatestCommonDivisorEuclidesTestWithZeroParameter() {
        IllegalArgumentException iae = assertThrows(IllegalArgumentException.class, () -> algorithms.greatestCommonDivisorEuclides(0, 45));
        assertEquals("None of the numbers can be zero!", iae.getMessage());
    }
}