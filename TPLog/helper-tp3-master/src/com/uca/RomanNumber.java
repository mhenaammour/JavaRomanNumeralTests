package com.uca;

public class RomanNumber extends Number  implements Comparable<RomanNumber> {
    private String roman;
    private int value;

    public RomanNumber(String roman) {
        this.roman = roman;
        this.value = RomanConverter.getNumberFromRoman(roman);
    }

    public RomanNumber(int value) {
        this.value = value;
        this.roman = RomanConverter.getRomanFromNumber(value);
    }

    public RomanNumber(int value, String roman) {
        this.value = value;
        this.roman = roman;
    }

    public String getRoman() {
        return roman;
    }

    public int getValue() {
        return value;
    }

    public void setRoman(String roman) {
        this.roman = roman;
        this.value = RomanConverter.getNumberFromRoman(roman);
    }

    public void setValue(int value) {
        this.value = value;
        this.roman = RomanConverter.getRomanFromNumber(value);
    }

    @Override
    public double doubleValue() {
        return (double) value;
    }

    @Override
    public float floatValue() {
        return (float) value;
    }

    @Override
    public int intValue() {
        return value;
    }

    @Override
    public long longValue() {
        return (long) value;
    }

    @Override
    public String toString() {
        return roman;
    }
     @Override
    public int compareTo(RomanNumber other) {
        return Integer.compare(this.value, other.value);
    }
}
