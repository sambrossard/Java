package com.thealgorithms.maths;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class PowTest {
    @ParameterizedTest
    @CsvSource({"2, 0, 1", "0, 2, 0", "2, 10, 1024", "10, 2, 100", "5, 3, 125", "3, 4, 81"})
    void testPow(int base, int exponent, long expected) {
        assertEquals(expected, Pow.pow(base, exponent), "Failed for base: " + base + " and exponent: " + exponent);
    }

    @Test
    void testPowThrowsExceptionForNegativeExponent() {
        assertThrows(IllegalArgumentException.class, () -> Pow.pow(2, -1));
    }

    @Test
    void testPowHandlesLargeNumbers() {
        assertEquals(1048576, Pow.pow(2, 20));
    }

    @Test
    void testPowHandlesZeroBase() {
        assertEquals(0, Pow.pow(0, 5));
    }

    @Test
    void testPowHandlesOneBase() {
        assertEquals(1, Pow.pow(1, 100));
    }

    @ParameterizedTest
    @CsvSource({"2, 62, 4611686018427387904", "-2, 63, -9223372036854775808", "-3, 3, -27", "-2, 4, 16", "10, 18, 1000000000000000000"})
    void testPowAtAndNearLongBounds(int base, int exponent, long expected) {
        assertEquals(expected, Pow.pow(base, exponent));
    }

    @ParameterizedTest
    @CsvSource({"2, 63", "2, 64", "-2, 64", "10, 19", "2147483647, 3"})
    void testPowThrowsOnOverflow(int base, int exponent) {
        assertThrows(ArithmeticException.class, () -> Pow.pow(base, exponent));
    }
}
