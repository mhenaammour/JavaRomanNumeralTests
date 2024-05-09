package com.uca;


public class Start {
    public static void main(String[] args) {
        RomanNumber roman = new RomanNumber("DC");
		RomanNumber roman2 = new RomanNumber("CD");
        System.out.println(roman2.toString());
        System.out.println(roman.toString());

		if (roman.compareTo(roman2) == 0) {
            System.out.println("Les nombres sont egaux");
        } else  {
            System.out.println("Les nombres ne sont pas egaux");
        }
		


        System.out.println("Decimal value of DC: " + roman.doubleValue());
        System.out.println("Roman numeral of 600: " + RomanConverter.getRomanFromNumber(600));










		Tests test = new Tests();
		Tests test1 = new Tests();
		Tests test2 = new Tests();
		Tests test3 = new Tests();
		Tests test4 = new Tests();
		Tests test5 = new Tests();
				

		test.testDecimalToRomanKnownValues();
		test1.testRomanToDecimalKnownValues();
		test2.testNegativeNumberConversion();
		test3.testNumberOutOfRangeConversion();
		test4.testConversionValidity();
		test5.testImproperRomanNumeralRepetitions();
		
        
        



    }

	
}
