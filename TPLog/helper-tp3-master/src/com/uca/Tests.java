package com.uca;

import org.junit.jupiter.api.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {

    // Tests de réussite
    @Test
    public void testDecimalToRomanKnownValues() {
        assertEquals("I", RomanConverter.getRomanFromNumber(1));
        assertEquals("IV", RomanConverter.getRomanFromNumber(4));
        assertEquals("IX", RomanConverter.getRomanFromNumber(9));
        assertEquals("XL", RomanConverter.getRomanFromNumber(40));
        assertEquals("L", RomanConverter.getRomanFromNumber(50));
        assertEquals("XC", RomanConverter.getRomanFromNumber(90));
        assertEquals("C", RomanConverter.getRomanFromNumber(100));
        assertEquals("CD", RomanConverter.getRomanFromNumber(400));
        assertEquals("D", RomanConverter.getRomanFromNumber(500));
        assertEquals("CM", RomanConverter.getRomanFromNumber(900));
        assertEquals("M", RomanConverter.getRomanFromNumber(1000));
    }

    @Test
    public void testRomanToDecimalKnownValues() {
        assertEquals(1, RomanConverter.getNumberFromRoman("I"));
        assertEquals(4, RomanConverter.getNumberFromRoman("IV"));
        assertEquals(9, RomanConverter.getNumberFromRoman("IX"));
        assertEquals(40, RomanConverter.getNumberFromRoman("XL"));
        assertEquals(50, RomanConverter.getNumberFromRoman("L"));
        assertEquals(90, RomanConverter.getNumberFromRoman("XC"));
        assertEquals(100, RomanConverter.getNumberFromRoman("C"));
        assertEquals(400, RomanConverter.getNumberFromRoman("CD"));
        assertEquals(500, RomanConverter.getNumberFromRoman("D"));
        assertEquals(900, RomanConverter.getNumberFromRoman("CM"));
        assertEquals(1000, RomanConverter.getNumberFromRoman("M"));
    }

    // Tests d'échec
    @Test
    public void testNegativeNumberConversion() {
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.getRomanFromNumber(-1));
    }

    @Test
    public void testNumberOutOfRangeConversion() {
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.getRomanFromNumber(4000));
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.getRomanFromNumber(0));
    }

    @Test
    public void testImproperRomanNumeralRepetitions() {
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.getNumberFromRoman("IIII"));
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.getNumberFromRoman("VV"));
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.getNumberFromRoman("XXXX"));
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.getNumberFromRoman("LL"));
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.getNumberFromRoman("CCCC"));
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.getNumberFromRoman("DD"));
        assertThrows(IllegalArgumentException.class, () -> RomanConverter.getNumberFromRoman("MMMM"));
    }

    // Tests de validité
    @Test
    public void testConversionValidity() {
        for (int i = 1; i <= 3999; i++) {
            String roman = RomanConverter.getRomanFromNumber(i);
            int result = RomanConverter.getNumberFromRoman(roman);
            assertEquals(i, result);
        }
    }
}
